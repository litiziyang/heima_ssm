package com.itheima.ssm.service.impl;

import com.itheima.ssm.dao.Ipermission;
import com.itheima.ssm.domain.Permission;
import com.itheima.ssm.service.IPermission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class IPermissionService implements IPermission {

@Autowired
private Ipermission ipermission;
    @Override
    public List<Permission> findAll() {
        List<Permission> list = ipermission.findAll();
        return list;
    }

    @Override
    public void save(Permission permission) {
        ipermission.save(permission);
    }
}
