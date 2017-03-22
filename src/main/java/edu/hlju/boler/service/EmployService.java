package edu.hlju.boler.service;

import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import edu.hlju.boler.dao.IJobTypeDao;
import edu.hlju.boler.datadictory.UserDataDict;
import edu.hlju.boler.pojo.po.JobType;
import edu.hlju.boler.pojo.po.Recruitment;
import edu.hlju.boler.pojo.vo.BaseResponse;
import edu.hlju.boler.service.interfaces.IEmployService;

@Service("employService")
public class EmployService extends BaseService implements IEmployService {
    @Resource
    private IJobTypeDao jobDao;

    @Override
    public BaseResponse publishRecruitment(HttpServletRequest request, Recruitment recruitment) {
        return null;
    }

    @Override
    public BaseResponse queryAllJobTypes() {
        try {
            List<JobType> result = jobDao.selectAll();
            return this.getResponse(result);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return this.getResponse(UserDataDict.OPERATIING_FAILED);
    }

    @Override
    public BaseResponse queryAllApplications(HttpServletRequest request) {
        return null;
    }

}
