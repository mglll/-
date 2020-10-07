package com.company.springboot.demo.service;

import com.company.springboot.demo.common.ServerRes;
import com.company.springboot.demo.dao.entity.CourseTable;

public interface CourseTableService {

    void addCourser(CourseTable courseTable);

    int delCourser(Integer kcid);

    void eidtCourser(CourseTable courseTable);

    /**
     * 根据id查询明细
     * @param courseTable
     * @return
     */
    ServerRes<CourseTable> selectMx(CourseTable courseTable);
}
