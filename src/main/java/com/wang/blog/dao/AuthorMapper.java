package com.wang.blog.dao;

import com.wang.blog.entity.AuthorEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface AuthorMapper {

    public AuthorEntity findbyAuthorName(@Param("name") String name);

    public void addAuthor(@Param(value = "name") String name);

}
