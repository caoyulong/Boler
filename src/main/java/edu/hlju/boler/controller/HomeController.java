package edu.hlju.boler.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

    private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

    /**
     * Simply selects the home view to render by returning its name.
     */
    @RequestMapping(value = { "/", "/home" }, method = RequestMethod.GET)
    public String home(HttpServletRequest request) {
        logger.info("Welcome home!");
        Object obj = request.getAttribute(UserController.USER_OBJECT);
        if (obj != null) {
            return "redirect:/api/user/index";
        } else {
            return "home";
        }
    }

}
