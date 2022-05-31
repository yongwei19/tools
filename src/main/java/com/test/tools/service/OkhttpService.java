package com.test.tools.service;

import com.alibaba.fastjson.JSONObject;
import com.test.tools.utils.OkHttpCli;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author zhangyw
 * @date 2022/5/20
 */
@Service
public class OkhttpService {

    @Autowired
    private OkHttpCli okHttpCli;

    // 调用第三方接口，获取语录
    public String getSweetNothings(Integer count,String genderType){
        String url = "https://api.lovelive.tools/api/SweetNothings/" + count + "/Serialization/Json?genderType=" + genderType;
        String message = okHttpCli.doGet(url);
        JSONObject json = JSONObject.parseObject(message);
        // 只要json字符串中的returnObj部分
        String  data = json.getString("returnObj");
        return data;
    }
}
