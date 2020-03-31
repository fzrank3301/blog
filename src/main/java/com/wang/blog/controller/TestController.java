package com.wang.blog.controller;


import com.wang.blog.entity.ResultEntity;
import com.wang.blog.entity.UserEntity;
import com.wang.blog.service.UserService;
import com.wang.blog.utils.TimeUtil;
import com.wang.blog.utils.TokenUtils;
import io.jsonwebtoken.Claims;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.*;


@RestController
@RequestMapping("test/")
@CrossOrigin(origins = "*")
public class TestController {


    private static Logger logger = LoggerFactory.getLogger(TestController.class);

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

        Cookie[] cookies = request.getCookies();
        if (cookies == null) {
            logger.info(request.getQueryString().toString());
            logger.info(request.getMethod().toString());
            logger.info(request.getRequestURL().toString());
            logger.info(request.getProtocol().toString());
            logger.info(request.getLocalAddr());
            logger.info(request.getLocalName());
            logger.info("cookie为空！");
            HttpSession session = request.getSession();
            if (session != null) {
                logger.info(session.getId());
                logger.info(session.getAttributeNames().toString());
            } else {
                logger.info("session为空！");
            }
        } else {
            logger.info(cookies.toString());
        }

        ResultEntity resultEntity = new ResultEntity();
        resultEntity.setState(ResultEntity.SUCCESS);
        resultEntity.setMsg("成功！");
        return resultEntity;
    }


    @GetMapping("/jsontest")
    public JSONObject JSONTEST() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("state", 200);
        jsonObject.put("msg", "成功！");
        return jsonObject;
    }

    @CrossOrigin(origins = "*")
    @PostMapping("/jwttest")
    public ResultEntity jwtTest(@RequestParam(value = "username", required = false) String username,
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
        }

        UserEntity userEntity = new UserEntity();
        userEntity.setUsername(username);
        userEntity.setPhonenumber(phonenum);
        userEntity.setEmail(email);
        userEntity.setPassword(password);
        userEntity.setUUID(UUID.randomUUID().toString());
        userEntity.setBanned(false);
        userEntity.setCreatetime(TimeUtil.getTime());
        //生成用户数据
        String jwtToken = TokenUtils.createJwtToken(phonenum);
        Claims claims = TokenUtils.parseJWT(jwtToken);
        Map<String, Object> map = new HashMap<>();
        map.put("token", jwtToken);
        map.put("claims", claims);
        map.put("user", userEntity);
        ResultEntity resultEntity = new ResultEntity();
        resultEntity.setState(ResultEntity.SUCCESS);
        resultEntity.setData(map);
        resultEntity.setMsg("注册成功！");
        return resultEntity;
    }


}
