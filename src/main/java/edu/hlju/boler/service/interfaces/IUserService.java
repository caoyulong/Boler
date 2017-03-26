package edu.hlju.boler.service.interfaces;

import java.util.List;

import edu.hlju.boler.pojo.po.Role;
import edu.hlju.boler.pojo.po.User;

public interface IUserService {

    boolean hasRegisterd(String id);

    User login(User user);

    boolean modifyPassword(User logined, String oldPasswd, String newPasswd);

    List<Role> queryAllRoles();

    boolean register(User user);

}
