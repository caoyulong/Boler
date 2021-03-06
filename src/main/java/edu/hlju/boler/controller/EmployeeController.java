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
import edu.hlju.boler.pojo.po.OnlineResume;
import edu.hlju.boler.pojo.po.PersonInfo;
import edu.hlju.boler.pojo.po.Recruitment;
import edu.hlju.boler.pojo.po.User;
import edu.hlju.boler.pojo.vo.BaseResponse;
import edu.hlju.boler.service.interfaces.IEmployeeService;
import edu.hlju.boler.util.DateTimeUtil;

/**
 * 雇员角色控制层
 *
 * @author jingqingyun
 */
@Controller
@RequestMapping(value = "api/employee")
public class EmployeeController extends BaseController {
    private static final Logger logger = LoggerFactory.getLogger(EmployeeController.class);

    @Resource
    private IEmployeeService employeeService;

    @ResponseBody
    @RequestMapping(value = "/del_resume")
    public BaseResponse delOnlineResume(HttpServletRequest request, int id) {
        Object obj = request.getSession().getAttribute(UserController.USER_OBJECT);
        if (obj != null && employeeService.delOnlineResume(id)) {
            this.userLogging(request, "Delete a online resume.");
            return this.getResponse(UserDataDict.OPERATIING_SUCCEED);
        }
        return this.getResponse(UserDataDict.NOT_LOGINED);
    }

    @Override
    public void logging(String log) {
        logger.info(UserController.LOG_FORMAT, DateTimeUtil.now(), log);
    }

