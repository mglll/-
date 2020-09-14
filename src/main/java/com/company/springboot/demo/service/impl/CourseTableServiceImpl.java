package com.company.springboot.demo.service.impl;

import com.company.springboot.demo.common.Result;
import com.company.springboot.demo.common.ServerRes;
import com.company.springboot.demo.dao.CourseTableMapper;
import com.company.springboot.demo.dao.entity.CourseTable;
import com.company.springboot.demo.service.CourseTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseTableServiceImpl implements CourseTableService {

    @Autowired
    CourseTableMapper courseTableMapper;

    @Override
    public void addCourser(CourseTable courseTable) {
        courseTableMapper.insert(courseTable);
    }

    @Override
    public int delCourser(String kcid) {
        int i = courseTableMapper.deleteById(kcid);
        return i;
    }

    @Override
    public void eidtCourser(CourseTable courseTable) {
//        CourseTable courseTable1 = courseTableMapper.selectById(courseTable.getKcid());
//        if(courseTable1.getKcid() != null){
            courseTableMapper.updateById(courseTable);
//        }
    }

    @Override
    public ServerRes<CourseTable> selectMx(CourseTable courseTable) {
        CourseTable courseTable1 = courseTableMapper.selectById(courseTable.getKcid());
//        if(courseTable1.getKcid() != null){
//             courseTableMapper.findAll();
//        }

        return ServerRes.success(courseTable1);
    }
}
