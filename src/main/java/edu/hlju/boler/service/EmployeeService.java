package edu.hlju.boler.service;

import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import edu.hlju.boler.dao.IApplicationDao;
import edu.hlju.boler.dao.IOnlineResumeDao;
import edu.hlju.boler.dao.IPersonInfoDao;
import edu.hlju.boler.dao.IRecruitmentDao;
import edu.hlju.boler.dao.IUserDao;
import edu.hlju.boler.datadictory.UserDataDict;
import edu.hlju.boler.pojo.po.Application;
import edu.hlju.boler.pojo.po.OnlineResume;
import edu.hlju.boler.pojo.po.PersonInfo;
import edu.hlju.boler.pojo.po.Recruitment;
import edu.hlju.boler.pojo.po.User;
import edu.hlju.boler.pojo.vo.BaseResponse;
import edu.hlju.boler.pojo.vo.StateResponse;
import edu.hlju.boler.service.interfaces.IEmployeeService;

@Service("employeeService")
public class EmployeeService extends BaseService implements IEmployeeService {
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
    public BaseResponse addApplication(HttpServletRequest request, Application application) {
        Object obj = request.getSession().getAttribute(UserService.USER_OBJECT);
        if (obj != null) {
            User user = (User) obj;
            application.setEmployee(user);
            try {
                applicationDao.insert(application);
                this.saveUserLog(request, "Add application");
                return this.getResponse(UserDataDict.OPERATIING_SUCCEED);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return this.getResponse(UserDataDict.OPERATIING_FAILED);
    }

    @Override
    public BaseResponse delOnlineResume(HttpServletRequest request, int id) {
        Object obj = request.getSession().getAttribute(UserService.USER_OBJECT);
        if (obj != null) {
            try {
                resumeDao.deleteById(id);
                this.saveUserLog(request, "Delete online resume.");
                return this.getResponse(UserDataDict.OPERATIING_SUCCEED);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return this.getResponse(UserDataDict.OPERATIING_FAILED);
    }

    @Override
    public BaseResponse queryAllApps(HttpServletRequest request, int pageNum, int pageSize) {
        Object obj = request.getSession().getAttribute(UserService.USER_OBJECT);
        if (obj != null) {
            try {
                User user = (User) obj;
                Application application = new Application();  // 用于保存查询条件，需要查询的设值，不需要的设null
                application.setEmployee(user);
                List<Application> result = applicationDao.selectSplitCondition(application, pageNum, pageSize);
                this.saveUserLog(request, "Querying all applications.");
                return this.getResponse(result);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return this.getResponse(UserDataDict.OPERATIING_FAILED);
    }

    @Override
    public BaseResponse queryAllRecruitments(HttpServletRequest request, int pageNum, int pageSize) {
        Object obj = request.getSession().getAttribute(UserService.USER_OBJECT);
        if (obj != null) {
            try {
                List<Recruitment> result = recruitmentDao.selectSplit(pageNum, pageSize);
                this.saveUserLog(request, "Querying all recruitments.");
                return this.getResponse(result);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return this.getResponse(UserDataDict.OPERATIING_FAILED);
    }

    @Override
    public BaseResponse queryPersonInfo(HttpServletRequest request) {
        Object obj = request.getSession().getAttribute(UserService.USER_OBJECT);
        if (obj != null) {
            User user = (User) obj;
            this.saveUserLog(request, "Query personnal information.");
            return this.getResponse(user.getPersonInfo());
        }
        return this.getResponse(UserDataDict.OPERATIING_FAILED);
    }

    @Override
    public BaseResponse queryUserOnlineResumes(HttpServletRequest request) {
        Object obj = request.getSession().getAttribute(UserService.USER_OBJECT);
        if (obj != null) {
            User user = (User) obj;
            OnlineResume resume = new OnlineResume();
            resume.setUser(user);
            try {
                List<OnlineResume> result = resumeDao.selectSplitCondition(resume, 0, 0);
                this.saveUserLog(request, "Querying user's online resumes.");
                return this.getResponse(result);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return this.getResponse(UserDataDict.OPERATIING_FAILED);
    }

    @Override
    public BaseResponse saveOnlineResume(HttpServletRequest request, OnlineResume onlineResume) {
        Object obj = request.getSession().getAttribute(UserService.USER_OBJECT);
        if (obj != null) {
            User user = (User) obj;
            onlineResume.setUser(user);
            try {
                resumeDao.insert(onlineResume);
                this.saveUserLog(request, "Save a online reume.");
                return this.getResponse(UserDataDict.OPERATIING_SUCCEED);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return this.getResponse(UserDataDict.OPERATIING_FAILED);
    }

    @Override
    public StateResponse savePersonInfo(HttpServletRequest request, PersonInfo info) {
        Object obj = request.getSession().getAttribute(UserService.USER_OBJECT);
        if (obj != null) {
            User logined = (User) obj;
            try {
                personInfoDao.insert(info);
                logined.setPersonInfo(info);
                userDao.updateById(logined);
                this.saveUserLog(request, "Save peronnal information.");
                return this.getResponse(UserDataDict.SAVE_PERSON_INFO_SCCUCEED);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return this.getResponse(UserDataDict.SAVE_PERSON_INFO_FAILED);
    }

    @Override
    public BaseResponse updateOnlineResume(HttpServletRequest request, OnlineResume resume) {
        Object obj = request.getAttribute(UserService.USER_OBJECT);
        if (obj != null) {
            try {
                resumeDao.updateById(resume);
                this.saveUserLog(request, "Update user's online resume.");
                return this.getResponse(UserDataDict.OPERATIING_SUCCEED);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return this.getResponse(UserDataDict.OPERATIING_FAILED);
    }

    @Override
    public BaseResponse updatePersonInfo(HttpServletRequest request, PersonInfo info) {
        Object obj = request.getSession().getAttribute(UserService.USER_OBJECT);
        if (obj != null) {
            try {
                personInfoDao.updateById(info);
                this.saveUserLog(request, "Update user's personal information.");
                this.getResponse(UserDataDict.OPERATIING_SUCCEED);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return this.getResponse(UserDataDict.OPERATIING_FAILED);
    }

}
