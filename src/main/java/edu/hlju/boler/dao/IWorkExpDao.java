package edu.hlju.boler.dao;

import java.sql.SQLException;
import java.util.List;

import org.springframework.cache.annotation.Cacheable;

import edu.hlju.boler.pojo.po.OnlineResume;
import edu.hlju.boler.pojo.po.WorkExp;

public interface IWorkExpDao {

    int deleteById(Integer id) throws SQLException;

    int insert(WorkExp record) throws SQLException;

    int insertSelective(WorkExp record) throws SQLException;

    @Cacheable
    List<WorkExp> selectAll() throws SQLException;

    @Cacheable
    WorkExp selectById(Integer id) throws SQLException;

    @Cacheable
    List<WorkExp> selectByResume(OnlineResume resume) throws SQLException;

    int updateById(WorkExp record) throws SQLException;

    int updateByIdSelective(WorkExp record) throws SQLException;

}
