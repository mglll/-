package com.company.springboot.demo.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.company.springboot.demo.dao.entity.TeamCtable;
import com.company.springboot.demo.vo.TaskcVo;

import java.util.List;

public interface TeamCTableMapper extends BaseMapper<TeamCtable> {

    List<TaskcVo> findBytask(TaskcVo taskcVo);

    int updateping(TeamCtable teamCtable);

    void updatestutas(String ryid);
}
