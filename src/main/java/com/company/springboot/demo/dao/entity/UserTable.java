package com.company.springboot.demo.dao.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;
@Data
@EqualsAndHashCode
public class UserTable extends Model {
    @TableId(value = "ryid",type = IdType.AUTO)
    private Integer ryid;//人员ID
    private String name;//姓名
    private String stuteaNum;//学号/工号
    private String username;//用户名
    private String password;//密码
    private String age;//年龄
    private String sex;//性别
    private String phone;//电话
    private String address;//户籍
    private String nowadd;//现住址
    private String idNum;//身份证号
    private String politics;//政治面貌
    private String honor;//荣誉
    private String synopsis;//简介
    private Date birth;//出生日期
    private String del;//删除标志0删除1未删除
    private String createdBy;
    private Date createdTime;
    private String updatedBy;
    private Date updatedTime;
}
