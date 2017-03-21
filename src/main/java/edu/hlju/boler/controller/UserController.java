package edu.hlju.boler.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import edu.hlju.boler.pojo.po.Role;
import edu.hlju.boler.pojo.po.User;
import edu.hlju.boler.pojo.vo.BaseResponse;
import edu.hlju.boler.service.interfaces.IUserService;
import edu.hlju.boler.util.DateTimeUtil;

@Controller
@RequestMapping(value = "api/user")
public class UserController implements IControllerLog {
    private static final String LOG_FORMAT = "[{}] {}";
    private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

    @Resource(name = "userService")
    private IUserService userService;

    @ResponseBody
    @RequestMapping(value = "/all_roles")
    public BaseResponse getAllRoles() {
        this.logging("Querying all roles.");
        return userService.queryAllRoles();
    }

    @Override
    public void logging(String log) {
        logger.info(LOG_FORMAT, DateTimeUtil.now(), log);
    }

    @ResponseBody
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public BaseResponse login(HttpServletRequest request, @RequestParam User user, Role role) {
        this.logging("login.");
        return userService.login(request, user);
    }

    @ResponseBody
    @RequestMapping(value = "/logout")
    public BaseResponse logout(HttpServletRequest request) {
        this.logging("User logout.");
        return userService.logout(request);
    }

    @ResponseBody
    @RequestMapping(value = "/modify_password", method = RequestMethod.POST)
    public BaseResponse modifyPasswd(HttpServletRequest request, User user, String newPasswd) {
        this.logging("User modify password.");
        return userService.modifyPassword(request, user, newPasswd);
    }

    @ResponseBody
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public BaseResponse register(User user, Role role) {
        this.logging("Register.");
        return userService.register(user);
    }

}
