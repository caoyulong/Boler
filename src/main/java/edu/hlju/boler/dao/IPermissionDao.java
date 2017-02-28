package edu.hlju.boler.dao;

import java.sql.SQLException;
import java.util.List;

import edu.hlju.boler.pojo.po.Permission;

public interface IPermissionDao {

    int deleteById(Integer id) throws SQLException;

    int insert(Permission record) throws SQLException;

    int insertSelective(Permission record) throws SQLException;

    List<Permission> selectAll() throws SQLException;

    Permission selectById(Integer id) throws SQLException;

    int updateById(Permission record) throws SQLException;

    int updateByIdSelective(Permission record) throws SQLException;

}
