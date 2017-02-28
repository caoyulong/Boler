package edu.hlju.boler.service.interfaces.user;

import javax.servlet.http.HttpServletRequest;

import edu.hlju.boler.pojo.po.Role;
import edu.hlju.boler.pojo.po.User;
import edu.hlju.boler.pojo.vo.BaseResponse;

public interface IUserService {

    BaseResponse login(HttpServletRequest reqeuest, User user);

    BaseResponse register(User user, Role role);

}
