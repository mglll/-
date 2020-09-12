package com.company.springboot.demo.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.company.springboot.demo.dao.entity.TaskZtable;
import com.company.springboot.demo.vo.TaskVo;

import java.util.List;

public interface TaskZTableMapper extends BaseMapper<TaskZtable> {

    List<TaskVo> taskList(TaskVo taskVo);
}
