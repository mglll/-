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
     * 用户注册
     * @param userTable
     * @return
     */
    ServerRes<String> reister(UserTable userTable);

    /**
     * 校验用户名和电话是否存在，为了防止恶意用户通过接口调用注册接口
     * @param str
     * @param type
     * @return
     */
    ServerRes<String> checkValid(String str,String type);

    /**
     * 校验手机问题找回密码
     * @param username
     * @return
     */
    ServerRes selectQuestion(String username);

    /**
     * 忘记密码，根据提示问题，验证答案
     * @param username
     * @param phone
     * @param age
     * @return
     */
    ServerRes<String> checkphone(String username,String phone,String age);

    /**
     * 忘记密码   根据用户名和电话校验
     * @param username
     * @param phone
     * @param newPassword
     * @return
     */
    ServerRes modifyPassword(String username,String phone,String newPassword);

    /**
     * 正确回答问题后  对密码进行重置
     * @param username
     * @param passwordNew
     * @param forgetToken
     * @return
     */
    ServerRes<String> forgetRestPassword(String username,String passwordNew,String forgetToken);

    /**
     * 登录后修改密码
     * @param passwordOld
     * @param passwordNew
     * @param userTable
     * @return
     */
    ServerRes<String> resetPassword(String passwordOld,String passwordNew,UserTable userTable);

    /**
     * 登录后更改个人信息
     * @param userTable
     * @return
     */
    ServerRes<UserTable> updateInforMation(UserTable userTable);

    /**
     * 登录后获取个人信息
     * @param ryid
     * @return
     */
    ServerRes<UserTable> getInforMation(Integer ryid);
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
