package edu.hlju.boler.service;

import java.sql.SQLException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import edu.hlju.boler.core.interfaces.IMessageSender;
import edu.hlju.boler.dao.IPersonInfoDao;
import edu.hlju.boler.dao.IUserDao;
import edu.hlju.boler.datadictory.UserDataDict;
import edu.hlju.boler.pojo.po.PersonInfo;
import edu.hlju.boler.pojo.po.User;
import edu.hlju.boler.pojo.po.UserLog;
import edu.hlju.boler.pojo.vo.StateResponse;
import edu.hlju.boler.service.interfaces.IEmployeeService;

@Service("employeeService")
public class EmployeeService extends BaseService implements IEmployeeService {
    @Resource
    private IPersonInfoDao personInfoDao;

    @Resource
    private IUserDao userDao;

    @Resource
    private IMessageSender messageSender;

    @Override
    public StateResponse savePersonInfo(HttpServletRequest request, PersonInfo info) {
        Object obj = request.getSession().getAttribute(UserService.USER_OBJECT);
        if (obj != null) {
            User logined = (User) obj;
            try {
                personInfoDao.insert(info);
                logined.setPersonInfo(info);
                userDao.updateById(logined);
                messageSender.send(new UserLog(request.getRemoteAddr(), logined, "Save peronnal information."));
                return new StateResponse(UserDataDict.SAVE_PERSON_INFO_SCCUCEED);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return new StateResponse(UserDataDict.SAVE_PERSON_INFO_FAILED);
    }

}
