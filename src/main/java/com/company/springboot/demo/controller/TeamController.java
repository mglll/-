package com.company.springboot.demo.controller;

import com.company.springboot.demo.common.ServerRes;
import com.company.springboot.demo.service.TeamService;
import com.company.springboot.demo.vo.AddTeamVo;
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
    @ResponseBody
    public ServerRes updatedel(String id) {
        teamService.updatedel(id);
        return ServerRes.OK("删除成功");
    }

    //学生加入小组
}
