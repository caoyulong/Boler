package edu.hlju.boler.dao;

import java.sql.SQLException;
import java.util.List;

import org.springframework.cache.annotation.Cacheable;

import edu.hlju.boler.pojo.po.PersonInfomation;

public interface IPersonInfoDao {

    int deleteById(Integer id) throws SQLException;

    int insert(PersonInfomation record) throws SQLException;

    int insertSelective(PersonInfomation record) throws SQLException;

    List<PersonInfomation> selectAll() throws SQLException;

    @Cacheable
    PersonInfomation selectById(Integer id) throws SQLException;

    int updateById(PersonInfomation record) throws SQLException;

    int updateByIdSelective(PersonInfomation record) throws SQLException;

}
