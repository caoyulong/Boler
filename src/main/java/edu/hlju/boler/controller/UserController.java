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

import edu.hlju.boler.datadictory.PageURL;
import edu.hlju.boler.datadictory.UserDataDict;
import edu.hlju.boler.pojo.po.Role;
import edu.hlju.boler.pojo.po.User;
import edu.hlju.boler.pojo.vo.BaseResponse;
import edu.hlju.boler.service.interfaces.IUserService;
import edu.hlju.boler.util.DateTimeUtil;

@Controller
@RequestMapping(value = "api/user")
public class UserController extends BaseController {
    public static final String LOG_FORMAT = "[{}] {}";
    public static final String USER_OBJECT = "userObject";
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Resource(name = "userService")
    private IUserService userService;

    @ResponseBody
    @RequestMapping(value = "/all_roles")
    public BaseResponse getAllRoles() {
        this.logging("Querying all roles.");
        List<Role> result = userService.queryAllRoles();
        if (result != null) {
            return this.getResponse(result);
        }
        return this.getResponse(UserDataDict.OPERATIING_FAILED);
    }

    @ResponseBody
    @RequestMapping("/has_registered")
    public BaseResponse hasrRegistered(String id) {
        return this.getResponse(userService.hasRegisterd(id));
    }

    @RequestMapping(value = "/index")
    public String index(HttpServletRequest request) {
        Object obj = request.getSession().getAttribute(USER_OBJECT);
        if (obj != null) {
            User user = (User) obj;
            return "redirect:/api/" + user.getRole().getName() + "/index";
        }
        return "redirect:/";
    }

    @Override
    public void logging(String log) {
        logger.info(LOG_FORMAT, DateTimeUtil.now(), log);
    }

    @ResponseBody
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public BaseResponse login(HttpServletRequest request, User user) {
        User login = userService.login(user);
        if (login != null) {
            request.getSession().setAttribute(USER_OBJECT, login);
            this.userLogging(request, "User login.");
            return this.getResponse(UserDataDict.LOGIN_SUCCEED);
        }
        return this.getResponse(UserDataDict.LOGIN_FAILED);
    }

    @ResponseBody
    @RequestMapping(value = "/logout")
    public BaseResponse logout(HttpServletRequest request) {
        request.getSession().removeAttribute(USER_OBJECT);
        this.userLogging(request, "User logout.");
        return this.getResponse(UserDataDict.LOGOUT_SUCCEED);
    }

    @ResponseBody
    @RequestMapping(value = "/modify_password", method = RequestMethod.POST)
    public BaseResponse modifyPasswd(HttpServletRequest request, String oldPasswd, String newPasswd) {
        Object obj = request.getSession().getAttribute(USER_OBJECT);
        if (obj != null) {
            User logined = (User) obj;
            if (userService.modifyPassword(logined, oldPasswd, newPasswd)) {
                this.logging("User modify password.");
                return this.getResponse(UserDataDict.MODIFY_PASSWD_SUCCEED);
            }
        }
        this.logout(request);  // 修改密码后自动注销登录
        return this.getResponse(UserDataDict.MODIFY_PASSWD_FAILED);
    }

    @RequestMapping(value = "/register")
    public String register() {
        return PageURL.USER_REGISTER.getURL();
    }

    @ResponseBody
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public BaseResponse register(User user) {
        logger.info(LOG_FORMAT, user, "Register.");
        if (userService.register(user)) {
            return this.getResponse(UserDataDict.REGISTER_SUCCEED);
        }
        return this.getResponse(UserDataDict.REGISTER_FAILED);
    }

    @Override
    protected void userLogging(HttpServletRequest request, String message) {
        this.logging(message);
        this.saveUserLog(request, message);
    }

}
