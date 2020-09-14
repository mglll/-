package com.company.springboot.demo.controller;

import com.company.springboot.demo.common.Result;
import com.company.springboot.demo.common.ServerRes;
import com.company.springboot.demo.dao.entity.TaskZtable;
import com.company.springboot.demo.service.TaskTableService;
import com.company.springboot.demo.vo.TaskVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TaskController {

    @Autowired
    TaskTableService taskTableService;

    @PostMapping(value = "/taskst")
    public ServerRes taskList(TaskVo taskVo){
        ServerRes serverRes = taskTableService.taskList(taskVo);
        return ServerRes.success(serverRes);
    }

    @PostMapping(value = "/addcor")
    public ServerRes addCourse(TaskZtable taskZtable){
        taskTableService.addTask(taskZtable);
        return ServerRes.OK("添加成功");
    }

    @PostMapping(value = "/editcor")
    public ServerRes editCourse(TaskZtable taskZtable){
        taskTableService.editTask(taskZtable);
        return ServerRes.OK("修改成功");
    }

    @PostMapping(value = "/delcor")
    public ServerRes delCourse(String rwid){
        taskTableService.delTask(rwid);
        return ServerRes.OK("删除成功");
    }
}
