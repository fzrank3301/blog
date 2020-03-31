package com.wang.blog.service;

import com.wang.blog.dao.UserMapper;
import com.wang.blog.entity.ResultEntity;
import com.wang.blog.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserMapper userMapper;

    public ResultEntity register(UserEntity userEntity) {
        System.out.println(userEntity.toString());
        userMapper.addUser(userEntity.getUsername(),
                userEntity.getPassword(),
                userEntity.getEmail(),
                userEntity.getPhonenumber(),
                userEntity.getUUID(),
                userEntity.getCreatetime(),
                userEntity.isBanned());


        ResultEntity resultEntity = new ResultEntity();
        resultEntity.setState(ResultEntity.SUCCESS);
        return resultEntity;

    }
}
