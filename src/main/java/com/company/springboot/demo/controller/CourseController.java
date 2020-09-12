package com.company.springboot.demo.controller;

import com.company.springboot.demo.common.Result;
import com.company.springboot.demo.common.ServerRes;
import com.company.springboot.demo.dao.entity.CourseTable;
import com.company.springboot.demo.service.CourseTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CourseController {

    @Autowired
    CourseTableService courseTableService;

    @PostMapping(value = "/addcor")
    public ServerRes addCourse(CourseTable courseTable){
        courseTableService.addCourser(courseTable);
        return ServerRes.OK("添加成功");
    }

    @PostMapping(value = "/editcor")
    public ServerRes editCourse(CourseTable courseTable){
        courseTableService.eidtCourser(courseTable);
        return ServerRes.OK("修改成功");
    }

    @PostMapping(value = "/delcor")
    public ServerRes delCourse(String kcid){
        courseTableService.delCourser(kcid);
        return ServerRes.OK("删除成功");
    }

    @PostMapping(value = "/selectmx")
    public ServerRes selectMx(CourseTable courseTable){
        ServerRes<CourseTable> courseTableServerRes = courseTableService.selectMx(courseTable);
        return ServerRes.success(courseTableServerRes);
    }
}
