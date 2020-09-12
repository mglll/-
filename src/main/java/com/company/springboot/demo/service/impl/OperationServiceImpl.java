package com.company.springboot.demo.service.impl;

import com.company.springboot.demo.common.ServerRes;
import com.company.springboot.demo.dao.CourseTableMapper;
import com.company.springboot.demo.service.OperationService;
import com.company.springboot.demo.vo.CourseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OperationServiceImpl implements OperationService {

        @Autowired
        CourseTableMapper courseTableMapper;

        @Override
        public ServerRes courseList(CourseVo courseVo) {
            List<CourseVo> courseVos = courseTableMapper.courseList(courseVo);
            return ServerRes.success(courseVos);
    }
}
