package com.company.springboot.demo.controller;

import com.company.springboot.demo.common.Result;
import com.company.springboot.demo.common.ServerRes;
import com.company.springboot.demo.dao.entity.TaskZtable;
import com.company.springboot.demo.service.TaskTableService;
import com.company.springboot.demo.vo.LeaderWriteTask;
import com.company.springboot.demo.vo.StuSubmitTaskVo;
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
    @ResponseBody
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

    /**
     * 组长根据rwcid填写任务开始时间/结束时间
     * @param rwcid
     */
    @RequestMapping(value = "/leaderWriteBeginAndOverTime",method = RequestMethod.POST)
    @ResponseBody
    public ServerRes leaderWriteBeginAndOverTime(int rwcid){
        taskTableService.leaderWriteBeginAndOverTime(rwcid);
        return ServerRes.OK("修改成功");
    }
    /**
     * 学生提交任务页面List
     * @param stuSubmitTaskVo
     * @return
     */
    @RequestMapping(value = "/stuSubmitTaskList",method = RequestMethod.POST)
    @ResponseBody
    public ServerRes stuSubmitTaskList(StuSubmitTaskVo stuSubmitTaskVo){
        ServerRes sstl = taskTableService.stuSubmitTaskList(stuSubmitTaskVo);
        return ServerRes.success(sstl);
    }
    /**
     * 学生任务信息页面-提交按钮-更改状态
     * @param submitstate
     */
    @RequestMapping(value = "/stuUpdateTaskState",method = RequestMethod.POST)
    @ResponseBody
    public  ServerRes stuUpdateTaskState(String submitstate,int rwcid){
        taskTableService.stuUpdateTaskState(submitstate,rwcid);
        return ServerRes.OK("修改成功");
    }

}
