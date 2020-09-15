package com.company.springboot.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TaskDTO {
    private String jTask;
    private Integer kmid;
    private String kmName;
    private Integer ryid;
    private String name;
    private String startdate;
    private String enddate;
    private String status;
}
