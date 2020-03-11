package com.wang.blog.dao;

import com.github.pagehelper.PageInfo;
import com.wang.blog.entity.ArticleEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ArticleMapper {

      public ArticleEntity getArticleById(@Param("id") Integer id);

      public List<ArticleEntity> getAllArticle();

      public List<ArticleEntity> findAll();

}
