package com.msyq.psetshop.utils.aop.logAnnotation;

import com.alibaba.fastjson.JSON;
//import com.cuzj.backstage.demo.entity.OperationLog;
//import com.cuzj.backstage.demo.service.OperationLogService;
//import com.cuzj.backstage.demo.utils.http.HttpContextutils;
import com.msyq.psetshop.pojo.AdimLog;
import com.msyq.psetshop.pojo.UserLog;
import com.msyq.psetshop.service.AdimLogService;
import com.msyq.psetshop.service.AdimService;
import com.msyq.psetshop.service.UserLogService;
import com.msyq.psetshop.service.UsersService;
import com.msyq.psetshop.utils.http.IPUtils;
import com.msyq.psetshop.utils.http.HttpContextutils;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Array;
import java.lang.reflect.Method;
import java.util.ArrayList;


@Component
@Aspect //设置切面  定义了通知和切点关系
@Slf4j //用于记录日志
public class LogAspect {

    public static LogAspect logAspect;

    @Autowired
    private UserLogService userLogService;

    @Autowired
    private AdimLogService adimLogService;
    
    @Autowired
    private UsersService usersService;
    
    @Autowired
    private AdimService adimService;

    @PostConstruct
    public void init(){
        logAspect = this;
        logAspect.adimLogService = this.adimLogService;
        logAspect.userLogService = this.userLogService;
        logAspect.adimService = this.adimService;
        logAspect.usersService = this.usersService;
    }

//    @Autowired
//    private OperationLogService operationLogService;
//    OperationLog operationLog;
    //    切点
    @Pointcut("@annotation(com.msyq.psetshop.utils.aop.logAnnotation.LogAnnotation)")
    public void pt(){}

//    环绕通知
    @Around(value = "pt()")
    public Object log(ProceedingJoinPoint joinPoint) throws Throwable {

        long beginTime = System.currentTimeMillis();
//        执行方法
        Object result = joinPoint.proceed();
//        执行时间（毫秒）
        long time = System.currentTimeMillis() - beginTime;
//        保存日志
        recordLog(joinPoint,time);

        return result;
    }

    private void recordLog(ProceedingJoinPoint joinPoint, long time){

        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();

        LogAnnotation logAnnotation = method.getAnnotation(LogAnnotation.class);

        log.info("===========log start==========");
        log.info("module:{}",logAnnotation.module());
        log.info("operation:{}",logAnnotation.operator());

//        请求方法
        String className = joinPoint.getTarget().getClass().getName();
        String methodName = signature.getName();
        log.info("request method:{}",className + "." +methodName + "()");

//        请求参数
        Object[] args = joinPoint.getArgs();
        String[] argNames = ((MethodSignature)joinPoint.getSignature()).getParameterNames();
//        String[] argsConent = new String[]{};
        ArrayList<String> argsConent = new ArrayList<String>();
        for (Object str: args){
            argsConent.add(JSON.toJSONString(str));
        }
        String params = JSON.toJSONString(args[0]);
        log.info("params:{}",argNames);
        log.info("params2:{}",args);

        String str = "=>";
        for (int i=0; i<args.length; i++ ){
            str += String.valueOf(args[i]);
        }
        log.info("params3:{}",str);

//        获取request  设置IP地址
        HttpServletRequest request = HttpContextutils.getHttpServletRequest();
        log.info("ip:{}", IPUtils.getIpAddr(request));

        log.info("excute time:{} ms",time);
        log.info("=========== log end ==========");

        try {
            Integer fkId = Integer.valueOf(argsConent.get(0));

            if (usersService.selectByPrimaryKey(fkId) != null){

                UserLog userLog = new UserLog();
                userLog.setFkUId(fkId);
                userLog.setUlIp(IPUtils.getIpAddr(request));
                userLog.setUlContent("module:" + logAnnotation.module() + ";"
                + "operation:" + logAnnotation.operator() + ";"
                + "request method:" + className + "." +methodName + "()" +";"
                        +"params:"+str +";"
                +"excute time:" + time);

                logAspect.userLogService.insertSelective(userLog);

            }else if (adimService.selectByPrimaryKey(fkId) != null){
                AdimLog adimLog = new AdimLog();
                adimLog.setFkAId(fkId);
                adimLog.setAlIp(IPUtils.getIpAddr(request));
                adimLog.setAlContent("module:" + logAnnotation.module() + ";"
                        + "operation:" + logAnnotation.operator() + ";"
                        + "request method:" + className + "." +methodName + "()" +";"
                        +"params:"+ str +";"
                        +"excute time:" + time);
                logAspect.adimLogService.insertSelective(adimLog);
            }

        }catch (Exception r){
            System.out.println("fkId有误");
        }

    }

}
