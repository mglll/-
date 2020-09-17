package com.company.springboot.demo.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddTeamVo {
    private String zTask;
    private String name;
    private String zpronum;
    private Date startdate;//任务开始日期
    private Date starttime;//任务开始时间
}
