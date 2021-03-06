package edu.hlju.boler.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import edu.hlju.boler.datadictory.ApplicationState;
import edu.hlju.boler.datadictory.EmailDataDict;
import edu.hlju.boler.datadictory.UserDataDict;
import edu.hlju.boler.pojo.po.Application;
import edu.hlju.boler.pojo.po.EmailTemplate;
import edu.hlju.boler.pojo.po.OnlineResume;
import edu.hlju.boler.pojo.po.Recruitment;
import edu.hlju.boler.pojo.po.User;
import edu.hlju.boler.pojo.vo.BaseResponse;
import edu.hlju.boler.service.interfaces.IEmployService;
import edu.hlju.boler.util.DateTimeUtil;

/**
 * 雇主角色控制层
 *
 * @author jingqingyun
 */
@Controller
@RequestMapping(value = "api/employ")
public class EmployController extends BaseController {
    private static final String LOG_FORMAT = "[{}] {}";
    private static final Logger logger = LoggerFactory.getLogger(EmployController.class);

    @Resource
    private IEmployService employService;

    @ResponseBody
    @RequestMapping(value = "/add_emailtemp", method = RequestMethod.POST)
    public BaseResponse addEmailTemplate(HttpServletRequest request, EmailTemplate emailTemp) {
        Object obj = request.getSession().getAttribute(UserController.USER_OBJECT);
        if (obj != null) {
            User employ = (User) obj;
            emailTemp.setUser(employ);
            if (employService.addEmailTemplate(emailTemp)) {
                this.userLogging(request, "Add an email template.");
                return this.getResponse(UserDataDict.OPERATIING_SUCCEED);
            } else {
                return this.getResponse(UserDataDict.OPERATIING_FAILED);
            }
        }
        return this.getResponse(UserDataDict.OPERATIING_FAILED);
    }

    @ResponseBody
    @RequestMapping(value = "/close_recruit")
    public BaseResponse closeRecruitment(HttpServletRequest request, int id) {
        Object obj = request.getSession().getAttribute(UserController.USER_OBJECT);
        if (obj != null) {
            Recruitment recruit = new Recruitment();
            recruit.setId(id);
            recruit.setState((byte) ApplicationState.CLOSED.ordinal());
            if (employService.updateRecruitment(recruit)) {
                this.userLogging(request, "Change state of recruitment.");
                return this.getResponse(UserDataDict.OPERATIING_SUCCEED);
            } else {
                return this.getResponse(UserDataDict.OPERATIING_FAILED);
            }
        }
        return this.getResponse(UserDataDict.NOT_LOGINED);
    }

    @ResponseBody
    @RequestMapping(value = "/del_emailtemp")
    public BaseResponse delEmailTemp(HttpServletRequest request, int id) {
        Object obj = request.getSession().getAttribute(UserController.USER_OBJECT);
        if (obj != null && employService.delEmailTemp(id)) {
            this.userLogging(request, "Delete an email template.");
            return this.getResponse(UserDataDict.OPERATIING_SUCCEED);
        }
        return this.getResponse(UserDataDict.OPERATIING_FAILED);
    }

    @Override
    public void logging(String log) {
        logger.info(LOG_FORMAT, DateTimeUtil.now(), log);
    }

    @ResponseBody
    @RequestMapping(value = "/publish_recruit", method = RequestMethod.POST)
    public BaseResponse publishRecruitment(HttpServletRequest request, Recruitment recruitment) {
        Object obj = request.getSession().getAttribute(UserController.USER_OBJECT);
        if (obj != null) {
            recruitment.setEmploy((User) obj);
            recruitment.setState((byte) ApplicationState.NEW.ordinal());
            if (employService.publishRecruitment(recruitment)) {
                this.userLogging(request, "Publish recruitment.");
                return this.getResponse(UserDataDict.OPERATIING_SUCCEED);
            } else {
                return this.getResponse(UserDataDict.OPERATIING_FAILED);
            }
        }
        return this.getResponse(UserDataDict.NOT_LOGINED);
    }

    @ResponseBody
    @RequestMapping(value = "/all_apps", method = RequestMethod.POST)
    public BaseResponse queryAllApplications(HttpServletRequest request, int pageNum, int pageSize) {
        Object obj = request.getSession().getAttribute(UserController.USER_OBJECT);
        if (obj != null) {
            User employ = (User) obj;
            List<Application> result = employService.queryAllApplications(employ, pageNum, pageSize);
            if (result != null) {
                this.userLogging(request, "Query all applications.");
                return this.getResponse(result);
            } else {
                return this.getResponse(UserDataDict.OPERATIING_FAILED);
            }
        }
        return this.getResponse(UserDataDict.NOT_LOGINED);
    }

    @ResponseBody
    @RequestMapping(value = "/all_job_types")
    public BaseResponse queryAllJobTypes() {
        this.logging("Query all job types.");
        return this.getResponse(employService.queryAllJobTypes());
    }

