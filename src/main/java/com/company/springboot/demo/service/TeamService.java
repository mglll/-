package com.company.springboot.demo.service;

import com.company.springboot.demo.dao.entity.TeamZtable;
import com.company.springboot.demo.vo.AddTeamVo;

public interface TeamService {

    void addTeam(AddTeamVo addTeamVo);
}
