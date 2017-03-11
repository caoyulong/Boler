package edu.hlju.boler.dao;

import java.sql.SQLException;
import java.util.List;

import org.springframework.cache.annotation.Cacheable;

import edu.hlju.boler.pojo.po.User;

public interface IUserDao {

    int deleteById(Integer id) throws SQLException;

    int insert(User record) throws SQLException;

    int insertSelective(User record) throws SQLException;

    List<User> selectAll() throws SQLException;

    @Cacheable
    User selectByEmail(String email) throws SQLException;

    @Cacheable
    User selectById(Integer id) throws SQLException;

    int updateById(User record) throws SQLException;

    int updateByIdSelective(User record) throws SQLException;

}
