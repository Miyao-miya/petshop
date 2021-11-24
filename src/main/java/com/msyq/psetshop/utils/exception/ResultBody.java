package com.msyq.psetshop.utils.exception;


import com.alibaba.fastjson.JSONObject;
import com.msyq.psetshop.pojo.Error;
import com.msyq.psetshop.service.ErrorService;
import com.msyq.psetshop.utils.http.HttpContextutils;
import com.msyq.psetshop.utils.http.IPUtils;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import sun.text.normalizer.UBiDiProps;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;

@Data
@Component
public class ResultBody {

    /**
     * 响应代码
     */
    private String code;

    /**
     * 响应消息
     */
    private String message;

    /**
     * 错误原因
     * */
    private String errCause;

    /**
     * 响应结果
     */
    private Object result;


    @Autowired
    private ErrorService errorService;

    public static ResultBody resultBody;

    @PostConstruct
    public void init(){
        resultBody = this;
        resultBody.errorService = this.errorService;
    }


    public ResultBody() {
    }

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }


    /**
     * 成功
     *
     * @return
     */
    public static ResultBody success() {
        return success(null);
    }

    /**
     * 成功
     * @param data
     * @return
     */
    public static ResultBody success(Object data) {
        ResultBody rb = new ResultBody();
        rb.setCode(CommonEnum.SUCCESS.getResultCode());
        rb.setMessage(CommonEnum.SUCCESS.getResultMsg());
        rb.setResult(data);
        rb.setErrCause(null);

        try {
            HttpServletRequest request = HttpContextutils.getHttpServletRequest();
            Error errors = new Error();
            errors.setEIp(IPUtils.getIpAddr(request));
            errors.setENumber(CommonEnum.SUCCESS.getResultCode());
            errors.setEContent(String.valueOf(data));
            resultBody.errorService.insertSelective(errors);
        }catch (Exception e){
            System.out.println("error的sql写入异常");
        }
        System.out.println(rb);
        return rb;
    }

    /**
     * 失败
     */
    public static ResultBody error(BaseErrorInfoInterface errorInfo, String e) {
        ResultBody rb = new ResultBody();
        rb.setCode(errorInfo.getResultCode());
        rb.setMessage(errorInfo.getResultMsg());
        rb.setErrCause(e);
        rb.setResult(null);
        try {
            HttpServletRequest request = HttpContextutils.getHttpServletRequest();
            Error errors = new Error();
            errors.setEIp(IPUtils.getIpAddr(request));
            errors.setENumber(errorInfo.getResultCode());
            errors.setEContent(e);
            resultBody.errorService.insertSelective(errors);
        }catch (Exception er){
            System.out.println("error的sql写入异常");
        }
        System.out.println(rb);
        return rb;
    }

    /**
     * 失败
     */
    public static ResultBody error(String code, String message, String e) {
        ResultBody rb = new ResultBody();
        rb.setCode(code);
        rb.setMessage(message);
        rb.setErrCause(e);
        rb.setResult(null);
        try {
            HttpServletRequest request = HttpContextutils.getHttpServletRequest();
            Error errors = new Error();
            errors.setEIp(IPUtils.getIpAddr(request));
            errors.setENumber(code);
            errors.setEContent(e);
            resultBody.errorService.insertSelective(errors);
        }catch (Exception er){
            System.out.println("error的sql写入异常");
        }
        System.out.println(rb);
        return rb;
    }

    /**
     * 失败
     */
    public static ResultBody error( String message) {
        ResultBody rb = new ResultBody();
        rb.setCode("-1");
        rb.setMessage(message);
        rb.setResult(null);
        try {
            HttpServletRequest request = HttpContextutils.getHttpServletRequest();
            Error errors = new Error();
            errors.setEIp(IPUtils.getIpAddr(request));
            errors.setENumber("-1");
            errors.setEContent(message);
            resultBody.errorService.insertSelective(errors);
        }catch (Exception e){
            System.out.println("error的sql写入异常");
        }
        return rb;
    }

    @Override
    public String toString() {
        return JSONObject.toJSONString(this);
    }

}
