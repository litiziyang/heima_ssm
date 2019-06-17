package com.itheima.ssm.service.impl;

import com.itheima.ssm.dao.IUserDao;
import com.itheima.ssm.domain.Role;
import com.itheima.ssm.domain.UserInfo;
import com.itheima.ssm.service.IUserSevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service("userService")
public class IUserServiceImpl implements IUserSevice {
    @Autowired
    private IUserDao iUserDao;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserInfo userinfo = iUserDao.findByUsername(username);
        User user = new User(userinfo.getUsername(),"{noop}"+userinfo.getPassword(),getauthorities(userinfo.getRoles()));
        return user;
    }

    public List<SimpleGrantedAuthority> getauthorities(List<Role> roles){
        List<SimpleGrantedAuthority> list =new ArrayList<>();
        for (Role roless: roles
             ) {
            list.add(new SimpleGrantedAuthority("ROLE_"+roless.getRoleName()));
        }
        return list;
    }
}
