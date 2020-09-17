package com.company.springboot.demo.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.company.springboot.demo.dao.entity.LimitsTable;

public interface LimitsTableMapper extends BaseMapper<LimitsTable> {

    /**
     * 根据人员id更改学生状态为组长权限
     * @param ryid
     */
    void updateLimits(String ryid);
}
