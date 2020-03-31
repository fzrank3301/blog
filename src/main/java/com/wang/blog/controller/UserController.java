package com.wang.blog.controller;

import com.wang.blog.entity.ResultEntity;
import com.wang.blog.entity.UserEntity;
import com.wang.blog.service.UserService;
import com.wang.blog.utils.TimeUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

@RestController
@CrossOrigin
@RequestMapping("user/")
public class UserController {

    private static Logger logger = LoggerFactory.getLogger(FileController.class);

    @Resource
    UserService userService;

    @PostMapping("/register")
    public ResultEntity register(@RequestParam(value = "username", required = false) String username,
                                 @RequestParam(value = "password", required = false) String password,
                                 @RequestParam(value = "email", required = false) String email,
                                 @RequestParam(value = "phonenum", required = false) String phonenum,
                                 HttpServletRequest request,
                                 HttpServletResponse response) {
        if (username == null || password == null || email == null || phonenum == null) {

            ResultEntity resultEntity = new ResultEntity();
            resultEntity.setMsg("请重新检查您的用户名/密码/邮箱/手机号是否正确填写");
            resultEntity.setState(ResultEntity.FAILED);
            return resultEntity;
            //验证信息是否为空
//            return  new ResultEntity().setState(ResultEntity.SUCCESS).setMsg("XXXXX");
        }
        String createtime = TimeUtil.getTime();
        String uuid = UUID.randomUUID().toString();
        UserEntity userEntity = new UserEntity();
        //生成User并且赋值
        userEntity.setUsername(username);
        userEntity.setPassword(password);
        userEntity.setEmail(email);
        userEntity.setPhonenumber(phonenum);
        userEntity.setCreatetime(createtime);
        userEntity.setUUID(uuid);
        userEntity.setBanned(false);
        logger.info(userEntity.toString());
        ResultEntity register = userService.register(userEntity);
        //把生成的User转给Service层实现
        if (register.getState() != ResultEntity.SUCCESS) {
            ResultEntity resultEntity = new ResultEntity();
            resultEntity.setState(ResultEntity.FAILED);
            resultEntity.setMsg("注册过程中出错,请过段时间再试或联系网站管理员");
            return resultEntity;
        }
        logger.info(userEntity.toString());
        ResultEntity resultEntity = new ResultEntity();
        resultEntity.setMsg("注册成功！您现在可以登录了");
        resultEntity.setState(ResultEntity.SUCCESS);
        return resultEntity;
    }

}
