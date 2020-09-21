package com.company.springboot.demo.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StuSubmitTaskVo {
    private Integer rwcid;
    private String ztask;
    private String kmid;
    private String kmname;
    private Date starttime;
    private Date endtime;
    private String submitstate;
    private Date submittasktime;
}
