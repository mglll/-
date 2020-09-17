package com.company.springboot.demo.controller;

import com.company.springboot.demo.common.ServerRes;
import com.company.springboot.demo.service.OperationService;
import com.company.springboot.demo.vo.CourseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping("/operation")
public class OperationController {
    @Autowired
    OperationService operationService;


    @RequestMapping(value = "/courlist",method = RequestMethod.POST)
    public ServerRes courseList(CourseVo courseVo){
        ServerRes serverRes = operationService.courseList(courseVo);
        return ServerRes.success(serverRes);
    }
}
