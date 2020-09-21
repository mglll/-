package com.company.springboot.demo.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TaskcVo {

    private String ztask;
    private Integer ryid;
    private String name;
    private Date starttime;
    private Date endtime;
    private Date submittasktime;

}
