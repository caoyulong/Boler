package edu.hlju.boler.dao;

import java.sql.SQLException;
import java.util.List;

import edu.hlju.boler.pojo.po.Recruitment;

public interface IRecruitmentDao {

    int deleteById(Integer id) throws SQLException;

    int insert(Recruitment record) throws SQLException;

    int insertSelective(Recruitment record) throws SQLException;

    List<Recruitment> selectAll() throws SQLException;

    Recruitment selectById(Integer id) throws SQLException;

    int updateById(Recruitment record) throws SQLException;

    int updateByIdSelective(Recruitment record) throws SQLException;

}
