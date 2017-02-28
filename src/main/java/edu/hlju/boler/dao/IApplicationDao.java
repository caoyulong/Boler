package edu.hlju.boler.dao;

import java.sql.SQLException;
import java.util.List;

import org.springframework.stereotype.Repository;

import edu.hlju.boler.pojo.po.Application;

@Repository
public interface IApplicationDao {

    int deleteById(Integer id) throws SQLException;

    int insert(Application record) throws SQLException;

    int insertSelective(Application record) throws SQLException;

    List<Application> selectAll() throws SQLException;

    Application selectById(Integer id) throws SQLException;

    int updateById(Application record) throws SQLException;

    int updateByIdSelective(Application record) throws SQLException;

}
