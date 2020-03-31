package com.wang.blog.controller;


import com.wang.blog.utils.TimeUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@RestController
@CrossOrigin
@RequestMapping("file/")
public class FileController {

    private static Logger logger = LoggerFactory.getLogger(FileController.class);

    @GetMapping("/upload")
    private String upload() {
        return "上传失败！";
    }

    //文件上传
    @PostMapping("/upload")
    @ResponseBody
    public String upload(@RequestParam(value = "file") MultipartFile file) {
        if (file.isEmpty()) {
            return "文件为空，上传失败!";
        }
        String filename = file.getOriginalFilename();
//        String filepath = "/";
        String dirPath = System.getProperty("user.dir") + "/src/main/resources/temp/";
        File dest = new File(dirPath + filename);

        try {
            file.transferTo(dest);
            logger.info(TimeUtil.getTime() + "  " + filename + "  上传成功");
            return "上传成功！";
        } catch (IOException e) {
            e.printStackTrace();
            return "上传失败!";
        }
    }


}
