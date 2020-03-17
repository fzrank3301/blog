package com.wang.blog.dao;

import com.github.pagehelper.PageInfo;
import com.wang.blog.entity.ArticleEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ArticleMapper {

      //查
      public ArticleEntity getArticleById(@Param("id") Integer id);

      public List<ArticleEntity> getAllArticle();

      public List<ArticleEntity> findAll();


      //增
      public void addarticle(@Param("author") String author,
                             @Param("title") String title,
                             @Param("fullcontext") String fullcontext,
                             @Param("context") String context,
                             @Param("createtime") String createtime,
                             @Param("authorid") Integer authorid);

}
