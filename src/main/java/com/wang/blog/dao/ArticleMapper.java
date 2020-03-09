package com.wang.blog.dao;

import com.wang.blog.entity.ArticleEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ArticleMapper {

      ArticleEntity getArticleById(@Param("id") Integer id);

      List<ArticleEntity>  getAllArticle();

}
