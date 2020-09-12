package com.company.springboot.demo.common;

public enum  Result {
    USER_NOT_EXISTS(103,"用户名不存在"),
    USER_AND_PHONE_NOT_EXISTS(103,"用户名或电话不存在"),
    PASSWORD_ERROR(104,"密码错误"),
    LOGIN_SUCCESS(201,"登录成功"),
    MODIFY_PASSWORD_SUCCESS(206,"密码修改成功"),
    MODIFY_PASSWORD_ERROR(116,"密码修改失败"),
    ILLEGLE_ARGUMENTS(400,"非法参数"),
    RESULT_SUCCESS(200,"SUCCESS"),
    CONFIG_READ_ERROR(108,"属性配置文件读取异常"),
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
