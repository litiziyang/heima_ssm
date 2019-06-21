package com.itheima.ssm.service;

import com.itheima.ssm.domain.UserInfo;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface IUserSevice extends UserDetailsService {


    List<UserInfo> findAll(int page,int size);

    void save(UserInfo userInfo);

    UserInfo findById(String id);

    void saveUserAndRole(String id, String[] ids);
}
