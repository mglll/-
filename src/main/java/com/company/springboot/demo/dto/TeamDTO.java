package com.company.springboot.demo.dto;

import com.company.springboot.demo.vo.TeamcVo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TeamDTO {
   private List<TeamcVo> byfenzu;
   private List<TeamcVo> byzuyuan;
}
