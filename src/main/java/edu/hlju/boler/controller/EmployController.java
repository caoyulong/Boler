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

import edu.hlju.boler.datadictory.UserDataDict;
import edu.hlju.boler.pojo.po.Application;
import edu.hlju.boler.pojo.po.Recruitment;
import edu.hlju.boler.pojo.po.User;
import edu.hlju.boler.pojo.vo.BaseResponse;
import edu.hlju.boler.service.interfaces.IEmployService;
import edu.hlju.boler.util.DateTimeUtil;

/**
 * 雇主角色控制层
 * @author jingqingyun
 */
@Controller
@RequestMapping(value = "api/employ")
public class EmployController extends BaseController {
    private static final String LOG_FORMAT = "[{}] {}";
    private static final Logger logger = LoggerFactory.getLogger(EmployController.class);

    @Resource
    private IEmployService employService;

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
            if (employService.publishRecruitment(recruitment)) {
                this.userLogging(request, "Publish recruitment.");
                return this.getResponse(UserDataDict.OPERATIING_SUCCEED);
            }
        }
        return this.getResponse(UserDataDict.OPERATIING_FAILED);
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
            }
        }
        return this.getResponse(UserDataDict.OPERATIING_FAILED);
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
            }
        }
        return this.getResponse(UserDataDict.OPERATIING_FAILED);
    }

    @ResponseBody
    @RequestMapping(value = "/update_app", method = RequestMethod.POST)
    public BaseResponse updateApplication(HttpServletRequest request, Application application) {
        Object obj = request.getSession().getAttribute(UserController.USER_OBJECT);
        if (obj != null) {
            User employ = (User) obj;
            application.setEmployee(employ);
            if (employService.updateApplication(application)) {
                this.userLogging(request, "Update application's state");
                return this.getResponse(UserDataDict.OPERATIING_SUCCEED);
            }
        }
        return this.getResponse(UserDataDict.OPERATIING_FAILED);
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
            }
        }
        return this.getResponse(UserDataDict.LOGIN_FAILED);
    }

    @Override
    protected void userLogging(HttpServletRequest request, String message) {
        this.logging(message);
        this.saveUserLog(request, message);
    }

}
