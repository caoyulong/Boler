package edu.hlju.boler.service.interfaces;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import edu.hlju.boler.pojo.po.Role;
import edu.hlju.boler.pojo.po.User;
import edu.hlju.boler.pojo.vo.BaseResponse;

public interface IUserService {

    HttpSession getSession();

    BaseResponse login(HttpServletRequest reqeuest, User user);

    BaseResponse register(User user, Role role);

}
