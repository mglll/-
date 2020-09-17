package com.company.springboot.demo.controller;

import com.company.springboot.demo.common.Result;
import com.company.springboot.demo.common.ServerRes;
import com.company.springboot.demo.dao.entity.CourseTable;
import com.company.springboot.demo.service.CourseTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping("/course")
public class CourseController {

    @Autowired
    CourseTableService courseTableService;


    @RequestMapping(value = "addcor",method = RequestMethod.POST)
    public ServerRes addCourse(CourseTable courseTable){
        courseTableService.addCourser(courseTable);
        return ServerRes.OK("添加成功");
    }


    @RequestMapping(value = "editcor",method = RequestMethod.POST)
    public ServerRes editCourse(CourseTable courseTable){
        courseTableService.eidtCourser(courseTable);
        return ServerRes.OK("修改成功");
    }


    @RequestMapping(value = "delcor",method = RequestMethod.POST)
    public ServerRes delCourse(String kcid){
        courseTableService.delCourser(kcid);
        return ServerRes.OK("删除成功");
    }


    @RequestMapping(value = "selectmx",method = RequestMethod.POST)
    public ServerRes selectMx(CourseTable courseTable){
        ServerRes<CourseTable> courseTableServerRes = courseTableService.selectMx(courseTable);
        return ServerRes.success(courseTableServerRes);
    }
}
