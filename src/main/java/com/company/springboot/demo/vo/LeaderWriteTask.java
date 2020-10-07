package com.company.springboot.demo.vo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LeaderWriteTask {
    private Integer rwcid;
    private String rwid;
    private String ryid;
    private String name;
    private String starttime;
    private String endtime;
    private String ztask;
}
