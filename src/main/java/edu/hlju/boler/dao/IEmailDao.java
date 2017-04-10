package edu.hlju.boler.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.cache.annotation.Cacheable;

import edu.hlju.boler.pojo.po.Email;

public interface IEmailDao {

    int deleteById(Integer id) throws SQLException;

    int insert(Email record) throws SQLException;

    int insertSelective(Email record) throws SQLException;

    @Cacheable
    List<Email> selectAll() throws SQLException;

    @Cacheable
    Email selectById(Integer id) throws SQLException;

    @Cacheable
    List<Email> selectSplit(@Param("pageNum") int pageNum, @Param("pageSize") int pageSize) throws SQLException;

    @Cacheable
    List<Email> selectSplitCondition(@Param("email") Email e, @Param("pageNum") int pageNum,
            @Param("pageSize") int pageSize) throws SQLException;

    int updateById(Email record) throws SQLException;

    int updateByIdSelective(Email record) throws SQLException;

}
