package com.wang.blog.controller;


import com.github.pagehelper.PageInfo;
import com.wang.blog.entity.ArticleEntity;
import com.wang.blog.dao.ArticleMapper;
import com.wang.blog.service.ArticleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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

        logger.info(getTime() + "   id： " + id.toString());

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


    //得到当前时间并格式化
    private static String getTime() {
        Date date = new Date();
        SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String time = ft.format(date).toString();
        return time;
    }

}
