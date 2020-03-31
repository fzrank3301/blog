package com.wang.blog.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserMapper {
    public void addUser(@Param(value = "name") String username,
                        @Param(value = "passwd") String password,
                        @Param(value = "email") String email,
                        @Param(value = "phonenum") String phonenumber,
                        @Param(value = "uuid") String uuid,
                        @Param(value = "createtime") String createtime,
                        @Param(value = "banned") boolean banned);
}
