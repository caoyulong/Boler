package edu.hlju.boler.dao;

import java.sql.SQLException;
import java.util.List;

import edu.hlju.boler.pojo.po.Email;

public interface IEmailDao {

    int deleteById(Integer id) throws SQLException;

    int insert(Email record) throws SQLException;

    int insertSelective(Email record) throws SQLException;

    List<Email> selectAll() throws SQLException;

    Email selectById(Integer id) throws SQLException;

    int updateById(Email record) throws SQLException;

    int updateByIdSelective(Email record) throws SQLException;

}
