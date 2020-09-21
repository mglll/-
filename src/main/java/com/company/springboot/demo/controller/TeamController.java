package com.company.springboot.demo.controller;

import com.company.springboot.demo.common.ServerRes;
import com.company.springboot.demo.dao.entity.TeamCtable;
import com.company.springboot.demo.service.TeamService;
import com.company.springboot.demo.vo.AddTeamVo;
import com.company.springboot.demo.vo.TaskcVo;
import com.company.springboot.demo.vo.TeamcVo;
import com.company.springboot.demo.vo.TeamzVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/team")
public class TeamController {

    @Autowired
    TeamService teamService;

    @RequestMapping(value = "/teamlist",method = RequestMethod.POST)
    @ResponseBody
    public ServerRes teamlist(TeamzVo teamzVo){
        ServerRes teamlist = teamService.teamlist(teamzVo);
        return ServerRes.success(teamlist);
    }
    @RequestMapping(value = "/addTeam",method = RequestMethod.POST)
    @ResponseBody
    public ServerRes addTeam(AddTeamVo addTeamVo) {
        teamService.addTeam(addTeamVo);
        return ServerRes.OK("添加成功");
    }

    @RequestMapping(value = "/delTeam",method = RequestMethod.POST)
    public ServerRes updatedel(String id) {
        teamService.updatedel(id);
        return ServerRes.OK("删除成功");
    }
    @RequestMapping(value = "/fenzuList",method = RequestMethod.POST)
    @ResponseBody
    public ServerRes fenzuList(TeamcVo teamcVo){
        ServerRes serverRes = teamService.fenzuList(teamcVo);
        return ServerRes.success(serverRes);
    }

    //学生加入小组
    @RequestMapping(value = "/addTeam",method = RequestMethod.POST)
    @ResponseBody
    public ServerRes addTeam(TeamCtable teamCtable) {
        teamService.addsTeam(teamCtable);
        return ServerRes.OK("添加成功");
    }

    @RequestMapping(value = "/addTeam",method = RequestMethod.POST)
    @ResponseBody
    public ServerRes findBytask(TaskcVo taskcVo) {
        ServerRes bytask = teamService.findBytask(taskcVo);
        return ServerRes.success(bytask);
    }
    @RequestMapping(value = "/updateping",method = RequestMethod.POST)
    @ResponseBody
    public ServerRes updateping(TeamCtable teamCtable) {
        teamService.updateping(teamCtable);
        return ServerRes.OK("点评成功");
    }

}
