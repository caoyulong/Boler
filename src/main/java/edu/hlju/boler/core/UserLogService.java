package edu.hlju.boler.core;

import java.sql.SQLException;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import edu.hlju.boler.core.interfaces.IUserLogService;
import edu.hlju.boler.dao.IUserLogDao;
import edu.hlju.boler.pojo.po.UserLog;
import edu.hlju.boler.util.DateTimeUtil;

@Service("userLogService")
public class UserLogService implements IUserLogService {
    private static final Logger logger = LoggerFactory.getLogger(UserLogService.class);

    @Resource
    private IUserLogDao userLogDao;

    @Override
    public void add(UserLog log) {
        try {
            userLogDao.insert(log);
            logger.info("[{}] {}", DateTimeUtil.now(), "Save a UserLog.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
