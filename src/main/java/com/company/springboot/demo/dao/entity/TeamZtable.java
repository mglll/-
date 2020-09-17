package com.company.springboot.demo.dao.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;
@Data
@EqualsAndHashCode
public class TeamZtable extends Model {
    @TableId(value = "zzid",type = IdType.AUTO)
    private Integer zzid;//组主ID
    private String kmid;//科目ID
    private String swid;//事务ID
    private String zname;//组名称
    private String ryid;//组长
    private String zpronum;//小组人数
    private String status;//状态0激活1未激活
    private String del;//删除标志0删除1未删除
    private String createdBy;
    private Date createdTime;
    private String updatedBy;
    private Date updatedTime;
}
