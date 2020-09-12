package com.company.springboot.demo.dao.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;
@Data
@EqualsAndHashCode
public class WorkFiowTable extends Model {
    @TableId(value = "swid",type = IdType.AUTO)
    private Integer swid;//事务ID
    private String sname;//事务名称

}
