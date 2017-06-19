package edu.hlju.boler.service;

import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.hlju.boler.dao.IApplicationDao;
import edu.hlju.boler.dao.IEmailTempDao;
import edu.hlju.boler.dao.IJobTypeDao;
import edu.hlju.boler.dao.IOnlineResumeDao;
import edu.hlju.boler.dao.IRecruitmentDao;
import edu.hlju.boler.pojo.po.Application;
import edu.hlju.boler.pojo.po.EmailTemplate;
import edu.hlju.boler.pojo.po.JobType;
import edu.hlju.boler.pojo.po.OnlineResume;
import edu.hlju.boler.pojo.po.Recruitment;
import edu.hlju.boler.pojo.po.User;
import edu.hlju.boler.service.interfaces.IEmployService;

@Service("employService")
@Transactional
public class EmployService implements IEmployService {
    @Resource
    private IJobTypeDao jobDao;

    @Resource
    private IRecruitmentDao recruitDao;

    @Resource
    private IApplicationDao applicationDao;

    @Resource
    private IEmailTempDao emailTempDao;

    @Resource
    private IOnlineResumeDao resumeDao;

    @Override
    public boolean addEmailTemplate(EmailTemplate emailTemp) {
        if (emailTemp != null) {
            try {
                emailTempDao.insert(emailTemp);
                return true;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    @Override
    public boolean delEmailTemp(int id) {
        try {
            emailTempDao.deleteById(id);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean publishRecruitment(Recruitment recruitment) {
        if (recruitment != null) {
            try {
                recruitDao.insertSelective(recruitment);
                return true;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    @Override
    public List<Application> queryAllApplications(User employ, int pageNum, int pageSize) {
        if (employ != null) {
            try {
                return applicationDao.selectByEmploy(employ, pageNum, pageSize);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    @Override
    public List<JobType> queryAllJobTypes() {
        try {
            return jobDao.selectAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Recruitment> queryAllRecuitments(Recruitment recruitment, int pageNum, int pageSize) {
        if (recruitment != null) {
            try {
                return recruitDao.selectSplitCondition(recruitment, pageNum, pageSize);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    @Override
    public Application queryAppById(int id) {
        try {
            return applicationDao.selectById(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<EmailTemplate> queryEmailTemp(User employ) {
        if (employ != null) {
            try {
                return emailTempDao.selectByUser(employ);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    @Override
    public OnlineResume queryResumeByEmployee(int employee) {
        try {
            return resumeDao.selectByUser(employee);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean updateApplication(Application application) {
        if (application != null) {
            try {
                applicationDao.updateByIdSelective(application);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    @Override
    public boolean updateEmailTemp(EmailTemplate emailTemp) {
        if (emailTemp != null) {
            try {
                emailTempDao.updateByIdSelective(emailTemp);
                return true;
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
        return false;
    }

    @Override
    public boolean updateRecruitment(Recruitment recruitment) {
        if (recruitment != null) {
            try {
                recruitDao.updateByIdSelective(recruitment);
                return true;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

}
