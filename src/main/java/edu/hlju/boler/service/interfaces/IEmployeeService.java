package edu.hlju.boler.service.interfaces;

import java.util.List;

import edu.hlju.boler.pojo.po.Application;
import edu.hlju.boler.pojo.po.JobType;
import edu.hlju.boler.pojo.po.OnlineResume;
import edu.hlju.boler.pojo.po.PersonInfo;
import edu.hlju.boler.pojo.po.Recruitment;
import edu.hlju.boler.pojo.po.User;

public interface IEmployeeService {

    boolean delOnlineResume(int id);

    List<Application> queryAllApps(User employee, int pageNum, int pageSize);

    List<JobType> queryAllJobTypes();

    List<Recruitment> queryAllRecruitments(int pageNum, int pageSize);

    List<Recruitment> queryAllRecruitments(Recruitment recruit, int pageNum, int pageSize);

    List<OnlineResume> queryUserOnlineResumes(User employee);

    boolean saveApplication(Application application);

    boolean saveOnlineResume(OnlineResume onlineResume);

    int savePersonInfo(PersonInfo info);

    boolean updateEmployee(User employee);

    boolean updateOnlineResume(OnlineResume resume);

    boolean updatePersonInfo(PersonInfo info);

}
