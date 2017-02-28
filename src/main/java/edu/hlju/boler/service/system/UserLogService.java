package edu.hlju.boler.service.system;

import java.sql.SQLException;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import edu.hlju.boler.dao.IUserLogDao;
import edu.hlju.boler.pojo.po.UserLog;
import edu.hlju.boler.service.interfaces.system.IUserLogService;

@Service("userLogService")
public class UserLogService implements IUserLogService {
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
