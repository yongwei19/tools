package com.test.tools.controller;

import com.test.tools.service.OkhttpService;
import com.test.tools.utils.Md5Tools;
import com.test.tools.utils.validation.Insert;
import com.test.tools.vo.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tools")
public class ToolsController {

    @Autowired
    private OkhttpService okhttpService;

    // 获取md5
    @RequestMapping(value = "/md5/{md5}",method = RequestMethod.GET)
    public JsonResult tools(@PathVariable String md5){
        Md5Tools md5Tools = new Md5Tools();
        JsonResult jsonResult = new JsonResult(200, md5Tools.getMd5(md5),"success");
        return jsonResult;
    }

    // 获取暖心语录
    @GetMapping(value = "/quotation")
    public JsonResult quotation(@RequestParam(value = "count",required = false,defaultValue = "1") Integer count,@RequestParam(value = "genderType",required = false,defaultValue = "M") String genderType){
        System.out.println("count: " +count + " genderType: " + genderType);
        if (count <= 0 || count >100 ){
            return JsonResult.fail("count应在1~100之间，为空时默认为1");
        }
        if (!genderType.equals("M") && !genderType.equals("F")){
            return JsonResult.fail("genderType 应为 M 或 F，M 为 “渣男”，F 为 “绿茶”，默认为M");
        }
        return new JsonResult(200,okhttpService.getSweetNothings(count,genderType),"success");
    }

}
