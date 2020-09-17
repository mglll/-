package com.company.springboot.demo.service;

import com.company.springboot.demo.common.ServerRes;
import com.company.springboot.demo.dao.entity.TaskZtable;
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
}
