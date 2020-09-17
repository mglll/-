package com.company.springboot.demo.service.impl;

import cn.hutool.core.date.DateUtil;
import com.company.springboot.demo.common.ServerRes;
import com.company.springboot.demo.dao.*;
import com.company.springboot.demo.dao.entity.TaskCtable;
import com.company.springboot.demo.dao.entity.TeamZtable;
import com.company.springboot.demo.dao.entity.UserTable;
import com.company.springboot.demo.dao.entity.WorkFiowTable;
import com.company.springboot.demo.dto.TaskCtableDTO;
import com.company.springboot.demo.service.TeamService;
import com.company.springboot.demo.vo.AddTeamVo;
import com.company.springboot.demo.vo.TeamzVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class TeamServiceImpl implements TeamService {

    @Autowired
    UserTableMapper userTableMapper;

    @Autowired
    TaskCTableMapper taskCTableMapper;

    @Autowired
    TeamZTableMapper teamZTableMapper;

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


}
