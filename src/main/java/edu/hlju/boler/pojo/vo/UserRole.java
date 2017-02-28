package edu.hlju.boler.pojo.vo;

import edu.hlju.boler.pojo.po.Role;
import edu.hlju.boler.pojo.po.User;

public class UserRole {
    private User user;
    private Role role;

    public UserRole(User user, Role role) {
        super();
        this.user = user;
        this.role = role;
    }

    public Role getRole() {
        return role;
    }

    public User getUser() {
        return user;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public void setUser(User user) {
        this.user = user;
    }

}
