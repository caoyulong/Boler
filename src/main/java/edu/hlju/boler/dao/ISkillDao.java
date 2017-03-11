package edu.hlju.boler.dao;

import java.sql.SQLException;
import java.util.List;

import org.springframework.cache.annotation.Cacheable;

import edu.hlju.boler.pojo.po.Skill;

public interface ISkillDao {

    int deleteById(Integer id) throws SQLException;

    int insert(Skill record) throws SQLException;

    int insertSelective(Skill record) throws SQLException;

    @Cacheable
    List<Skill> selectAll() throws SQLException;

    @Cacheable
    Skill selectById(Integer id) throws SQLException;

    int updateById(Skill record) throws SQLException;

    int updateByIdSelective(Skill record) throws SQLException;

}
