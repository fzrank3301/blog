package com.wang.blog.controller;


import com.wang.blog.entity.ArticleEntity;
import com.wang.blog.dao.ArticleMapper;
import com.wang.blog.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("article/")
public class ArticleController {

    @Resource
    private ArticleService articleService;

    @GetMapping("/getacticlebyid")
    public ArticleEntity getArticleById(@RequestParam(value = "id",defaultValue = "1")Integer id){
        ArticleEntity acticleEntity = null;

        acticleEntity = articleService.getarticlebyid(id);

        return acticleEntity;
    }


    @GetMapping("/getarticlelist")
    public List<ArticleEntity> getArticlelist(){
        List<ArticleEntity> list = new ArrayList<>();

        list = articleService.getAll();

        return  list;
    }

}
