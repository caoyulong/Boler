package edu.hlju.boler.service;

import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import edu.hlju.boler.dao.IApplicationDao;
import edu.hlju.boler.dao.IOnlineResumeDao;
import edu.hlju.boler.dao.IPersonInfoDao;
import edu.hlju.boler.dao.IRecruitmentDao;
import edu.hlju.boler.dao.IUserDao;
import edu.hlju.boler.pojo.po.Application;
import edu.hlju.boler.pojo.po.OnlineResume;
import edu.hlju.boler.pojo.po.PersonInfo;
import edu.hlju.boler.pojo.po.Recruitment;
import edu.hlju.boler.pojo.po.User;
import edu.hlju.boler.service.interfaces.IEmployeeService;

@Service("employeeService")
public class EmployeeService implements IEmployeeService {
    @Resource
    private IPersonInfoDao personInfoDao;

    @Resource
    private IUserDao userDao;

    @Resource
    private IApplicationDao applicationDao;

    @Resource
    private IOnlineResumeDao resumeDao;

    @Resource
    private IRecruitmentDao recruitmentDao;

    @Override
    public boolean delOnlineResume(int id) {
        try {
            resumeDao.deleteById(id);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public List<Application> queryAllApps(User user, int pageNum, int pageSize) {
        if (user != null) {
            try {
                Application application = new Application();  // 用于保存查询条件，需要查询的设值，不需要的设null
                application.setEmployee(user);
                return applicationDao.selectSplitCondition(application, pageNum, pageSize);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    @Override
    public List<Recruitment> queryAllRecruitments(int pageNum, int pageSize) {
        try {
            return recruitmentDao.selectSplit(pageNum, pageSize);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<OnlineResume> queryUserOnlineResumes(User employee) {
        if (employee != null) {
            OnlineResume resume = new OnlineResume();
            resume.setUser(employee);
            try {
                return resumeDao.selectSplitCondition(resume, 0, 0);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    @Override
    public boolean saveApplication(Application application) {
        if (application != null) {
            try {
                applicationDao.insert(application);
                return true;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    @Override
    public boolean saveOnlineResume(OnlineResume onlineResume) {
        if (onlineResume != null) {
            try {
                resumeDao.insert(onlineResume);
                return true;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    @Override
    public int savePersonInfo(PersonInfo info) {
        if (info != null) {
            try {
                return personInfoDao.insert(info);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return -1;
    }

    @Override
    public boolean updateEmployee(User employee) {
        if (employee != null) {
            try {
                userDao.updateByIdSelective(employee);
                return true;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    @Override
    public boolean updateOnlineResume(OnlineResume resume) {
        if (resume != null) {
            try {
                resumeDao.updateByIdSelective(resume);
                return true;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    @Override
    public boolean updatePersonInfo(PersonInfo info) {
        if (info != null) {
            try {
                personInfoDao.updateByIdSelective(info);
                return true;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

}
