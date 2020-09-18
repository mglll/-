package com.company.springboot.demo.service.impl;

import cn.hutool.core.date.DateUtil;
import com.company.springboot.demo.common.Result;
import com.company.springboot.demo.common.ServerRes;
import com.company.springboot.demo.dao.TaskCTableMapper;
import com.company.springboot.demo.dao.TaskZTableMapper;
import com.company.springboot.demo.dao.entity.TaskZtable;
import com.company.springboot.demo.dto.TaskDTO;
import com.company.springboot.demo.service.TaskTableService;
import com.company.springboot.demo.vo.LeaderWriteTask;
import com.company.springboot.demo.vo.TaskVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskTableServiceImpl implements TaskTableService {


    @Autowired
    TaskZTableMapper taskZTableMapper;
    @Autowired
    TaskCTableMapper taskCTableMapper;

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
     * 组长根据rwcid填写任务开始时间/结束时间
     * @param rwcid
     */
    @Override
    public void leaderWriteBeginAndOverTime(int rwcid) {
        taskCTableMapper.leaderWriteBeginAndOverTime(rwcid);
    }


}
