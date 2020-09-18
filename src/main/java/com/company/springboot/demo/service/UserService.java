package com.company.springboot.demo.service;

import com.company.springboot.demo.common.ServerRes;
import com.company.springboot.demo.dao.entity.UserTable;
import com.company.springboot.demo.vo.StuChooseTeam;

public interface UserService {
    /**
     * 登录
     * @param username
     * @param password
     * @return
     */
    public ServerRes<UserTable> login(String username, String password);

    /**
     * 忘记密码   根据用户名和电话校验
     * @param username
     * @param phone
     * @param newPassword
     * @return
     */
    ServerRes modifyPassword(String username,String phone,String newPassword);

    /**
     * 学生信息页面List
     * @return
     */
     ServerRes  stuInfo(UserTable userTable);

    /**
     * 学生信息页面 新增
     * @param userTable
     */
     void  addInfo( UserTable userTable);

    /**
     * 学生选择小组 List
     * @param stuChooseTeam
     * @return
     */
     ServerRes stuChooseTeam (StuChooseTeam stuChooseTeam);










}
