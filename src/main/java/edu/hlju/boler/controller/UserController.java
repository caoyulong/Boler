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
public class UserController {
    @Resource(name = "userService")
    private IUserService userService;
    private static Logger logger = LoggerFactory.getLogger(HomeController.class);

    public static final String USER_LOG_FORMAT = "[%s] %s";

    @ResponseBody
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public BaseResponse login(HttpServletRequest request, @RequestParam User user, Role role) {
        logger.info(USER_LOG_FORMAT, DateTimeUtil.now(), user.getId() + " login.");
        return userService.login(request, user);
    }

    @ResponseBody
    @RequestMapping(value = "/logout")
    public BaseResponse logout(HttpServletRequest request) {
        logger.info(DateTimeUtil.now() + "User logout.");
        return userService.logout(request);
    }

    @ResponseBody
    @RequestMapping(value = "/modify_password", method = RequestMethod.POST)
    public BaseResponse modifyPasswd(HttpServletRequest request, User user, String newPasswd) {
        logger.info(USER_LOG_FORMAT, DateTimeUtil.now() + "User modify password.");
        return userService.modifyPassword(request, user, newPasswd);
    }

    @ResponseBody
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public BaseResponse register(@RequestParam User user, @RequestParam Role role) {
        logger.info(USER_LOG_FORMAT, DateTimeUtil.now(), user.getId() + " register.");
        return userService.register(user);
    }

}
