package edu.hlju.boler.service.interfaces;

import java.util.List;

import edu.hlju.boler.pojo.po.Application;
import edu.hlju.boler.pojo.po.EmailTemplate;
import edu.hlju.boler.pojo.po.JobType;
import edu.hlju.boler.pojo.po.OnlineResume;
import edu.hlju.boler.pojo.po.Recruitment;
import edu.hlju.boler.pojo.po.User;

public interface IEmployService {

    boolean addEmailTemplate(EmailTemplate emailTemp);

    boolean delEmailTemp(int id);

    boolean publishRecruitment(Recruitment recruitment);

    List<Application> queryAllApplications(User employ, int pageNum, int pageSize);

    List<JobType> queryAllJobTypes();

    List<Recruitment> queryAllRecuitments(Recruitment recruitment, int pageNum, int pageSize);

    Application queryAppById(int id);

    List<EmailTemplate> queryEmailTemp(User employ);

    OnlineResume queryResumeByEmployee(int employee);

    boolean updateApplication(Application application);

    boolean updateEmailTemp(EmailTemplate emailTemp);

    boolean updateRecruitment(Recruitment recruitment);

}
