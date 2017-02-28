package edu.hlju.boler.service.interfaces;

import java.util.List;

import edu.hlju.boler.pojo.po.Role;

public interface IRoleService {

    List<Role> selectAll();

    Role selectById(int id);

}
