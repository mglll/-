package com.company.springboot.demo.common;

public enum  Result {
    USER_NOT_EXISTS(103,"用户名不存在"),
    USER_NOTT_EXISTS(111,"用户不存在"),
    USER_YET_EXISTS(102,"用户名已存在"),
    REGISTER_ERROR(109,"注册失败"),
    UPDATE_USER_SUCCESS(203,"更新个人信息成功"),
    UPDATE_USER_ERROR(115,"更新个人信息失败"),
    USER_ZHAOBUDAO(118,"找不到当前用户"),
    USER_MANAGE_ERROR(119,"不是管理员，无法登录"),
    REGISTER_SUCCESS(202,"注册成功"),
    PHONE_YET_EXISTS(107,"电话已存在"),
    USER_AND_PHONE_NOT_EXISTS(105,"用户名或电话不存在"),
    USER_NOT_LOGIN(110,"用户未登录，无法获取当前信息"),
    PASSWORD_ERROR(104,"密码错误"),
    PASSWORD_OLD_ERROR(104,"旧密码错误"),
    LOGIN_SUCCESS(200,"登录成功"),
    VERIFY_SUCCESS(209,"校验成功"),
    MODIFY_PASSWORD_SUCCESS(206,"密码修改成功"),
    UPDATE_PASSWORD_SUCCESS(207,"密码更新成功"),
    UPDATE_PASSWORD_ERROR(122,"密码更新失败"),
    MODIFY_PASSWORD_ERROR(116,"密码修改失败"),
    MODIFY_PASSWORD_NULL(117,"找回密码问题为空"),
    WENTI_PASSWORD_NULL(118,"问题答案错误"),
    AGE_TOKEN_ERROR(119,"参数错误，token需要传递"),
    WUXIAO_TOKEN_ERROR(120,"Token无效或过期"),
    WUXIAO_TOKEN_RROER(121,"Token错误，请重新获取重置密码的token"),
    ILLEGLE_ARGUMENTS(400,"非法参数"),
    ILLEGLE_ERROR(110,"参数错误"),
    RESULT_SUCCESS(201,"SUCCESS"),
    CONFIG_READ_ERROR(108,"属性配置文件读取异常"),
    NEED_LOGIN(10,"NEED_LOGIN"),
    RESULT_ERROR(500,"ERROR");


    private final int code;
    private final String msg;
    Result(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }
    public int getCode() {
        return code;
    }
    public String getMsg() {
        return msg;
    }
}
