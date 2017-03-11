package edu.hlju.boler.dao;

import java.sql.SQLException;
import java.util.List;

import org.springframework.cache.annotation.Cacheable;

import edu.hlju.boler.pojo.po.EducationExp;
import edu.hlju.boler.pojo.po.OnlineResume;

public interface IEducationExpDao {

    int deleteById(Integer id) throws SQLException;

    int insert(EducationExp record) throws SQLException;

    int insertSelective(EducationExp record) throws SQLException;

    @Cacheable
    List<EducationExp> selectAll() throws SQLException;

    @Cacheable
    EducationExp selectById(Integer id) throws SQLException;

    @Cacheable
    List<EducationExp> selectByResume(OnlineResume resume) throws SQLException;

    int updateById(EducationExp record) throws SQLException;

    int updateByIdSelective(EducationExp record) throws SQLException;

}
