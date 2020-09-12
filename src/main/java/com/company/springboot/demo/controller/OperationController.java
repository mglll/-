package com.company.springboot.demo.controller;

import com.company.springboot.demo.common.ServerRes;
import com.company.springboot.demo.service.OperationService;
import com.company.springboot.demo.vo.CourseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OperationController {
    @Autowired
    OperationService operationService;

    @PostMapping(value = "/courlist")
    public ServerRes courseList(CourseVo courseVo){
        ServerRes serverRes = operationService.courseList(courseVo);
        return ServerRes.success(serverRes);
    }
}
