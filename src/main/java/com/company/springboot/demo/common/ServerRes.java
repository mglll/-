package com.company.springboot.demo.common;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.io.Serializable;
/*
通过使用@JsonSerialize注解，返回json对象时，jackson不对值为null的属性进行包含和处理
例如：
1-当回传成功状态码status的值是200时，msg和data都为null
2-当回传错误信息（status、msg）时，data为null
这两种情况，json结果中都不必包含null值
 */
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class ServerRes<T> implements Serializable {
    private static String SUCCESS ="正常";

    private static String ERROR = "错误";

    private int code;
    private String msg;
    private T data;

    public ServerRes(int code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }
    private ServerRes(int code,T data) {
        this.code = code;
        this.data = data;
    }
    private ServerRes(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }
    private ServerRes(int code) {
        this.code = code;
    }
    //使用静态方法
    public static<T>  ServerRes<T> success(Result result,T data){
        return new ServerRes<T>(result.getCode(),result.getMsg(),data);
    }
    //返回其他的成功信息
    public static<T> ServerRes<T> success(Result result){
        return new ServerRes<T>(result.getCode(),result.getMsg());
    }

    //返回其他的成功信息
    public static<T> ServerRes<T> success(T data){
        return new ServerRes<T>(Result.RESULT_SUCCESS.getCode(),SUCCESS,data);
    }
    //使用@JsonIgnore，直接返回此方法的返回值，无需进行json序列化处理
    @JsonIgnore
    public static int success(){
        return Result.RESULT_SUCCESS.getCode();
    }

    public static ServerRes error(String msg){
        return new ServerRes(Result.RESULT_SUCCESS.getCode(),msg,null);
    }

    public static ServerRes OK(String msg){
        return new ServerRes(Result.RESULT_SUCCESS.getCode(),msg,null);
    }

    //返回Error信息
    public static<T> ServerRes<T> error(Result result){
        return new ServerRes<T>(result.getCode(),result.getMsg());
    }

    public static<T> ServerRes<T> error(){
        return new ServerRes(Result.RESULT_ERROR.getCode(),Result.RESULT_ERROR.getMsg());
    }
    public int getcode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    public T getData() {
        return data;
    }

    @Override
    public String toString() {
        return "ServerRes{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }

    /*
 其他返回类型
 例如：
 ILLEGAL_ARGUMENT(2,"ILLEGAL_ARGUMENT"),
 NEED_LOGIN(20,"NEED_LOGIN");
 设定一个通用的返回应答对象的方法
  */
    public static<T> ServerRes<T> createErrorCodeMsg(int errCode,String errMsg) {
        return new ServerRes<T>(errCode, errMsg);
    }
}
