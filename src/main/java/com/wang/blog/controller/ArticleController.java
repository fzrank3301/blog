package com.wang.blog.controller;


import com.wang.blog.entity.ArticleEntity;
import com.wang.blog.dao.ArticleMapper;
import com.wang.blog.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class ArticleController {

    @Resource
    private ArticleService articleService;

    @GetMapping("/acticle")
    public ArticleEntity getActicleById(@RequestParam(value = "id",defaultValue = "1")Integer id){
        ArticleEntity acticleEntity = null;

        acticleEntity = articleService.getarticlebyid(id);

        return acticleEntity;
    }
    
}
