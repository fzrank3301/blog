package com.wang.blog.service;

import com.wang.blog.dao.ArticleMapper;
import com.wang.blog.entity.ArticleEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArticleService {

    @Autowired
    ArticleMapper articleMapper;

    public ArticleEntity getarticlebyid(Integer id){
        ArticleEntity articleEntity = null;
        articleEntity = articleMapper.getArticleById(id);
        return articleEntity;
    }


}
