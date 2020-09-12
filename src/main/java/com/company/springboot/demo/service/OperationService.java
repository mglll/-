package com.company.springboot.demo.service;

import com.company.springboot.demo.common.ServerRes;
import com.company.springboot.demo.vo.CourseVo;

import java.util.List;

public interface OperationService {

    /**
     * 登录后显示的课程列表
     * @param courseVo
     * @return
     */
   ServerRes courseList(CourseVo courseVo);
}
