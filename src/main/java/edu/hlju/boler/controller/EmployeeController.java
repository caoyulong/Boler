package edu.hlju.boler.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import edu.hlju.boler.pojo.po.PersonInfomation;
import edu.hlju.boler.pojo.vo.BaseResponse;
import edu.hlju.boler.service.interfaces.IEmployeeService;
import edu.hlju.boler.util.DateTimeUtil;

/**
 * 雇员角色控制层
 * @author jingqingyun
 */
@Controller
@RequestMapping(value = "api/employee")
public class EmployeeController {
    private Logger logger = LoggerFactory.getLogger(EmployeeController.class);

    @Resource
    private IEmployeeService employeeService;

    @ResponseBody
    @RequestMapping(value = "/save_person_info", method = RequestMethod.POST)
    public BaseResponse savePersonInfo(HttpServletRequest request, PersonInfomation info) {
        logger.info(UserController.USER_LOG_FORMAT, DateTimeUtil.now() + "save personnal information.");
        return employeeService.savePersonInfo(request, info);
    }
}
