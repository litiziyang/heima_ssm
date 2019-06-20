package com.itheima.ssm.service;

import com.itheima.ssm.domain.Permission;

import java.util.List;

public interface IPermission {

    List<Permission> findAll();

    void save(Permission permission);
}
