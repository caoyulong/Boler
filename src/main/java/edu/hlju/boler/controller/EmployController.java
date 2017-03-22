package edu.hlju.boler.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import edu.hlju.boler.pojo.po.Application;
import edu.hlju.boler.pojo.po.Recruitment;
import edu.hlju.boler.pojo.vo.BaseResponse;
import edu.hlju.boler.service.interfaces.IEmployService;
import edu.hlju.boler.util.DateTimeUtil;

/**
 * 雇主角色控制层
 * @author jingqingyun
 */
@Controller
@RequestMapping(value = "api/employ")
public class EmployController implements IControllerLog {
    private static final String LOG_FORMAT = "[{}] {}";
    private static final Logger logger = LoggerFactory.getLogger(EmployController.class);

    @Resource
    private IEmployService employService;

    @ResponseBody
    @RequestMapping(value = "/change_app_state", method = RequestMethod.POST)
    public BaseResponse changeAppState(HttpServletRequest request, Application application) {
        return employService.changeAppState(request, application);
    }

    @Override
    public void logging(String log) {
        logger.info(LOG_FORMAT, DateTimeUtil.now(), log);
    }

    @ResponseBody
    @RequestMapping(value = "/publish_recruit", method = RequestMethod.POST)
    public BaseResponse publishRecruitment(HttpServletRequest request, Recruitment recruitment) {
        return employService.publishRecruitment(request, recruitment);
    }

    @ResponseBody
    @RequestMapping(value = "/all_apps", method = RequestMethod.POST)
    public BaseResponse queryAllApplicatioons(HttpServletRequest request) {
        return employService.queryAllApplications(request);
    }

    @ResponseBody
    @RequestMapping(value = "/all_job_types")
    public BaseResponse queryAllJobTypes() {
        this.logging("Query all job types.");
        return employService.queryAllJobTypes();
    }

    @ResponseBody
    @RequestMapping(value = "/all_recruits")
    public BaseResponse queryAllRecruitments(HttpServletRequest request) {
        return employService.queryAllRecuitments(request);
    }

    @ResponseBody
    @RequestMapping(value = "/update_recruit", method = RequestMethod.POST)
    public BaseResponse updateRecruitment(HttpServletRequest request, Recruitment recruitment) {
        return employService.updateRecruitment(request, recruitment);
    }

}
