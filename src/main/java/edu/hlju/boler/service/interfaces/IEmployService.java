package edu.hlju.boler.service.interfaces;

import java.util.List;

import edu.hlju.boler.pojo.po.Application;
import edu.hlju.boler.pojo.po.JobType;
import edu.hlju.boler.pojo.po.Recruitment;
import edu.hlju.boler.pojo.po.User;

public interface IEmployService {

    boolean publishRecruitment(Recruitment recruitment);

    List<Application> queryAllApplications(User employ, int pageNum, int pageSize);

    List<JobType> queryAllJobTypes();

    List<Recruitment> queryAllRecuitments(Recruitment recruitment, int pageNum, int pageSize);

    boolean updateApplication(Application application);

    boolean updateRecruitment(Recruitment recruitment);

}
