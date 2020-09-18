package com.company.springboot.demo.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TeamcVo {
    private Integer zzid;
    private String zname;
    private String kmname;
    private String ryid;
    private String name;
    private String jtask;
    private String createdBy;
    private Date createdTime;
}
