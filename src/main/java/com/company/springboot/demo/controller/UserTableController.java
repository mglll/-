package com.company.springboot.demo.controller;

import com.company.springboot.demo.common.Const;
import com.company.springboot.demo.common.Result;
import com.company.springboot.demo.common.ServerRes;
import com.company.springboot.demo.dao.entity.UserTable;
import com.company.springboot.demo.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
public class UserTableController {

    @Autowired
    UserService userService;

    @PostMapping(value = "/login")
    public ServerRes<UserTable> login(String username, String password, HttpSession session){
        if(StringUtils.isBlank(username)||StringUtils.isBlank(password)){
            return ServerRes.error(Result.ILLEGLE_ARGUMENTS);
        }
        ServerRes<UserTable> login = userService.login(username, password);
        if(login.getStatus() == Result.LOGIN_SUCCESS.getCode()){
            session.setAttribute(Const.CURRENT_USER ,login.getData());
        }
        return login;
    }
}
