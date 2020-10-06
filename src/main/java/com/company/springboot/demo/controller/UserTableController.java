package com.company.springboot.demo.controller;

import com.company.springboot.demo.common.Const;
import com.company.springboot.demo.common.Result;
import com.company.springboot.demo.common.ServerRes;
import com.company.springboot.demo.common.TokenCache;
import com.company.springboot.demo.dao.entity.UserTable;
import com.company.springboot.demo.dto.TokenDto;
import com.company.springboot.demo.service.UserService;
import com.company.springboot.demo.vo.StuChooseTeam;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.UUID;

@Controller
@RequestMapping("/user")
public class UserTableController {

    @Autowired
    UserService userService;

    /**
     * 用户登录
     * @param
     * @param
     * @param session
     * @return
     */
    @RequestMapping(value = "/index",method = RequestMethod.POST)
    @ResponseBody
    public ServerRes<TokenDto> index(@RequestBody UserTable userTable, HttpSession session){
        if(StringUtils.isBlank(userTable.getUsername())||StringUtils.isBlank(userTable.getPassword())){
            return ServerRes.error(Result.ILLEGLE_ARGUMENTS);
        }
        ServerRes<TokenDto> index = userService.login(userTable.getUsername(), userTable.getPassword());
        if(index.getcode() == Result.LOGIN_SUCCESS.getCode()){

            session.setAttribute(Const.CURRENT_USER ,index.getData());
        }
        return index;
    }

    @RequestMapping(value = "/token",method = RequestMethod.POST)
    @ResponseBody
    public String token(String username){
        String forgetToken = UUID.randomUUID().toString();
        TokenCache.setkey(TokenCache.TOKEN_PREFIX+username,forgetToken);
        return forgetToken;
    }
    /**
     * 退出登录
     * @param session
     * @return
     */
    @RequestMapping(value = "/logout",method = RequestMethod.POST)
    @ResponseBody
    public ServerRes<String> logout(HttpSession session){
        session.removeAttribute(Const.CURRENT_USER);
        return ServerRes.success("退出成功");
    }

    /**
     * 注册
     * @param userTable
     * @return
     */
    @RequestMapping(value = "/register",method = RequestMethod.POST)
    @ResponseBody
    public ServerRes<String> register(UserTable userTable){
        return userService.reister(userTable);
    }

    /**
     * 忘记密码校验用户名和电话
     * @param username
     * @param phone
     * @param newPassword
     * @return
     */
    @RequestMapping(value = "/modifyPassword",method = RequestMethod.POST)
    @ResponseBody
    public ServerRes modifyPassword(String username, String phone, String newPassword){
        return null;
    }

    /**
     * 校验用户名和电话是否存在，为了防止恶意用户通过接口调用注册接口
     * @param str
     * @param type
     * @return
     */
    @RequestMapping(value = "/checkValid",method = RequestMethod.POST)
    @ResponseBody
    public ServerRes<String> checkValid(String str, String type){
        return userService.checkValid(str,type);
    }

    /**
     * 获取用户登录信息
     * @param session
     * @return
     */
    @RequestMapping(value = "/getUserInfo",method = RequestMethod.POST)
    @ResponseBody
    public ServerRes<TokenDto> getUserInfo(HttpSession session){
        TokenDto userTable = (TokenDto) session.getAttribute(Const.CURRENT_USER);
        if(userTable != null){
            return ServerRes.success(userTable);
        }
        return ServerRes.error(Result.USER_NOT_LOGIN);
    }

    /**
     * 找回密码校验手机问题获取
     * @param username
     * @return
     */
    @RequestMapping(value = "/forgetPhone",method = RequestMethod.POST)
    @ResponseBody
    public ServerRes<String> forgetPhone(String username){
        return  userService.selectQuestion(username);
    }

    /**
     * 忘记密码，根据提示问题，验证答案
     * @param username
     * @param phone
     * @param age
     * @return
     */
    @RequestMapping(value = "/forgetCheckAnswer",method = RequestMethod.POST)
    @ResponseBody
    public ServerRes<String> forgetCheckAnswer(String username,String phone,String age){
        return userService.checkphone(username,phone,age);
    }


    /**
     * 正确回答问题后  对密码进行重置(忘记密码时操作)
     * @param username
     * @param passwordNew
     * @param forgetToken
     * @return
     */
    @RequestMapping(value = "/forgetRestPassword",method = RequestMethod.POST)
    @ResponseBody
    public ServerRes<String> forgetRestPassword(String username,String passwordNew,String forgetToken){
        return userService.forgetRestPassword(username,passwordNew,forgetToken);
    }

    /**
     * 登录状态时的修改密码
     * @param session
     * @param passwordOld
     * @param passwordNew
     * @return
     */
    @RequestMapping(value = "/resetPassword",method = RequestMethod.POST)
    @ResponseBody
    public ServerRes<String> resetPassword(HttpSession session,String passwordOld,String passwordNew){
        UserTable userTable = (UserTable) session.getAttribute(Const.CURRENT_USER);
        if(userTable == null){
            return ServerRes.error(Result.USER_NOT_LOGIN);
        }
        return userService.resetPassword(passwordOld,passwordNew,userTable);
    }

    /**
     * 登录状态时，更新个人用户信息
     * @param session
     * @param userTable
     * @return
     */
    @RequestMapping(value = "/updateInformation",method = RequestMethod.POST)
    @ResponseBody
    public ServerRes<UserTable> updateInformation(HttpSession session,UserTable userTable){
        UserTable userTableone = (UserTable) session.getAttribute(Const.CURRENT_USER);
        if(userTableone == null){
            return ServerRes.error(Result.USER_NOT_LOGIN);
        }
        userTable.setRyid(userTableone.getRyid());
        userTable.setUsername(userTableone.getUsername());
        ServerRes<UserTable> res = userService.updateInforMation(userTable);
        if(res.getcode() == Result.LOGIN_SUCCESS.getCode()){
            session.setAttribute(Const.CURRENT_USER,res.getData());
        }
        return res;
    }

    /**
     * 登录后获取个人信息
     * @param session
     * @return
     */
    @RequestMapping(value = "/getIformation",method = RequestMethod.POST)
    @ResponseBody
    public ServerRes<UserTable> getIformation(HttpSession session){
        UserTable userTableone = (UserTable) session.getAttribute(Const.CURRENT_USER);
        if(userTableone == null){
            return ServerRes.createErrorCodeMsg(Result.NEED_LOGIN.getCode(),"用户未登录，返回状态码10，前段判断状态码并实现强制登录！");
        }
        return userService.getInforMation(userTableone.getRyid());
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

    /**
     * 管理员--人员信息列表
     * @param userTable
     * @return
     */
    @RequestMapping(value = "findUserInfo",method = RequestMethod.POST)
    @ResponseBody
    public ServerRes findUserInfo(UserTable userTable){
        ServerRes serverRes =userService.findUserInfo(userTable);
        return ServerRes.success(serverRes);
    }

}
