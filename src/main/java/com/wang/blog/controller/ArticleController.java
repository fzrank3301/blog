package com.wang.blog.controller;


import com.github.pagehelper.PageInfo;
import com.wang.blog.entity.ArticleEntity;
import com.wang.blog.dao.ArticleMapper;
import com.wang.blog.service.ArticleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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

    //按id查找文章
    @GetMapping("/getacticlebyid")
    public ArticleEntity getArticleById(@RequestParam(value = "id", defaultValue = "1") Integer id) {
        ArticleEntity acticleEntity = null;

        acticleEntity = articleService.getarticlebyid(id);

        logger.info(Util.getTime() + "   id： " + id.toString());
        String uuid = UUID.randomUUID().toString();
        logger.info(Util.getTime() + "   UUID： " + uuid);
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


}