    @ResponseBody
    @RequestMapping(value = "/all_recruits")
    public BaseResponse queryAllRecruitments(HttpServletRequest request, int pageNum, int pageSize) {
        Object obj = request.getSession().getAttribute(UserController.USER_OBJECT);
        if (obj != null) {
            User employ = (User) obj;
            Recruitment recruitment = new Recruitment();
            recruitment.setEmploy(employ);
            List<Recruitment> result = employService.queryAllRecuitments(recruitment, pageNum, pageSize);
            if (result != null) {
                this.userLogging(request, "Query all recruitments.");
                return this.getResponse(result);
            } else {
                return this.getResponse(UserDataDict.OPERATIING_FAILED);
            }
        }
        return this.getResponse(UserDataDict.NOT_LOGINED);
    }

    @RequestMapping(value = "/edu_exp")
    @ResponseBody
    public BaseResponse queryEduExp(HttpServletRequest request, int recruit) {
        // TODO
        return null;
    }

    @ResponseBody
    @RequestMapping(value = "/all_emailtemp")
    public BaseResponse queryEmailTemp(HttpServletRequest request) {
        Object obj = request.getSession().getAttribute(UserController.USER_OBJECT);
        if (obj != null) {
            User employ = (User) obj;
            List<EmailTemplate> result = employService.queryEmailTemp(employ);
            if (result != null) {
                this.userLogging(request, "Query employ's email templates.");
                return this.getResponse(result);
            } else {
                return this.getResponse(UserDataDict.OPERATIING_FAILED);
            }
        }
        return this.getResponse(UserDataDict.NOT_LOGINED);
    }

    @RequestMapping(value = "proj_exp")
    @ResponseBody
    public BaseResponse queryProjExp(HttpServletRequest request, int recruit) {
        // TODO
        return null;
    }

    @RequestMapping(value = "/query_resume", method = RequestMethod.POST)
    public BaseResponse queryResumeByEmployee(HttpServletRequest request, int employee) {
        Object object = request.getSession().getAttribute(UserController.USER_OBJECT);
        if (object != null) {
            OnlineResume resume = employService.queryResumeByEmployee(employee);
            if (resume != null) {
                this.userLogging(request, "Query employee's online resume");
                return this.getResponse(resume);
            }
            return this.getResponse(UserDataDict.OPERATIING_FAILED);
        }
        return this.getResponse(UserDataDict.NOT_LOGINED);
    }

    @RequestMapping(value = "/work_exp")
    @ResponseBody
    public BaseResponse queryWorkExp(HttpServletRequest request, int recruit) {
        // TODO
        return null;
    }

    @ResponseBody
    @RequestMapping(value = "/update_app_state", method = RequestMethod.POST)
    public BaseResponse updateApplicationState(HttpServletRequest request, int id, byte state) {
        Object obj = request.getSession().getAttribute(UserController.USER_OBJECT);
        if (obj != null) {
            User employ = (User) obj;
            Application app = employService.queryAppById(id);
            if (app == null) {
                return this.getResponse(UserDataDict.OPERATIING_FAILED);
            }
            app.setState(state);
            if (employService.updateApplication(app)) {
                this.userLogging(request, "Update application's state");

                String from = employ.getEmail();
                String to = app.getEmployee().getEmail();
                String subject = EmailDataDict.APPLICATION_STATE_UPDATED.getSubject();
                String text = EmailDataDict.APPLICATION_STATE_UPDATED.getText();
                this.notifyByEmail(to, from, subject, text, employ);
                return this.getResponse(UserDataDict.OPERATIING_SUCCEED);
            } else {
                return this.getResponse(UserDataDict.OPERATIING_FAILED);
            }
        }
        return this.getResponse(UserDataDict.NOT_LOGINED);
    }

    @ResponseBody
    @RequestMapping(value = "/update_emailtemp", method = RequestMethod.POST)
    public BaseResponse updateEmailTemp(HttpServletRequest request, EmailTemplate emailTemp) {
        Object obj = request.getSession().getAttribute(UserController.USER_OBJECT);
        if (obj != null) {
            if (employService.updateEmailTemp(emailTemp)) {
                this.userLogging(request, "Update email template.");
                return this.getResponse(UserDataDict.OPERATIING_SUCCEED);
            } else {
                return this.getResponse(UserDataDict.OPERATIING_FAILED);
            }
        }
        return this.getResponse(UserDataDict.NOT_LOGINED);
    }

    @ResponseBody
    @RequestMapping(value = "/update_recruit", method = RequestMethod.POST)
    public BaseResponse updateRecruitment(HttpServletRequest request, Recruitment recruitment) {
        Object obj = request.getSession().getAttribute(UserController.USER_OBJECT);
        if (obj != null) {
            User employ = (User) obj;
            recruitment.setEmploy(employ);
            if (employService.updateRecruitment(recruitment)) {
                this.userLogging(request, "Update recruitment.");
                return this.getResponse(UserDataDict.OPERATIING_SUCCEED);
            } else {
                return this.getResponse(UserDataDict.OPERATIING_FAILED);
            }
        }
        return this.getResponse(UserDataDict.NOT_LOGINED);
    }

    @Override
    protected void userLogging(HttpServletRequest request, String message) {
        this.logging(message);
        this.saveUserLog(request, message);
    }

}
