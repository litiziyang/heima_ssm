package com.itheima.ssm.service.impl;

import com.itheima.ssm.dao.IRole;
import com.itheima.ssm.domain.Role;
import com.itheima.ssm.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class IRoleServiceImpl implements IRoleService {
    @Autowired
    private IRole iRole;
    @Override
    public List<Role> findAll() {
      List<Role> list=  iRole.findAll();

        return list;
    }

    @Override
    @Transactional
    public void save(Role role) {
        iRole.save(role);
    }
}
