package com.company.springboot.demo.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TeamzVo {
    private Integer zzid;
    private String zname;
    private String kmName;
    private String name;
    private String zpronum;
    private String ztask;
    private String status;
}
