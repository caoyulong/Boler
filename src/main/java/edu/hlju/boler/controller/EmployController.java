package edu.hlju.boler.controller;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.hlju.boler.service.interfaces.IEmployService;

/**
 * 雇主角色控制层
 * @author jingqingyun
 */
@Controller
@RequestMapping(value = "api/employ")
public class EmployController {
    private static final Logger logger = LoggerFactory.getLogger(EmployController.class);
    @Resource
    private IEmployService employService;

}
