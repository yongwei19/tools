package com.test.tools.controller;

import com.test.tools.entity.DiffyEntity;
import com.test.tools.service.DiffyService;
import com.test.tools.vo.ResponseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tools")
public class DiffyController {

    @Autowired
    private DiffyService diffyService;


    @RequestMapping(value = "/get/diffy",method = RequestMethod.GET)
    public ResponseVo getCommand(){
        ResponseVo responseVo = new ResponseVo(200,diffyService.getStartCommand(),"success");
        return responseVo;
    }

    @PostMapping(path = "/post/diffy")
    public ResponseVo add(@RequestBody DiffyEntity diffyEntity){
        // 保存提交记录
        diffyService.addCommitLog(diffyEntity);
        // 返回启动命令
        ResponseVo responseVo = new ResponseVo(200,diffyService.getStartCommand(),"success");
        return responseVo;
    }

}
