package edu.hlju.boler.dao;

import java.sql.SQLException;
import java.util.List;

import org.springframework.cache.annotation.Cacheable;

import edu.hlju.boler.pojo.po.JobType;

public interface IJobTypeDao {
    int deleteById(Integer id) throws SQLException;

    int insert(JobType record) throws SQLException;

    int insertSelective(JobType record) throws SQLException;

    @Cacheable
    List<JobType> selectAll() throws SQLException;

    @Cacheable
    JobType selectById(Integer id) throws SQLException;

    int updateById(JobType record) throws SQLException;

    int updateByIdSelective(JobType record) throws SQLException;
}
