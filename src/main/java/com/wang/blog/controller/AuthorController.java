package com.wang.blog.controller;


import com.wang.blog.entity.AuthorEntity;
import com.wang.blog.service.AuthorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("author/")
public class AuthorController {

    private static Logger logger = LoggerFactory.getLogger(AuthorController.class);

    @Autowired
    AuthorService authorService;

    //通过Name查找作者信息
    @GetMapping("/getinfobyname")
    private AuthorEntity findbyAuthorName(@RequestParam(value = "name") String name) {
        boolean exist = authorService.isName(name);
        if (exist) {
            AuthorEntity authorEntity = authorService.findbyAuthorName(name);
            return authorEntity;
        } //如果存在，返回结果
        AuthorEntity authorEntity = new AuthorEntity();
        authorEntity.setName("该作者不存在！");
        return authorEntity;
    }

    //添加作家信息
    @PostMapping("/addauthor")
    private String addAuthor(@RequestParam(value = "name") String name) {
        AuthorEntity authorEntity = authorService.findbyAuthorName(name);
        if (authorEntity == null) {
            authorService.addAuthor(name);
            logger.info("作家  " + name + "  添加成功！");
            return "添加成功！";
        }
        return "该作家已经存在！";
    }
}
