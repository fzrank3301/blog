package com.wang.blog.service;


import com.wang.blog.dao.AuthorMapper;
import com.wang.blog.entity.AuthorEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorService {
    @Autowired
    AuthorMapper authorMapper;

    //通过Name查找作家名字
    public AuthorEntity findbyAuthorName(String name) {
        AuthorEntity authorEntity = authorMapper.findbyAuthorName(name);
        return authorEntity;
    }

    //添加作家
    public void addAuthor(String name) {
        authorMapper.addAuthor(name);
    }


    //通过Name查找作家是否存在
    public boolean isName(String name) {
        AuthorEntity authorEntity = authorMapper.findbyAuthorName(name);
        if (authorEntity != null) {
            return true;
        }
        return false;
    }

}
