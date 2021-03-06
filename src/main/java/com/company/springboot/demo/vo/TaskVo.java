package com.company.springboot.demo.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
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
