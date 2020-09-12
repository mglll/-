package com.company.springboot.demo.common;

public interface Const {
    String CURRENT_USER = "current_user";

    interface Role{
        int ADMIN = 0;
        int TEACHER = 1;
        int LEADER = 2;
        int STUDENT = 3;
    }
}
