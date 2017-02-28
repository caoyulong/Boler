package edu.hlju.boler.dao;

import java.sql.SQLException;
import java.util.List;

import edu.hlju.boler.pojo.po.WorkExperience;

public interface IWorkExpDao {

    int deleteById(Integer id) throws SQLException;

    int insert(WorkExperience record) throws SQLException;

    int insertSelective(WorkExperience record) throws SQLException;

    List<WorkExperience> selectAll() throws SQLException;

    WorkExperience selectById(Integer id) throws SQLException;

    int updateById(WorkExperience record) throws SQLException;

    int updateByIdSelective(WorkExperience record) throws SQLException;

}
