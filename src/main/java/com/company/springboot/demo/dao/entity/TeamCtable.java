package com.company.springboot.demo.dao.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;
@Data
@EqualsAndHashCode
public class TeamCtable extends Model {
    @TableId(value = "zcid",type = IdType.AUTO)
    private Integer zcid;//组从ID
    private String zzid;//组主ID
    private String ryid;//组员
    private String del;//删除标志0删除1未删除
    private String createdBy;
    private Date createdTime;
    private String updatedBy;
    private Date updatedTime;
}
