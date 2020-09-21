package com.company.springboot.demo.service;

import com.company.springboot.demo.common.ServerRes;
import com.company.springboot.demo.dao.entity.TeamCtable;
import com.company.springboot.demo.dao.entity.TeamZtable;
import com.company.springboot.demo.vo.AddTeamVo;
import com.company.springboot.demo.vo.TaskcVo;
import com.company.springboot.demo.vo.TeamcVo;
import com.company.springboot.demo.vo.TeamzVo;

import java.util.List;

public interface TeamService {

    void addTeam(AddTeamVo addTeamVo);

    ServerRes teamlist(TeamzVo teamzVo);

    void updatedel(String id);

    /**
     * 学生加入小组
     * @param teamCtable
     */
    void addsTeam(TeamCtable teamCtable);

    /**
     * 查询小组里的组员信息
     * @param teamcVo
     * @return
     */
    ServerRes fenzuList(TeamcVo teamcVo);

    /**
     * 组长审核前查询列表
     * @param taskcVo
     * @return
     */
    ServerRes findBytask(TaskcVo taskcVo);

    /**
     * 组长写评分和评语
     * @param teamCtable
     */
    int updateping(TeamCtable teamCtable);
}
