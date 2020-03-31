package com.wang.blog.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeUtil {

    //得到当前时间并格式化
    public static String getTime() {
        Date date = new Date();
        SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String time = ft.format(date).toString();
        return time;
    }


}