    /**
     * 以分页方式查询所有求职申请
     *
     * @param request
     * @param pageNum 页数
     * @param pageSize 页大小，为0表示查询所有即不分页
     * @return BaseResponse
     */
    @ResponseBody
    @RequestMapping(value = "/all_apps")
    public BaseResponse queryAllApps(HttpServletRequest request, int pageNum, int pageSize) {
        Object obj = request.getSession().getAttribute(UserController.USER_OBJECT);
        if (obj != null) {
            User employee = (User) obj;
            List<Application> result = employeeService.queryAllApps(employee, pageNum, pageSize);
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
        return this.getResponse(employeeService.queryAllJobTypes());
    }

    @ResponseBody
    @RequestMapping(value = "/all_recruitments")
    public BaseResponse queryAllRecruitments(HttpServletRequest request, int pageNum, int pageSize) {
        Object obj = request.getSession().getAttribute(UserController.USER_OBJECT);
        if (obj != null) {
            List<Recruitment> result = employeeService.queryAllRecruitments(pageNum, pageSize);
            if (result != null) {
                this.userLogging(request, "Query all recruitments.");
                return this.getResponse(result);
            } else {
                return this.getResponse(UserDataDict.OPERATIING_FAILED);
            }
        }
        return this.getResponse(UserDataDict.NOT_LOGINED);
    }

    @RequestMapping(value = "/recruit_condition", method = RequestMethod.POST)
    public BaseResponse queryAllRecruitments(HttpServletRequest request, Recruitment recruit, int pageNum,
            int pageSize) {
        Object obj = request.getSession().getAttribute(UserController.USER_OBJECT);
        if (obj == null) {
            return this.getResponse(UserDataDict.NOT_LOGINED);
        }
        List<Recruitment> result = employeeService.queryAllRecruitments(recruit, pageNum, pageSize);
        if (result == null) {
            return this.getResponse(UserDataDict.OPERATIING_FAILED);
        }
        this.userLogging(request, "Query recruitments with condition.");
        return this.getResponse(result);
    }

    @ResponseBody
    @RequestMapping(value = "/person_info")
    public BaseResponse queryPersonInfo(HttpServletRequest request) {
        Object obj = request.getAttribute(UserController.USER_OBJECT);
        if (obj != null) {
            User employee = (User) obj;
            return this.getResponse(employee.getPersonInfo());
        }
        return this.getResponse(UserDataDict.NOT_LOGINED);
    }

    @ResponseBody
    @RequestMapping(value = "/all_resumes")
    public BaseResponse queryUserOnlineResumes(HttpServletRequest request) {
        Object obj = request.getSession().getAttribute(UserController.USER_OBJECT);
        if (obj != null) {
            User employee = (User) obj;
            List<OnlineResume> result = employeeService.queryUserOnlineResumes(employee);
            if (result != null) {
                this.userLogging(request, "Query user's online resumes.");
                return this.getResponse(result);
            } else {
                return this.getResponse(UserDataDict.OPERATIING_FAILED);
            }
        }
        return this.getResponse(UserDataDict.NOT_LOGINED);
    }

    @ResponseBody
    @RequestMapping(value = "/save_app", method = RequestMethod.POST)
    public BaseResponse saveApplication(HttpServletRequest request, Application application) {
        Object obj = request.getSession().getAttribute(UserController.USER_OBJECT);
        if (obj != null) {
            User employee = (User) obj;
            application.setEmployee(employee);
            application.setState((byte) ApplicationState.NEW.ordinal());
            if (employeeService.saveApplication(application)) {
                Recruitment recruit = employeeService.queryRecruitById(application.getRecruitment().getId());
                if (recruit != null) {
                    String to = recruit.getEmploy().getEmail();
                    String from = employee.getEmail();
                    String subject = EmailDataDict.NEW_APPLICATION.getSubject();
                    String text = EmailDataDict.NEW_APPLICATION.getText();
                    this.notifyByEmail(to, from, subject, text, employee);
                    this.userLogging(request, "Save an application.");
                    return this.getResponse(UserDataDict.OPERATIING_SUCCEED);
                }
            } else {
                return this.getResponse(UserDataDict.OPERATIING_FAILED);
            }
        }
        return this.getResponse(UserDataDict.NOT_LOGINED);
    }

    @ResponseBody
    @RequestMapping(value = "/save_resume", method = RequestMethod.POST)
    public BaseResponse saveOnlineResume(HttpServletRequest request, OnlineResume onlineResume) {
        Object obj = request.getSession().getAttribute(UserController.USER_OBJECT);
        if (obj != null) {
            User employee = (User) obj;
            onlineResume.setUser(employee);
            if (employeeService.saveOnlineResume(onlineResume)) {
                this.userLogging(request, "Save a online resume.");
                return this.getResponse(UserDataDict.OPERATIING_SUCCEED);
            } else {
                return this.getResponse(UserDataDict.OPERATIING_FAILED);
            }
        }
        return this.getResponse(UserDataDict.NOT_LOGINED);
    }

    @ResponseBody
    @RequestMapping(value = "/save_person_info", method = RequestMethod.POST)
    public BaseResponse savePersonInfo(HttpServletRequest request, PersonInfo info) {
        Object obj = request.getSession().getAttribute(UserController.USER_OBJECT);
        if (obj != null && employeeService.savePersonInfo(info) != -1) {
            User employee = (User) obj;
            User user = new User();
            user.setId(employee.getId());
            user.setPersonInfo(info);   // 只更新修改的内容
            if (employeeService.updateEmployee(user)) {
                this.logging("Save personal information.");
                return this.getResponse(UserDataDict.OPERATIING_SUCCEED);
            } else {
                return this.getResponse(UserDataDict.OPERATIING_FAILED);
            }
        }
        return this.getResponse(UserDataDict.OPERATIING_FAILED);
    }

    @ResponseBody
    @RequestMapping(value = "/update_resume", method = RequestMethod.POST)
    public BaseResponse updateOnlineResume(HttpServletRequest request, OnlineResume resume) {
        Object obj = request.getSession().getAttribute(UserController.USER_OBJECT);
        if (obj != null && employeeService.updateOnlineResume(resume)) {
            this.userLogging(request, "Update a online resume.");
            return this.getResponse(UserDataDict.LOGIN_SUCCEED);
        }
        return this.getResponse(UserDataDict.OPERATIING_FAILED);
    }

    @ResponseBody
    @RequestMapping(value = "/update_person_info", method = RequestMethod.POST)
    public BaseResponse updatePersonInfo(HttpServletRequest request, PersonInfo info) {
        Object obj = request.getSession().getAttribute(UserController.USER_OBJECT);
        if (obj != null && employeeService.updatePersonInfo(info)) {
            this.logging("Update user's personal information.");
            return this.getResponse(UserDataDict.OPERATIING_SUCCEED);
        }
        return this.getResponse(UserDataDict.OPERATIING_SUCCEED);
    }

    @Override
    protected void userLogging(HttpServletRequest request, String message) {
        this.logging(message);
        this.saveUserLog(request, message);
    }

}
