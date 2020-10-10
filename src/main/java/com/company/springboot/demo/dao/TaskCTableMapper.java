package com.company.springboot.demo.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.company.springboot.demo.dao.entity.TaskCtable;
import com.company.springboot.demo.dto.TaskCtableDTO;
import com.company.springboot.demo.vo.LeaderWriteTask;
import com.company.springboot.demo.vo.StuSubmitTaskVo;

import java.util.List;

public interface TaskCTableMapper extends BaseMapper<TaskCtable> {

    void addTask(TaskCtableDTO taskCtableDTO);

    /**
     *组长填写任务页面List
     * @return
     */
    List<LeaderWriteTask> leaderWriteTask(LeaderWriteTask leaderWriteTask);

//    /**
//     * 组长删除任务
//     * @param
//     */
//    int teamLeaderdelPlan(Integer rwcid);

    /**
     * 组长根据rwcid填写任务开始时间/结束时间
     *
     */
    void  leaderWriteBeginAndOverTime(TaskCtable taskCtable);

    /**
     * 学生任务信息List
      * @return
     */
    List<StuSubmitTaskVo> stuSubmitTaskList(StuSubmitTaskVo stuSubmitTaskVo);

    /**
     * 学生任务信息页面-提交按钮-更改状态
     * @param taskCtable
     */
    void stuUpdateTaskState(TaskCtable taskCtable);

}
