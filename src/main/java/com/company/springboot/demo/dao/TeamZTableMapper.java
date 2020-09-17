package com.company.springboot.demo.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.company.springboot.demo.dao.entity.TeamZtable;
import com.company.springboot.demo.vo.TeamzVo;

import java.util.List;

public interface TeamZTableMapper extends BaseMapper<TeamZtable> {

    /**
     * 教师分组时进入页面默认查询所有
     * @param teamzVo
     * @return
     */
    List<TeamzVo> teamlist(TeamzVo teamzVo);

    /**
     * 根据id修改del为0代表逻辑删除
     * @param id
     */
    void updatedel(String id);

    /**
     * 查询组主id
     * @param zzid
     * @return
     */
    String findByZzid(String zzid);
}
