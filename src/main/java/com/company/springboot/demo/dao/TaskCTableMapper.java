package com.company.springboot.demo.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.company.springboot.demo.dao.entity.TaskCtable;
import com.company.springboot.demo.dto.TaskCtableDTO;

public interface TaskCTableMapper extends BaseMapper<TaskCtable> {

    void addTask(TaskCtableDTO taskCtableDTO);
}
