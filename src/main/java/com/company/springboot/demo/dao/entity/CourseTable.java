package com.company.springboot.demo.dao.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;
@Data
@EqualsAndHashCode
public class CourseTable extends Model {
    @TableId(value = "kcid")
    private Integer kcid;//课程ID
    private String kmid;//科目ID

    private String ryid;//授课教师
    private Date starttime;//上课时间
    private Date startday;//上课日期
    private String jskrrs;//教师可容人数
    private String sfyty;//是否有投影
    private String status;//状态
    private String del;//删除标志0删除1未删除
    private String createdBy;
    private Date createdTime;
    private String updatedBy;
    private Date updatedTime;
}
