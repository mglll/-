package com.company.springboot.demo.dto;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TaskCtableDTO extends Model {

    private String zTask;//组长任务
    private String startdate;//任务开始日期
    private String starttime;//任务开始时间
    private String del;//删除标志0删除1未删除
}
