package com.wang.blog.controller;


import com.wang.blog.entity.PersonEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.atomic.AtomicLong;


@RestController //@Controller + @ResponseBody
public class IndexController {

    Logger logger = LoggerFactory.getLogger(IndexController.class);
    public static final String template = "hello,%s";
    private  final AtomicLong counter = new AtomicLong();


//    @RequestMapping(value = "/person",method = RequestMethod.GET)
//    @ResponseBody
    @GetMapping("/person")
    public PersonEntity person(@RequestParam(value = "name",defaultValue = "world") String name){
        logger.warn(name);
        return  new PersonEntity(counter.incrementAndGet(),String.format(template,name));
    }

}
