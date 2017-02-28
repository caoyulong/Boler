package edu.hlju.boler.dao;

import java.sql.SQLException;
import java.util.List;

import edu.hlju.boler.pojo.po.Role;

public interface IRoleDao {

    int deleteById(Integer id) throws SQLException;

    int insert(Role record) throws SQLException;

    int insertSelective(Role record) throws SQLException;

    List<Role> selectAll() throws SQLException;

    Role selectById(Integer id) throws SQLException;

    int updateById(Role record) throws SQLException;

    int updateByIdSelective(Role record) throws SQLException;

}
