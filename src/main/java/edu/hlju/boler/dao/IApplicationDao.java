package edu.hlju.boler.dao;

import java.sql.SQLException;
import java.util.List;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import edu.hlju.boler.pojo.po.Application;
import edu.hlju.boler.pojo.po.User;

@Repository
public interface IApplicationDao {

    int deleteById(Integer id) throws SQLException;

    int insert(Application record) throws SQLException;

    int insertSelective(Application record) throws SQLException;

    @Cacheable
    List<Application> selectAll() throws SQLException;

    @Cacheable
    List<Application> selectByEmploy(@Param("employ") User employ, @Param("pageNum") int pageNum,
            @Param("pageSize") int pageSize) throws SQLException;

    @Cacheable
    Application selectById(Integer id) throws SQLException;

    @Cacheable
    List<Application> selectSplit(@Param("pageNum") int pageNum, @Param("pageSize") int pageSize) throws SQLException;

    @Cacheable
    List<Application> selectSplitCondition(@Param("application") Application e, @Param("pageNum") int pageNum,
            @Param("pageSize") int pageSize) throws SQLException;

    int updateById(Application record) throws SQLException;

    int updateByIdSelective(Application record) throws SQLException;

}
