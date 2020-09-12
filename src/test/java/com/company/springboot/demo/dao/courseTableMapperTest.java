package com.company.springboot.demo.dao;

import com.company.springboot.demo.DemoApplication;
import com.company.springboot.demo.dao.entity.CourseTable;
import com.company.springboot.demo.dao.entity.TeamCtable;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {DemoApplication.class})
public class courseTableMapperTest {
    @Autowired
    private CourseTableMapper courseTableMapper;

    @Autowired
    private TeamCTableMapper teamCTableMapper;
    @Test
    public void insert(){
        CourseTable courseTable = new CourseTable();
        courseTable.setKmid("11112");
        courseTable.setRyid("1122");
        courseTable.setJskrrs("333");
        courseTable.setSfyty("1513");
        courseTable.setStartday(new Date());
        courseTable.setStarttime(new Date());
        courseTable.setStatus("已完成");
        courseTable.setDel("1");
        courseTable.setCreatedBy("张");
        courseTable.setCreatedTime(new Date());
        courseTable.setUpdatedBy("张");
        courseTable.setUpdatedTime(new Date());
        courseTableMapper.insert(courseTable);
    }

    @Test
    public void update(){
        CourseTable courseTable = new CourseTable();
        courseTable.setKmid("11112");
        courseTable.setRyid("66666");
        courseTableMapper.updateById(courseTable);
    }
    @Test
    public void delete(){
        CourseTable courseTable = new CourseTable();
        courseTable.setKmid("11111");
        courseTableMapper.deleteById(courseTable);
    }

    @Test
    public void select(){
        CourseTable courseTable = new CourseTable();
        courseTable.setKmid("11112");
        CourseTable courseTable1 = courseTableMapper.selectById(courseTable);
        System.err.println(courseTable1);
    }

    @Test
    public void selectone(){
        List<CourseTable> all = courseTableMapper.findAll();
        all.stream().forEach(System.err::println);
    }

    @Test
    public void insert1(){
        TeamCtable teamCTable = new TeamCtable();
        teamCTable.setZzid("110");
        teamCTable.setRyid("12233");
        teamCTable.setDel("1");
        teamCTable.setCreatedBy("asff");
        teamCTable.setCreatedTime(new Date());
        teamCTable.setUpdatedBy("zxcxz");
        teamCTable.setUpdatedTime(new Date());
        teamCTableMapper.insert(teamCTable);
    }
}