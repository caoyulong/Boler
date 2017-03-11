package edu.hlju.boler.dao;

import java.sql.SQLException;
import java.util.List;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.repository.query.Param;

import edu.hlju.boler.pojo.po.OnlineResume;

public interface IOnlineResumeDao {

    int deleteById(Integer id) throws SQLException;

    int insert(OnlineResume record) throws SQLException;

    int insertSelective(OnlineResume record) throws SQLException;

    @Cacheable
    List<OnlineResume> selectAll() throws SQLException;

    @Cacheable
    OnlineResume selectById(Integer id) throws SQLException;

    @Cacheable
    List<OnlineResume> selectSplit(@Param("pageNum") int pageNum, @Param("pageSize") int pageSize) throws SQLException;

    @Cacheable
    List<OnlineResume> selectSplitCondition(@Param("onlineResume") OnlineResume e, @Param("pageNum") int pageNum,
            @Param("pageSize") int pageSize) throws SQLException;

    int updateById(OnlineResume record) throws SQLException;

    int updateByIdSelective(OnlineResume record) throws SQLException;

}
