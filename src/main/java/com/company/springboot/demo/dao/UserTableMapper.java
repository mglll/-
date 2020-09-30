package com.company.springboot.demo.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.company.springboot.demo.common.ServerRes;
import com.company.springboot.demo.dao.entity.UserTable;
import com.company.springboot.demo.dto.TokenDto;
import com.company.springboot.demo.vo.StuChooseTeam;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserTableMapper extends BaseMapper<UserTable> {

    /**
     * 用户名密码登录
     * @param username
     * @param password
     * @return
     */
    TokenDto login(@Param("username") String username, @Param("password") String password);

    /**
     * 通过用户名查找电话
     * @param username
     * @return
     */
    String selectPhoneByUsername(String username);

    /**
     * 修改新密码
     * @param username
     * @param newPassword
     * @return
     */
    int modifyPassword(@Param("username") String username,@Param("newPassword") String newPassword);

    /**
     * 根据用户名修改密码
     * @param username
     * @param password
     */
    void setNewPassword(@Param("username") String username, @Param("password") String password);

    /**
     * 通过用户名查询密码
     * @param username
     * @return
     */
    String getPasswordByName(@Param("username") String username);

    /**
     * 判断用户是否存在
     * @param username
     * @return
     */
    int checkUsername(@Param("username") String username);

    /**
     * 判断电话是否存在
     * @param phone
     * @return
     */
    int checkPhone(@Param("phone") String phone);

    /**
     * 通过姓名查找人员id
     * @param name
     * @return
     */
    String checkid(@Param("name") String name);

    /**
     * 忘记密码，根据提示问题，验证答案
     * @param username
     * @param phone
     * @param age
     * @return
     */
    int checkAnswer(@Param("username") String username,
                    @Param("phone") String phone,
                    @Param("age") String age);

    /**
     * 登录时修改密码，根据id查询密码
     * @param password
     * @param ryid
     * @return
     */
    int checkPassword(@Param("password")String password,@Param("ryid")Integer ryid);

    /**
     * 修改个人信息，校验phone存不存在
     * @param phone
     * @param ryid
     * @return
     */
    int checkPhoneByRyid(@Param("phone")String phone,@Param("ryid")Integer ryid);
    /**
     * 学生信息页面List
     * @param userTable
     * @return
     */
    List<UserTable> stuInfo(UserTable userTable);

    /**
     * 学生选择小组List
     * @param stuChooseTeam
     * @return
     */
    List<StuChooseTeam> studentChooseTeam( StuChooseTeam stuChooseTeam);



}
