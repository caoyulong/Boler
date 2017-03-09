package edu.hlju.boler.dao;

import java.sql.SQLException;
import java.util.List;

import org.springframework.cache.annotation.Cacheable;

import edu.hlju.boler.pojo.po.UserLog;

public interface IUserLogDao {

    int deleteById(Integer id) throws SQLException;

    int insert(UserLog record) throws SQLException;

    int insertSelective(UserLog record) throws SQLException;

    @Cacheable
    List<UserLog> selectAll() throws SQLException;

    @Cacheable
    UserLog selectById(Integer id) throws SQLException;

    int updateById(UserLog record) throws SQLException;

    int updateByIdSelective(UserLog record) throws SQLException;

}
