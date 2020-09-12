package com.company.springboot.demo.dao.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;
@Data
@EqualsAndHashCode
public class TaskZtable extends Model {
    @TableId(value = "rwid",type = IdType.AUTO)
    private Integer rwid;//任务ID
    private String kcid;//课程ID
    private String jTask;//教师任务
    private Date startdate;//任务开始日期
    private Date enddate;//任务结束日期
    private String status;//状态
    private String del;//删除标志0删除1未删除
    private String createdBy;
    private Date createdTime;
    private String updatedBy;
    private Date updatedTime;
}
