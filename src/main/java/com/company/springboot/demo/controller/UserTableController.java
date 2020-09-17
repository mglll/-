package com.company.springboot.demo.controller;

import com.company.springboot.demo.common.Const;
import com.company.springboot.demo.common.Result;
import com.company.springboot.demo.common.ServerRes;
import com.company.springboot.demo.dao.entity.UserTable;
import com.company.springboot.demo.service.UserService;
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

    @RequestMapping(value = "/addInfo",method = RequestMethod.POST)
    @ResponseBody
    public ServerRes addInfo(UserTable userTable){
        userService.addInfo(userTable);
        return ServerRes.OK("添加成功");
    }

}
