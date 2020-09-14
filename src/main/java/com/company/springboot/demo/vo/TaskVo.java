package com.company.springboot.demo.vo;

import lombok.Data;

import java.util.Date;

@Data
public class TaskVo {
    private String jTask;
    private Integer kmid;
    private String kmName;
    private Integer ryid;
    private String name;
    private Date startdate;
    private Date enddate;
    private String status;
}
