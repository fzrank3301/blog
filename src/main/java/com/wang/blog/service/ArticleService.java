package com.wang.blog.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wang.blog.dao.ArticleMapper;
import com.wang.blog.entity.ArticleEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleService {

    @Autowired
    ArticleMapper articleMapper;

    //通过id查找文章
    public ArticleEntity getarticlebyid(Integer id){
        ArticleEntity articleEntity = null;
        articleEntity = articleMapper.getArticleById(id);
        return articleEntity;
    }

    //查找全部文章
    public List<ArticleEntity> getAll() {
        List<ArticleEntity> allArticle = articleMapper.getAllArticle();
        return allArticle;
    }

    //分页查找
    public PageInfo<ArticleEntity> findAll(int currentPage, int pageSize) {
        PageHelper.startPage(currentPage, pageSize);
        List<ArticleEntity> list = articleMapper.findAll();
        return new PageInfo<ArticleEntity>(list);
    }

    //添加文章
    public void addarticle(String author, String title, String fullcontext, String context, String createtime, Integer authorid) {
        articleMapper.addarticle(author, title, fullcontext, context, createtime, authorid);
    }
}
