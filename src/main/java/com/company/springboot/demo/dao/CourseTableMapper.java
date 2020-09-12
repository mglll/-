package com.company.springboot.demo.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.company.springboot.demo.dao.entity.CourseTable;
import com.company.springboot.demo.vo.CourseVo;

import java.util.List;

public interface CourseTableMapper extends BaseMapper<CourseTable> {

    /**
     * 测试用  查询所有
     * @return
     */
    List<CourseTable> findAll();

    List<CourseVo> courseList(CourseVo courseVo);
}
