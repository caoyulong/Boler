package edu.hlju.boler.service;

import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import edu.hlju.boler.dao.IRoleDao;
import edu.hlju.boler.dao.IUserDao;
import edu.hlju.boler.pojo.po.Role;
import edu.hlju.boler.pojo.po.User;
import edu.hlju.boler.service.interfaces.IUserService;
import edu.hlju.boler.util.Encrytor;

@Service("userService")
public class UserService implements IUserService {
    public static final String USER_OBJECT = "user";
    public static final int MAX_ERROR_TIMES = 3;
    // private int errorTimes = 0;

    @Resource
    private IUserDao userDao;

    @Resource
    private IRoleDao roleDao;

    @Override
    public boolean hasRegisterd(String id) {
        if (id != null) {
            try {
                User result = userDao.selectByEmail(id);
                return result != null;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return true;
    }

    @Override
    public User login(User user) {
        if (user != null) {
            try {
                User selected = userDao.selectByEmail(user.getEmail());
                boolean isCorrect = selected != null
                        && selected.getPassword().equals(Encrytor.encrypt(user.getPassword()));
                if (isCorrect) {
                    return selected;
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    @Override
    public boolean modifyPassword(User logined, String oldPasswd, String newPasswd) {
        boolean isValid = logined != null && oldPasswd != null
                && logined.getPassword().equals(Encrytor.encrypt(oldPasswd));
        if (isValid) {
            logined.setPassword(Encrytor.encrypt(newPasswd));
            try {
                userDao.updateByIdSelective(logined);
                return true;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    @Override
    public List<Role> queryAllRoles() {
        try {
            return roleDao.selectAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean register(User user) {
        if (user != null) {
            try {
                user.setPassword(Encrytor.encrypt(user.getPassword()));
                userDao.insert(user);
                return true;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

}
