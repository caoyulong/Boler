package edu.hlju.boler.dao;

import java.sql.SQLException;
import java.util.List;

import edu.hlju.boler.pojo.po.EducationExperience;

public interface IEducationExpDao {

    int deleteById(Integer id) throws SQLException;

    int insert(EducationExperience record) throws SQLException;

    int insertSelective(EducationExperience record) throws SQLException;

    List<EducationExperience> selectAll() throws SQLException;

    EducationExperience selectById(Integer id) throws SQLException;

    int updateById(EducationExperience record) throws SQLException;

    int updateByIdSelective(EducationExperience record) throws SQLException;

}
