package com.company.springboot.demo.service.impl;

import com.company.springboot.demo.common.Result;
import com.company.springboot.demo.common.ServerRes;
import com.company.springboot.demo.dao.UserTableMapper;
import com.company.springboot.demo.dao.entity.UserTable;
import com.company.springboot.demo.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserSerciveImpl implements UserService {

    @Autowired
    UserTableMapper userTableMapper;
    @Override
    public ServerRes<UserTable> login(String username, String password) {
        //判断用户是否存在
        int resultCount = userTableMapper.checkUsername(username);
        if(resultCount == 0){
            //如果不存在返回的错误信息
            return ServerRes.error(Result.USER_NOT_EXISTS);
        }
        //用户登录
        UserTable userTable = userTableMapper.login(username,password);
        if(userTable == null){
            return ServerRes.error(Result.PASSWORD_ERROR);
        }
        //校验密码
        userTable.setPassword(StringUtils.EMPTY);
        return ServerRes.success(Result.LOGIN_SUCCESS,userTable);
    }

    @Override
    public ServerRes modifyPassword(String username, String phone, String newPassword) {
        //判断用户和电话是否存在
        int resultCount = userTableMapper.checkUsername(username);
        int resultCount1 = userTableMapper.checkPhone(phone);
        if(resultCount == 1 && resultCount1 == 1) {
            int flag = userTableMapper.modifyPassword(username, newPassword);
            if (flag > 0) {
                return ServerRes.success(Result.MODIFY_PASSWORD_SUCCESS);
            } else {
                return ServerRes.error(Result.MODIFY_PASSWORD_ERROR);
            }
        }
        return ServerRes.error(Result.USER_AND_PHONE_NOT_EXISTS);
    }

    /**
     * 学生信息页面List
     * @return
     */
    @Override
    public ServerRes stuInfo(UserTable userTable ) {
        List<UserTable> userTables = userTableMapper.stuInfo(userTable);
        return ServerRes.success(userTables);
    }

    /**
     * 学生信息页面 新增
     * @param userTable
     */
    @Override
    public void addInfo(UserTable userTable) {
      userTableMapper.insert(userTable);
    }
}
