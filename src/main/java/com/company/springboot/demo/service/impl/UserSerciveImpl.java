package com.company.springboot.demo.service.impl;

import com.company.springboot.demo.common.Const;
import com.company.springboot.demo.common.Result;
import com.company.springboot.demo.common.ServerRes;
import com.company.springboot.demo.common.TokenCache;
import com.company.springboot.demo.dao.UserTableMapper;
import com.company.springboot.demo.dao.entity.UserTable;
import com.company.springboot.demo.dto.TokenDto;
import com.company.springboot.demo.service.UserService;
import com.company.springboot.demo.util.MD5Utils;
import com.company.springboot.demo.vo.StuChooseTeam;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserSerciveImpl implements UserService {

    @Autowired
    UserTableMapper userTableMapper;
    @Override
    public ServerRes<TokenDto> login(String username, String password) {
        //判断用户是否存在
        int resultCount = userTableMapper.checkUsername(username);
        if(resultCount == 0){
            //如果不存在返回的错误信息
            return ServerRes.error(Result.USER_NOT_EXISTS);
        }
//        String md5Password = MD5Utils.MD5EncodeUtf8(password);
        //用户登录
        TokenDto userTable = userTableMapper.login(username,password);
        if(userTable == null){
            return ServerRes.error(Result.PASSWORD_ERROR);
        }
        String forgetToken = UUID.randomUUID().toString();
        TokenCache.setkey(TokenCache.TOKEN_PREFIX+username,forgetToken);
        //校验密码
        userTable.setPassword(StringUtils.EMPTY);
        userTable.setToken(forgetToken);
        return ServerRes.success(Result.LOGIN_SUCCESS,userTable);
    }

    @Override
    public ServerRes<String> reister(UserTable userTable){
        ServerRes serverRes = this.checkValid(userTable.getUsername(),Const.ValidType.USERNAME);
        if(Const.ValidType.USERNAME.equals(serverRes)){
            return ServerRes.error(Result.USER_YET_EXISTS);
        }
        serverRes = this.checkValid(userTable.getPhone(),Const.ValidType.PHONE);
        if(Const.ValidType.PHONE.equals(serverRes)){
            return ServerRes.error(Result.PHONE_YET_EXISTS);
        }
        userTable.setRole(Const.Role.STUDENT);
        userTable.setPassword(userTable.getPassword());
        int insert = userTableMapper.insert(userTable);
        if(insert == 0){
            return ServerRes.error(Result.REGISTER_ERROR);
        }
        return ServerRes.success(Result.REGISTER_SUCCESS);
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

    @Override
    public ServerRes<String> checkValid(String str,String type){
        //isNotBlank代表没有值如果是有空格的字符串为false
        if(StringUtils.isNotBlank(type)){
            //开始校验
            if(Const.ValidType.USERNAME.equals(type)){
                //判断用户是否存在
                int resultCount = userTableMapper.checkUsername(str);
                if(resultCount > 0){
                    //如果存在返回的错误信息
                    return ServerRes.error(Result.USER_YET_EXISTS);
                }
            }
            if(Const.ValidType.PHONE.equals(type)){
                int resultCount = userTableMapper.checkPhone(str);
                if(resultCount > 0){
                    //如果存在返回的错误信息
                    return ServerRes.error(Result.PHONE_YET_EXISTS);
                }
            }
        }else {
            return ServerRes.error(Result.ILLEGLE_ERROR);
        }
        return ServerRes.success(Result.VERIFY_SUCCESS);
    }

    @Override
    public ServerRes selectQuestion(String username){
        ServerRes<String> stringServerRes = this.checkValid(username, Const.ValidType.USERNAME);
        if(stringServerRes.getcode() == Result.LOGIN_SUCCESS.getCode()){
            //用户不存在
            return ServerRes.error(Result.USER_NOTT_EXISTS);
        }
        String s = userTableMapper.selectPhoneByUsername(username);
        if(StringUtils.isNotBlank(s)){
            return ServerRes.success(s);
        }
        return ServerRes.error(Result.MODIFY_PASSWORD_NULL);
    }


    @Override
    public ServerRes<String> checkphone(String username,String phone,String age){
        int resultCount =userTableMapper.checkAnswer(username,phone,age);
        if(resultCount>0){
            //说明问题和答案是这个用户的，并且是正确的
            String forgetToken = UUID.randomUUID().toString();
            TokenCache.setkey(TokenCache.TOKEN_PREFIX+username,forgetToken);
            return ServerRes.success(forgetToken);
        }
        return ServerRes.error(Result.WENTI_PASSWORD_NULL);
    }
    @Override
    public ServerRes<String> forgetRestPassword(String username,String passwordNew,String forgetToken){
        if(StringUtils.isBlank(forgetToken)){
            return ServerRes.error(Result.AGE_TOKEN_ERROR);
        }
        ServerRes<String> stringServerRes = this.checkValid(username, Const.ValidType.USERNAME);
        if(stringServerRes.getcode() == Result.LOGIN_SUCCESS.getCode()){
            //用户不存在
            return ServerRes.error(Result.USER_NOTT_EXISTS);
        }
        String token = TokenCache.getKey(TokenCache.TOKEN_PREFIX+username);
        if(StringUtils.isBlank(token)){
            return ServerRes.error(Result.WUXIAO_TOKEN_ERROR);
        }
        if(StringUtils.equals(forgetToken,token)){
//            String md5Password = MD5Utils.MD5EncodeUtf8(passwordNew);
            int rowCount = userTableMapper.modifyPassword(username,passwordNew);
            if(rowCount>0){
                return ServerRes.success(Result.MODIFY_PASSWORD_SUCCESS);
            }
        }else {
            return ServerRes.error(Result.WUXIAO_TOKEN_RROER);
        }
        return ServerRes.error(Result.MODIFY_PASSWORD_ERROR);
    }
    @Override
    public ServerRes<String> resetPassword(String passwordOld,String passwordNew,UserTable userTable){
        //防止横向越权，要校验一下这个用户的旧密码，一定要指定是这个用户，因为我们会查询一个count(1)，如果不指定id，那么结果就是true活count>0
        int resultCount = userTableMapper.checkPassword(passwordOld,userTable.getRyid());
        if(resultCount == 0){
            return ServerRes.error(Result.PASSWORD_OLD_ERROR);
        }
        userTable.setPassword(passwordNew);
        int updateCount = userTableMapper.updateById(userTable);
        if(updateCount > 0){
            return ServerRes.success(Result.UPDATE_PASSWORD_SUCCESS);
        }
        return ServerRes.error(Result.UPDATE_PASSWORD_ERROR);
    }
    @Override
    public ServerRes<UserTable> updateInforMation(UserTable userTable){
        //username是不能被更新的
        //phone也要进行一个校验，校验新的phone是不是已经存在，并且才在的phone如果相同的话，不能是我们当前的这个用户的
        int resultCount = userTableMapper.checkPhoneByRyid(userTable.getPhone(),userTable.getRyid());
        if(resultCount > 0){
            return ServerRes.error(Result.PHONE_YET_EXISTS);
        }
//        UserTable userTable1 = new UserTable();
//        userTable1.setRyid(userTable.getRyid());
//        userTable1.setPhone(userTable.getPhone());
        int updateCount = userTableMapper.updateById(userTable);
        if(updateCount > 0){
            return ServerRes.success(Result.UPDATE_USER_SUCCESS,userTable);
        }
        return ServerRes.error(Result.UPDATE_USER_ERROR);
    }
    @Override
    public ServerRes<UserTable> getInforMation(Integer ryid){
        UserTable userTable = userTableMapper.selectById(ryid);
        if(userTable == null){
            return ServerRes.error(Result.USER_ZHAOBUDAO);
        }
        userTable.setPassword(StringUtils.EMPTY);
        return ServerRes.success(userTable);
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

    /**
     * 学生选择小组List
     * @param stuChooseTeam
     * @return
     */
    @Override
    public ServerRes stuChooseTeam(StuChooseTeam stuChooseTeam) {
        List<StuChooseTeam> stuChooseTeamList = userTableMapper.studentChooseTeam(stuChooseTeam);
        return ServerRes.success(stuChooseTeamList);
    }
    /**
     * 管理员--人员信息列表
     * @param userTable
     * @return
     */
    @Override
    public ServerRes findUserInfo(UserTable userTable) {
        List<UserTable> userTables = userTableMapper.findUserInfo(userTable);
        return ServerRes.success(userTables);
    }
}
