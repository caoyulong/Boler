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
import edu.hlju.boler.pojo.po.OnlineResume;
import edu.hlju.boler.pojo.po.PersonInfo;
import edu.hlju.boler.pojo.vo.BaseResponse;
import edu.hlju.boler.service.interfaces.IEmployeeService;
import edu.hlju.boler.util.DateTimeUtil;

/**
 * 雇员角色控制层
 * @author jingqingyun
 */
@Controller
@RequestMapping(value = "api/employee")
public class EmployeeController implements IControllerLog {
    private static final String LOG_FORMAT = "[{}] {}";
    private static final Logger logger = LoggerFactory.getLogger(EmployeeController.class);

    @Resource
    private IEmployeeService employeeService;

    @ResponseBody
    @RequestMapping(value = "/del_resume")
    public BaseResponse delOnlineResume(HttpServletRequest request, int id) {
        this.logging("Delete a online resume.");
        return employeeService.delOnlineResume(request, id);
    }

    @Override
    public void logging(String log) {
        logger.info(LOG_FORMAT, DateTimeUtil.now(), log);
    }

    /**
     * 以分页方式查询所有求职申请
     * @param request
     * @param pageNum 页数
     * @param pageSize 页大小，为0表示查询所有即不分页
     * @return BaseResponse
     */
    @ResponseBody
    @RequestMapping(value = "/all_apps")
    public BaseResponse queryAllApps(HttpServletRequest request, int pageNum, int pageSize) {
        this.logging("Query all applications.");
        return employeeService.queryAllApps(request, pageNum, pageSize);
    }

    @ResponseBody
    @RequestMapping(value = "/all_recruitments")
    public BaseResponse queryAllRecruitments(HttpServletRequest request, int pageNum, int pageSize) {
        this.logging("Query all recruitments.");
        return employeeService.queryAllRecruitments(request, pageNum, pageSize);
    }

    @ResponseBody
    @RequestMapping(value = "/person_info")
    public BaseResponse queryPersonInfo(HttpServletRequest request) {
        this.logging("Query user's personal information.");
        return employeeService.queryPersonInfo(request);
    }

    @ResponseBody
    @RequestMapping(value = "/all_resumes")
    public BaseResponse queryUserOnlineResumes(HttpServletRequest request) {
        this.logging("Query user's online resumes.");
        return employeeService.queryUserOnlineResumes(request);
    }

    @ResponseBody
    @RequestMapping(value = "/save_app", method = RequestMethod.POST)
    public BaseResponse saveApplication(HttpServletRequest request, Application application) {
        this.logging("Save an application.");
        return employeeService.addApplication(request, application);
    }

    @ResponseBody
    @RequestMapping(value = "/save_resume", method = RequestMethod.POST)
    public BaseResponse saveOnlineResume(HttpServletRequest request, OnlineResume onlineResume) {
        this.logging("Save a online resume.");
        return employeeService.saveOnlineResume(request, onlineResume);
    }

    @ResponseBody
    @RequestMapping(value = "/save_person_info", method = RequestMethod.POST)
    public BaseResponse savePersonInfo(HttpServletRequest request, PersonInfo info) {
        this.logging("Save personnal information.");
        return employeeService.savePersonInfo(request, info);
    }

    @ResponseBody
    @RequestMapping(value = "/update_resume", method = RequestMethod.POST)
    public BaseResponse updateOnlineResume(HttpServletRequest request, OnlineResume resume) {
        this.logging("Update a online resume.");
        return employeeService.updateOnlineResume(request, resume);
    }

    @ResponseBody
    @RequestMapping(value = "/update_person_info", method = RequestMethod.POST)
    public BaseResponse updatePersonInfo(HttpServletRequest request, PersonInfo info) {
        this.logging("Update user's personal information.");
        return employeeService.updatePersonInfo(request, info);
    }

}
