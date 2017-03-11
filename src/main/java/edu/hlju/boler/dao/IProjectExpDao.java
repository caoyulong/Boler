package edu.hlju.boler.dao;

import java.sql.SQLException;
import java.util.List;

import org.springframework.cache.annotation.Cacheable;

import edu.hlju.boler.pojo.po.OnlineResume;
import edu.hlju.boler.pojo.po.ProjectExp;

public interface IProjectExpDao {

    int deleteById(Integer id) throws SQLException;

    int insert(ProjectExp record) throws SQLException;

    int insertSelective(ProjectExp record) throws SQLException;

    @Cacheable
    List<ProjectExp> selectAll() throws SQLException;

    @Cacheable
    ProjectExp selectById(Integer id) throws SQLException;

    @Cacheable
    List<ProjectExp> selectByResume(OnlineResume resume) throws SQLException;

    int updateById(ProjectExp record) throws SQLException;

    int updateByIdSelective(ProjectExp record) throws SQLException;

}
