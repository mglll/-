package com.company.springboot.demo.service.impl;

import cn.hutool.core.date.DateUtil;
import com.company.springboot.demo.common.ServerRes;
import com.company.springboot.demo.dao.*;
import com.company.springboot.demo.dao.entity.*;
import com.company.springboot.demo.dto.TaskCtableDTO;
import com.company.springboot.demo.dto.TeamDTO;
import com.company.springboot.demo.service.TeamService;
import com.company.springboot.demo.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class TeamServiceImpl implements TeamService {

    @Autowired
    UserTableMapper userTableMapper;

    @Autowired
    TaskCTableMapper taskCTableMapper;

    @Autowired
    TeamZTableMapper teamZTableMapper;

    @Autowired
    TeamCTableMapper teamCTableMapper;

    @Autowired
    WorkFiowTableMapper workFiowTableMapper;

    @Autowired
    LimitsTableMapper limitsTableMapper;

    @Override
    public void addTeam(AddTeamVo addTeamVo) {
        String startdate = DateUtil.format(addTeamVo.getStartdate(), "yyyy-MM-dd");
        String starttime = DateUtil.format(addTeamVo.getStarttime(), "HH:mm:ss");
        TaskCtableDTO taskCtableDTO = new TaskCtableDTO(
                addTeamVo.getZTask(),
                startdate,
                starttime,
                "1"
        );
        taskCTableMapper.addTask(taskCtableDTO);
        String i = "";
        if (!addTeamVo.getName().equals(null)) {
            i = userTableMapper.checkid(addTeamVo.getName());
            if (!i.equals(null)) {
                TeamZtable teamZtable = new TeamZtable();
                teamZtable.setDel("1");
                teamZtable.setRyid(i);
                teamZTableMapper.insert(teamZtable);
                WorkFiowTable workFiowTable = new WorkFiowTable();
                workFiowTable.setSname(addTeamVo.getName());
                workFiowTableMapper.insert(workFiowTable);
            }
        }
        limitsTableMapper.updateLimits(i);

    }

    @Override
    public ServerRes teamlist(TeamzVo teamzVo) {
        List<TeamzVo> teamlist = teamZTableMapper.teamlist(teamzVo);
        return ServerRes.success(teamlist);
    }

    @Override
    public void updatedel(String id) {
        String byZzid = teamZTableMapper.findByZzid(id);
        if(byZzid != null){
            teamZTableMapper.updatedel(byZzid);
        }
    }

    /**
     * 学生加入小组
     * @param teamCtable
     */
    @Override
    public void addsTeam(TeamCtable teamCtable) {
        StuChooseTeam stuChooseTeam = new StuChooseTeam();
        teamCtable.setZzid(stuChooseTeam.getZzid().toString());
        UserTable userTable = new UserTable();
        teamCtable.setRyid(userTable.getRyid().toString());
        teamCtable.setDel("1");
        teamCTableMapper.insert(teamCtable);
    }

    @Override
    public ServerRes fenzuList(TeamcVo teamcVo) {
        List<TeamcVo> byfenzu = teamZTableMapper.findByfenzu(teamcVo);
        List<TeamcVo> byzuyuan = teamZTableMapper.findByzuyuan(teamcVo);
        TeamDTO teamDTO = new TeamDTO(byfenzu,byzuyuan);
        return ServerRes.success(teamDTO);
    }

    @Override
    public ServerRes findBytask(TaskcVo taskcVo) {
        List<TaskcVo> bytask = teamCTableMapper.findBytask(taskcVo);
        return ServerRes.success(bytask);
    }

    @Override
    public int updateping(TeamCtable teamCtable) {
        int updateping = teamCTableMapper.updateping(teamCtable);
        if(updateping == 1){
            teamCTableMapper.updatestutas(teamCtable.getRyid());
        }
        return updateping;
    }


}
