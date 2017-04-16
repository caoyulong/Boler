package edu.hlju.boler.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.hlju.boler.datadictory.PageURL;

@Controller
@RequestMapping(value = "/page")
public class PageController {

    @RequestMapping(value = "/all_apps")
    public String allApps() {
        return PageURL.EMPLOY_ALL_APPS.getURL();
    }

    @RequestMapping(value = "/all_recruits")
    public String allRecruits() {
        return PageURL.EMPLOY_ALL_RECRUITMENTS.getURL();
    }

    @RequestMapping(value = "/recruit")
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

}
