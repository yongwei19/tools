package com.test.tools.controller;

import com.test.tools.tool.Md5Tools;
import com.test.tools.validation.Insert;
import com.test.tools.vo.JsonResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tools")
public class ToolsController {

    @RequestMapping(value = "/md5/{str}",method = RequestMethod.GET)
    public JsonResult tools(@Validated(Insert.class) @PathVariable String str, Exception e){
        // 异常处理，包括参数异常
        if (e instanceof MethodArgumentNotValidException) {
            MethodArgumentNotValidException exception = (MethodArgumentNotValidException)e;
            return JsonResult.warn(exception.getBindingResult().getFieldErrors().get(0).getDefaultMessage());
        }
        Md5Tools md5Tools = new Md5Tools();
        JsonResult jsonResult = new JsonResult(200, md5Tools.getMd5(str),"success");
        return jsonResult;
    }
}
