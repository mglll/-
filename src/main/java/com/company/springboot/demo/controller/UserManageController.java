package com.company.springboot.demo.controller;

import com.company.springboot.demo.common.Const;
import com.company.springboot.demo.common.Result;
import com.company.springboot.demo.common.ServerRes;
import com.company.springboot.demo.dao.entity.UserTable;
import com.company.springboot.demo.dto.TokenDto;
import com.company.springboot.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/manage")
public class UserManageController {

    @Autowired
    UserService userService;

    /**
     * 管理员登录
     * @param username
     * @param password
     * @param session
     * @return
     */
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    @ResponseBody
    public ServerRes<TokenDto> login(String username, String password, HttpSession session){
        ServerRes<TokenDto> userTableServerRes = userService.login(username,password);
        if(userTableServerRes.getcode() == Result.LOGIN_SUCCESS.getCode()){
            TokenDto userTable = userTableServerRes.getData();
            if(Const.Role.ADMIN == userTable.getRole()){
                //说明登录的是管理员
                session.setAttribute(Const.CURRENT_USER,userTable);
                return userTableServerRes;
            }else {
                return ServerRes.error(Result.USER_MANAGE_ERROR);
            }
        }
        return userTableServerRes;
    }
}
