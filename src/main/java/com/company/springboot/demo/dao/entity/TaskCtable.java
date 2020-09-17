package com.company.springboot.demo.dao.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.models.auth.In;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;
@Data
@EqualsAndHashCode
public class TaskCtable extends Model {
    @TableId(value = "rwcid",type = IdType.AUTO)
    private Integer rwcid;//任务从ID
    private String rwid;//任务ID
    private String ztask;//组长任务
    private Date startdate;//任务开始日期
    private Date starttime;//任务开始时间
    private Date enddate;//任务结束日期
    private Date endtime;//任务结束时间
    private String del;//删除标志0删除1未删除
    private String createdBy;
    private Date createdTime;
    private String updatedBy;
    private Date updatedTime;
}
