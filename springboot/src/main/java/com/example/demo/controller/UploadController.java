package com.example.demo.controller;

import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.sql.Timestamp;

@RestController
@RequestMapping
public class UploadController {

    @PostMapping("/upload")
    public String fileUpload(@RequestParam("file") MultipartFile file){
        System.out.println("文件上传");
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        String timestampString=timestamp.getTime()+"";
        String fileName=file.getOriginalFilename()+"";
        String fileTypesName=fileName.substring(file.getOriginalFilename().lastIndexOf("."));
        try {
            String path = ResourceUtils.getURL("classpath:").getPath();
            System.out.println(fileTypesName);
            String imagePath="C:\\Users\\www\\Desktop\\demo\\src\\main\\resources\\static\\image\\"+timestampString+fileTypesName;
            file.transferTo(new java.io.File(imagePath));
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("已上传");
        return "http:\\localhost:8888/image/"+timestampString+fileTypesName;
    }
}
