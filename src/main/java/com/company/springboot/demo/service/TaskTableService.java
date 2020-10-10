package com.company.springboot.demo.service;

import com.company.springboot.demo.common.ServerRes;
import com.company.springboot.demo.dao.entity.TaskCtable;
import com.company.springboot.demo.dao.entity.TaskZtable;
import com.company.springboot.demo.vo.LeaderWriteTask;
import com.company.springboot.demo.vo.StuSubmitTaskVo;
import com.company.springboot.demo.vo.TaskVo;

import java.util.List;

public interface TaskTableService {

    /**
     * 查询所有
     * @param taskVo
     * @return
     */
    ServerRes taskList(TaskVo taskVo);

    void addTask(TaskZtable taskZtable);

    void editTask(TaskZtable taskZtable);

    int delTask(String id);

    /**
     * 组长填写任务页面List
     * @param leaderWriteTask
     * @return
     */
    ServerRes leaderWriteTask(LeaderWriteTask leaderWriteTask);

    /**
     *组长删除任务
     * @param rwcid
     */
    int teamLeaderdelPlan(Integer rwcid);

    /**
     * 组长根据rwcid填写任务开始时间/结束时间
     * @param
     */
    void  leaderWriteBeginAndOverTime(TaskCtable taskCtable);

    /**
     * 学生提交任务页面List
     * @param stuSubmitTaskVo
     * @return
     */
    ServerRes stuSubmitTaskList(StuSubmitTaskVo stuSubmitTaskVo);
    /**
     * 学生任务信息页面-提交按钮-更改状态
     * @param taskCtable
     */
    void stuUpdateTaskState(TaskCtable taskCtable);
}
