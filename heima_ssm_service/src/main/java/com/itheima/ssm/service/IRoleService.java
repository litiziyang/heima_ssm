package com.itheima.ssm.service;


import com.itheima.ssm.domain.Role;

import java.util.List;

public interface IRoleService {

    List<Role> findAll();

    void save(Role role);
    List<Role> findById(String id);

    Role findBynotId(String id);

    void addRoleTopermission(String id, String[] pid);
}
