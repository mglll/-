package com.company.springboot.demo.service.impl;

import cn.hutool.core.date.DateUtil;
import com.company.springboot.demo.common.Result;
import com.company.springboot.demo.common.ServerRes;
import com.company.springboot.demo.dao.TaskCTableMapper;
import com.company.springboot.demo.dao.TaskZTableMapper;
import com.company.springboot.demo.dao.entity.TaskCtable;
import com.company.springboot.demo.dao.entity.TaskZtable;
import com.company.springboot.demo.dto.TaskDTO;
import com.company.springboot.demo.service.TaskTableService;
import com.company.springboot.demo.vo.LeaderWriteTask;
import com.company.springboot.demo.vo.StuSubmitTaskVo;
import com.company.springboot.demo.vo.TaskVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class TaskTableServiceImpl implements TaskTableService {


    @Autowired
    TaskZTableMapper taskZTableMapper;
    @Autowired
    TaskCTableMapper taskCTableMapper;
    @Autowired
    TaskTableService taskTableService;

    @Override
    public ServerRes taskList(TaskVo taskVo) {
        String begin = DateUtil.format(taskVo.getStartdate(),"yyyy-MM-dd");
        String end = DateUtil.format(taskVo.getEnddate(),"yyyy-MM-dd");
        TaskDTO taskDTO = new TaskDTO(taskVo.getJTask(),taskVo.getKmid(),taskVo.getKmName(),taskVo.getRyid(),taskVo.getName(),begin,end,taskVo.getStatus());
        List<TaskVo> taskVos = taskZTableMapper.taskList(taskDTO);
        return ServerRes.success(taskVos);
    }

    @Override
    public void addTask(TaskZtable taskZtable) {
        TaskZtable taskZtable1 = new TaskZtable();
        taskZtable1.setDel("1");
        BeanUtils.copyProperties(taskZtable,taskZtable1);
        taskZTableMapper.insert(taskZtable1);
    }

    @Override
    public void editTask(TaskZtable taskZtable) {
        taskZTableMapper.updateById(taskZtable);
    }

    @Override
    public int delTask(String id) {
        TaskZtable taskZtable = new TaskZtable();
        int i = taskZTableMapper.deleteById(taskZtable.getRwid());
        return i;
    }

    /**
     * 组长填写任务页面List
     * @param leaderWriteTask
     * @return
     */
    @Override
    public ServerRes leaderWriteTask(LeaderWriteTask leaderWriteTask) {
        List<LeaderWriteTask> leaderWriteTaskList = taskCTableMapper.leaderWriteTask(leaderWriteTask);
        return ServerRes.success(leaderWriteTaskList);
    }

    /**
     * 组长删除任务
     * @param rwcid
     * @return
     */
    @Override
    public int teamLeaderdelPlan(Integer rwcid) {
        int a = taskCTableMapper.deleteById(rwcid);
        return a;
    }


    /**
     * 组长根据rwcid填写任务开始时间/结束时间
     * @param
     */
    @Override
    public void leaderWriteBeginAndOverTime(TaskCtable taskCtable) {
        taskCTableMapper.leaderWriteBeginAndOverTime(taskCtable);
    }

    /**
     * 学生提交任务页面List
     * @param stuSubmitTaskVo
     * @return
     */
    @Override
    public ServerRes stuSubmitTaskList(StuSubmitTaskVo stuSubmitTaskVo) {
        List<StuSubmitTaskVo> stuSubmitTaskVoList =taskCTableMapper.stuSubmitTaskList(stuSubmitTaskVo);
        return ServerRes.success(stuSubmitTaskVoList);
    }
    /**
     * 学生任务信息页面-提交按钮-更改状态
     * @param taskCtable
     */
    @Override
    public void stuUpdateTaskState(TaskCtable taskCtable) {
        taskCTableMapper.stuUpdateTaskState(taskCtable);
    }


}
