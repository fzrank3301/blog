package com.wang.blog.controller;


import com.github.pagehelper.PageInfo;
import com.wang.blog.entity.ArticleEntity;
import com.wang.blog.dao.ArticleMapper;
import com.wang.blog.entity.AuthorEntity;
import com.wang.blog.service.ArticleService;
import com.wang.blog.service.AuthorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Description;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@RestController
@CrossOrigin
@RequestMapping("article/")
public class ArticleController {

    private static Logger logger = LoggerFactory.getLogger(ArticleController.class);

    @Resource
    private ArticleService articleService;

    @Autowired
    private AuthorService authorService;

    //按id查找文章
    @GetMapping("/getacticlebyid")
    public ArticleEntity getArticleById(@RequestParam(value = "id", defaultValue = "1") Integer id) {
        ArticleEntity acticleEntity = null;

        acticleEntity = articleService.getarticlebyid(id);

        logger.info(Util.getTime() + "   id： " + id.toString());
        return acticleEntity;

    }

    //查找所有文章
    @GetMapping("/getarticlelist")
    public List<ArticleEntity> getArticlelist() {
        List<ArticleEntity> list = new ArrayList<>();

        list = articleService.getAll();

        return list;
    }


    //分页查询
    @GetMapping("/findAll")
    public PageInfo<ArticleEntity> findAll(@RequestParam(value = "page", defaultValue = "2") int currentPage,
                                           @RequestParam(value = "size", defaultValue = "2") int pageSize) {
        PageInfo<ArticleEntity> all = articleService.findAll(currentPage, pageSize);
        return all;
    }

    @PostMapping("/addarticle")
    public String addarticle(@RequestParam(value = "author") String author,
                             @RequestParam(value = "title") String title,
                             @RequestParam(value = "fullcontext") String fullcontext,
                             @RequestParam(value = "context") String context) {

        //判断是否存在，存在找出id，不存在创建后
        boolean exist = authorService.isName(author);
        if (exist) {

        } else {
            authorService.addAuthor(author);
        }

        Integer authorid = authorService.findbyAuthorName(author).getAuthorid();
        String time = Util.getTime();
        articleService.addarticle(author, title, fullcontext, context, time, authorid);
        logger.info("插入了一篇文章  " + title);
        return "插入成功！";
    }
}
