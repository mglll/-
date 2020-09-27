package com.company.springboot.demo.common;

public interface Const {
   public static final String CURRENT_USER = "current_user";

    interface Role{
        String ADMIN = "1";
        String TEACHER = "2";
        String LEADER = "3";
        String STUDENT = "4";
        String FUZEREN = "5";
    }

    interface ValidType{
        String PHONE = "phone";
        String USERNAME = "username";
    }
}
