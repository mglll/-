package com.company.springboot.demo.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StuChooseTeam {
    private Integer zzid;
    private String zname;
    private String kmname;
    private String name;
    private String startdate;
}
