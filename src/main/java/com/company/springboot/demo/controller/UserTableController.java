package com.company.springboot.demo.controller;

import com.company.springboot.demo.common.Const;
import com.company.springboot.demo.common.Result;
import com.company.springboot.demo.common.ServerRes;
import com.company.springboot.demo.dao.entity.UserTable;
import com.company.springboot.demo.service.UserService;
import com.company.springboot.demo.vo.StuChooseTeam;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/user")
public class UserTableController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "/index",method = RequestMethod.POST)
    @ResponseBody
    public ServerRes<UserTable> index(String username, String password, HttpSession session){
        if(StringUtils.isBlank(username)||StringUtils.isBlank(password)){
            return ServerRes.error(Result.ILLEGLE_ARGUMENTS);
        }
        ServerRes<UserTable> index = userService.login(username, password);
        if(index.getStatus() == Result.LOGIN_SUCCESS.getCode()){
            session.setAttribute(Const.CURRENT_USER ,index.getData());
        }
        return index;
    }


    /**
     * 学生信息页面List
     * @param userTable
     * @return
     */
    @RequestMapping(value = "stuInfo",method = RequestMethod.POST)
    @ResponseBody
    public ServerRes stuInfo(UserTable userTable){
        ServerRes serverRes =userService.stuInfo(userTable);
        return ServerRes.success(serverRes);
    }

    /**
     * 学生信息页面 新增
     * @param userTable
     * @return
     */
    @RequestMapping(value = "/addInfo",method = RequestMethod.POST)
    @ResponseBody
    public ServerRes addInfo(UserTable userTable){
        userService.addInfo(userTable);
        return ServerRes.OK("添加成功");
    }

    /**
     * 学生选择小组页面List
      * @return
     */
    @RequestMapping(value = "/stuChooseTeam",method = RequestMethod.POST)
    @ResponseBody
    public ServerRes stuChooseT(StuChooseTeam stuChooseTeam){
        ServerRes sct = userService.stuChooseTeam(stuChooseTeam);
        return ServerRes.success(sct);
    }

}
