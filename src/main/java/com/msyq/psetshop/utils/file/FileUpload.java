package com.msyq.psetshop.utils.file;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * 文件上传工具
 * */
@RestController
public class FileUpload {

//    图片检测
    /**
     * 需要验证别的文件类型，另加
     * 验证文件名后缀
     * */
    String fileSuffix = "jpgpnggif";
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("/yyyy/MM/dd/");

    @PostMapping("/upload")
    public Map<String, Object> fileupload(MultipartFile file, HttpServletRequest request){
        Map<String, Object> result = new HashMap<>();
        String origName = file.getOriginalFilename();
        if (!fileSuffix.contains(origName.substring(origName.lastIndexOf(".")+1))){
            result.put("status","error");
            result.put("msg","文件类型不对");
            return result;
        }
        //   获取当前时间
        String date = simpleDateFormat.format(new Date());
        String realpath = request.getServletContext().getRealPath("/") + date;
        File folder = new File(realpath);
        if (!folder.exists()){
            folder.mkdirs();
        }
        String newName = UUID.randomUUID().toString() + "." + origName.substring(origName.lastIndexOf(".")+1);
        try {
            file.transferTo(new File(folder, newName));
            String url = request.getScheme() + "://" + request.getServerName() + ":" +request.getServerPort() + date + newName;
            result.put("status","error");
            result.put("msg",url);
        }catch (IOException e){
            result.put("status","error");
            result.put("msg",e.getMessage());
        }
        return result;
    }
}
