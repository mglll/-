package com.company.springboot.demo.vo;

import lombok.Data;

import java.util.Date;
@Data
public class CourseVo {
    private Integer kcid;
    private Integer kmid;
    private String kmName;
    private Integer ryid;
    private String name;
    private Date starttime;
    private Date startday;
    private String jsclass;
    private String kctime;
    private String status;
}
