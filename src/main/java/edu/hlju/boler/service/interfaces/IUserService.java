package edu.hlju.boler.service.interfaces;

import javax.servlet.http.HttpServletRequest;

import edu.hlju.boler.pojo.po.Role;
import edu.hlju.boler.pojo.po.User;
import edu.hlju.boler.pojo.vo.StateResponse;

public interface IUserService {

    StateResponse login(HttpServletRequest reqeuest, User user);

    StateResponse logout(HttpServletRequest request);

    StateResponse modifyPassword(HttpServletRequest request, User user);

    StateResponse register(User user, Role role);

}
