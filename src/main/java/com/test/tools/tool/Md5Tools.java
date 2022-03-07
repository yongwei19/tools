package com.test.tools.tool;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;


public class Md5Tools {

    private static MessageDigest md5;

    static {
        try {
            md5 = MessageDigest.getInstance("MD5");
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    // 获取一个字符串的MD5,32位小写
    public String getMd5(String str){
        try{
            byte[] bs = md5.digest(str.getBytes(StandardCharsets.UTF_8));
            StringBuffer sb = new StringBuffer(40);
            for (byte x : bs){
                if ((x & 0xff) >> 4 ==0){
                    sb.append("0").append(Integer.toHexString(x & 0xff));
                }else {
                    sb.append(Integer.toHexString(x & 0xff));
                }
            }
            return sb.toString();
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

}
