package com.company.springboot.demo.service;

import com.company.springboot.demo.common.ServerRes;
import com.company.springboot.demo.dao.entity.UserTable;

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


}
