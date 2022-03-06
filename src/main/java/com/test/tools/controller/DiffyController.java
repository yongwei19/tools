package com.test.tools.controller;

import com.test.tools.entity.DiffyEntity;
import com.test.tools.service.DiffyService;
import com.test.tools.validation.Insert;
import com.test.tools.vo.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tools")
public class DiffyController {

    @Autowired
    private DiffyService diffyService;


    @RequestMapping(value = "/get/diffy",method = RequestMethod.GET)
    public JsonResult getCommand(){
        JsonResult jsonResult = new JsonResult(200,diffyService.getStartCommand(),"success");
        return jsonResult;
    }

    @PostMapping(path = "/post/diffy")
    public JsonResult add(@Validated(Insert.class) @RequestBody DiffyEntity diffyEntity,Exception e){
        // 异常处理，包括参数异常
        if (e instanceof MethodArgumentNotValidException) {
            MethodArgumentNotValidException exception = (MethodArgumentNotValidException)e;
            return JsonResult.warn(exception.getBindingResult().getFieldErrors().get(0).getDefaultMessage());
        }

        // 保存提交记录
        diffyService.addCommitLog(diffyEntity);
        // 返回启动命令
        JsonResult jsonResult = new JsonResult(200,diffyService.getStartCommand(),"success");
        return jsonResult;
    }

}
