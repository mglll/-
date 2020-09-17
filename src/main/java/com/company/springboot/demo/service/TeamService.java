package com.company.springboot.demo.service;

import com.company.springboot.demo.common.ServerRes;
import com.company.springboot.demo.dao.entity.TeamZtable;
import com.company.springboot.demo.vo.AddTeamVo;
import com.company.springboot.demo.vo.TeamzVo;

import java.util.List;

public interface TeamService {

    void addTeam(AddTeamVo addTeamVo);

    ServerRes teamlist(TeamzVo teamzVo);

    void updatedel(String id);

}
