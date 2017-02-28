package edu.hlju.boler.dao;

import java.sql.SQLException;
import java.util.List;

import edu.hlju.boler.pojo.po.ProjectExperience;

public interface IProjectExpDao {

    int deleteById(Integer id) throws SQLException;

    int insert(ProjectExperience record) throws SQLException;

    int insertSelective(ProjectExperience record) throws SQLException;

    List<ProjectExperience> selectAll() throws SQLException;

    ProjectExperience selectById(Integer id) throws SQLException;

    int updateById(ProjectExperience record) throws SQLException;

    int updateByIdSelective(ProjectExperience record) throws SQLException;

}
