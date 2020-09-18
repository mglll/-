package com.company.springboot.demo.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.company.springboot.demo.dao.entity.TeamZtable;
import com.company.springboot.demo.vo.TeamcVo;
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

    /**
     * 组长分组查询
     * @param teamcVo
     * @return
     */
    List<TeamcVo> findByfenzu(TeamcVo teamcVo);

    /**
     * 跟上一个接口一样 这是查询组员
     * @param teamcVo
     * @return
     */
    List<TeamcVo> findByzuyuan(TeamcVo teamcVo);
}
