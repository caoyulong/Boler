package edu.hlju.boler.core;

import java.sql.SQLException;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import edu.hlju.boler.core.interfaces.IUserLogService;
import edu.hlju.boler.core.message.MessageSender;
import edu.hlju.boler.dao.IUserLogDao;
import edu.hlju.boler.pojo.po.UserLog;

@Service("userLogService")
public class UserLogService implements IUserLogService {
    private static final Logger logger = LoggerFactory.getLogger(MessageSender.class);

    @Resource
    private IUserLogDao userLogDao;

    @Override
    public void add(UserLog log) {
        try {
            userLogDao.insert(log);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}
