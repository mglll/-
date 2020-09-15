package com.company.springboot.demo.controller;

import com.company.springboot.demo.common.Result;
import com.company.springboot.demo.common.ServerRes;
import com.company.springboot.demo.dao.entity.CourseTable;
import com.company.springboot.demo.service.CourseTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/class")
public class CourseController {

    @Autowired
    CourseTableService courseTableService;

    @RequestMapping(value = "/addcourse",method = RequestMethod.POST)
    public ServerRes addCourse(CourseTable courseTable){
        courseTableService.addCourser(courseTable);
        return ServerRes.OK("添加成功");
    }

    @RequestMapping(value = "/editcourse",method = RequestMethod.POST)
    public ServerRes editCourse(CourseTable courseTable){
        courseTableService.eidtCourser(courseTable);
        return ServerRes.OK("修改成功");
    }

    @RequestMapping(value = "/delcourse",method = RequestMethod.POST)
    public ServerRes delCourse(String kcid){
        courseTableService.delCourser(kcid);
        return ServerRes.OK("删除成功");
    }

    @RequestMapping(value = "/selemx",method = RequestMethod.POST)
    @ResponseBody
    public ServerRes selectMx(CourseTable courseTable){
        ServerRes<CourseTable> courseTableServerRes = courseTableService.selectMx(courseTable);
        return ServerRes.success(courseTableServerRes);
    }
}
