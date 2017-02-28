package edu.hlju.boler.dao;

import java.sql.SQLException;
import java.util.List;

import edu.hlju.boler.pojo.po.ApplyState;

public interface IApplyStateDao {

    int deleteById(Integer id) throws SQLException;

    int insert(ApplyState record) throws SQLException;

    int insertSelective(ApplyState record) throws SQLException;

    List<ApplyState> selectAll() throws SQLException;

    ApplyState selectById(Integer id) throws SQLException;

    int updateById(ApplyState record) throws SQLException;

    int updateByIdSelective(ApplyState record) throws SQLException;

}
