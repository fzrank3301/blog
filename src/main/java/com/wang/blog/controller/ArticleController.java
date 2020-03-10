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
@CrossOrigin
@RequestMapping("article/")
public class ArticleController {

    @Resource
    private ArticleService articleService;

    //按id查找文章
    @GetMapping("/getacticlebyid")
    public ArticleEntity getArticleById(@RequestParam(value = "id",defaultValue = "1")Integer id){
        ArticleEntity acticleEntity = null;

        acticleEntity = articleService.getarticlebyid(id);

        return acticleEntity;
    }

    //查找所有文章
    @GetMapping("/getarticlelist")
    public List<ArticleEntity> getArticlelist(){
        List<ArticleEntity> list = new ArrayList<>();

        list = articleService.getAll();

        return  list;
    }

}
