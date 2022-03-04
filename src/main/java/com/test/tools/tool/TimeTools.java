package com.test.tools.tool;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeTools {

    // 获取当前日期，并转换成String类型
    public String getTimeNow(){
        Date date = new Date();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return df.format(date);
    }
}
