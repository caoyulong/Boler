package edu.hlju.boler.dao;

import java.sql.SQLException;
import java.util.List;

import org.springframework.cache.annotation.Cacheable;

import edu.hlju.boler.pojo.po.PersonInfo;

public interface IPersonInfoDao {

    int deleteById(Integer id) throws SQLException;

    int insert(PersonInfo record) throws SQLException;

    int insertSelective(PersonInfo record) throws SQLException;

    @Cacheable
    List<PersonInfo> selectAll() throws SQLException;

    @Cacheable
    PersonInfo selectById(Integer id) throws SQLException;

    int updateById(PersonInfo record) throws SQLException;

    int updateByIdSelective(PersonInfo record) throws SQLException;

}
