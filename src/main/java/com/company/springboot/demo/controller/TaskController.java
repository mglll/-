package com.company.springboot.demo.controller;

import com.company.springboot.demo.common.Result;
import com.company.springboot.demo.common.ServerRes;
import com.company.springboot.demo.dao.entity.TaskZtable;
import com.company.springboot.demo.service.TaskTableService;
import com.company.springboot.demo.vo.LeaderWriteTask;
import com.company.springboot.demo.vo.TaskVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/task")
public class TaskController {

    @Autowired
    TaskTableService taskTableService;

    @RequestMapping(value = "/taskst",method = RequestMethod.POST)
    public ServerRes taskList(TaskVo taskVo){
        ServerRes serverRes = taskTableService.taskList(taskVo);
        return ServerRes.success(serverRes);
    }

    @RequestMapping(value = "/addcor",method = RequestMethod.POST)
    public ServerRes addCourse(TaskZtable taskZtable){
        taskTableService.addTask(taskZtable);
        return ServerRes.OK("添加成功");
    }


    @RequestMapping(value = "/editcor",method = RequestMethod.POST)
    public ServerRes editCourse(TaskZtable taskZtable){
        taskTableService.editTask(taskZtable);
        return ServerRes.OK("修改成功");
    }


    @RequestMapping(value = "/delcor",method = RequestMethod.POST)
    public ServerRes delCourse(String rwid){
        taskTableService.delTask(rwid);
        return ServerRes.OK("删除成功");
    }

    /**
     * 组长填写任务页面List
     * @return
     */
    @RequestMapping(value = "/leaderWriteTask",method = RequestMethod.POST)
    @ResponseBody
    public ServerRes leaderWriteTask(LeaderWriteTask leaderWriteTask){
        ServerRes lwt = taskTableService.leaderWriteTask(leaderWriteTask);
        return ServerRes.success(lwt);
    }

}
