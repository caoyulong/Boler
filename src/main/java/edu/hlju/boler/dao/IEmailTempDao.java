package edu.hlju.boler.dao;

import java.sql.SQLException;
import java.util.List;

import org.springframework.cache.annotation.Cacheable;

import edu.hlju.boler.pojo.po.EmailTemplate;
import edu.hlju.boler.pojo.po.User;

public interface IEmailTempDao {

    int deleteById(Integer id) throws SQLException;

    int insert(EmailTemplate record) throws SQLException;

    int insertSelective(EmailTemplate record) throws SQLException;

    @Cacheable
    List<EmailTemplate> selectAll() throws SQLException;

    @Cacheable
    List<EmailTemplate> selectByEmploy(User employ) throws SQLException;

    @Cacheable
    EmailTemplate selectById(Integer id) throws SQLException;

    int updateById(EmailTemplate record) throws SQLException;

    int updateByIdSelective(EmailTemplate record) throws SQLException;

}
