package edu.hlju.boler.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.hlju.boler.datadictory.PageURL;

@Controller
@RequestMapping(value = "/page")
public class PageController {

    @RequestMapping(value = "/add_email_temp")
    public String addEmailTemp() {
        return PageURL.EMPLOY_ADD_EMAIL_TEMPLATE.getURL();
    }

    @RequestMapping(value = "/all_apps")
    public String allApps() {
        return PageURL.EMPLOY_ALL_APPS.getURL();
    }

    @RequestMapping(value = "/all_email_temp")
    public String allEmailTemp() {
        return PageURL.ALL_EMAIL_TEMPLATE.getURL();
    }

    @RequestMapping(value = "/all_recruits")
    public String allRecruits() {
        return PageURL.EMPLOY_ALL_RECRUITMENTS.getURL();
    }

    @RequestMapping(value = "/employee_recruit")
    public String employeeRecruit() {
        return PageURL.EMPLOYEE_ALL_RECRUITMENTS.getURL();
    }

    @RequestMapping(value = "/employee_recruit_detail")
    public String employeeRecruitDetail() {
        return PageURL.EMPLOYEE_RECRUIT_DETAIL.getURL();
    }

    @RequestMapping(value = "/modify_passwd")
    public String modifyPassword() {
        return PageURL.USER_MODIFY_PASSWORD.getURL();
    }

    @RequestMapping(value = "/my_apps")
    public String myApplication() {
        return PageURL.EMPLOYEE_ALL_APPS.getURL();
    }

    @RequestMapping(value = "/add_recruit")
    public String recruit() {
        return PageURL.EMPLOY_RECRUIT.getURL();
    }

    @RequestMapping(value = "/recruit_detail")
    public String recruitDetail() {
        return PageURL.EMPLOY_RECRUIT_DETAIL.getURL();
    }

    @RequestMapping(value = "/register")
    public String register() {
        return PageURL.USER_REGISTER.getURL();
    }

    @RequestMapping(value = "/employ_resume")
    public String resume() {
        return PageURL.EMPLOY_RESUME.getURL();
    }

}
