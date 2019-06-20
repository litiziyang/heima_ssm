package com.itheima.ssm.service.impl;

import com.github.pagehelper.PageHelper;
import com.itheima.ssm.dao.IUserDao;
import com.itheima.ssm.domain.Role;
import com.itheima.ssm.domain.UserInfo;
import com.itheima.ssm.service.IUserSevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;


@Service("userService")
@Transactional
public class IUserServiceImpl implements IUserSevice {
    @Autowired
    private IUserDao iUserDao;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserInfo userinfo = iUserDao.findByUsername(username);
        User user = new User(userinfo.getUsername(),userinfo.getPassword(),userinfo.getStatus()==0?false:true,true,true,true,getauthorities(userinfo.getRoles()));
        return user;
    }

    public List<SimpleGrantedAuthority> getauthorities(List<Role> roles){
        List<SimpleGrantedAuthority> list =new ArrayList<>();
        for (Role roless: roles) {
            list.add(new SimpleGrantedAuthority("ROLE_"+roless.getRoleName()));
        }
        return list;
    }


    @Override
    @Transactional
    public List<UserInfo> findAll(int page,int size) {
        PageHelper.startPage(page,size);
        List<UserInfo> list= iUserDao.findAll();
        return list;
    }

    @Override
    @Transactional
    public void save(UserInfo userInfo) {
        String encode = bCryptPasswordEncoder.encode(userInfo.getPassword());
        userInfo.setPassword(encode);
        iUserDao.save(userInfo);
    }

    @Override
    public UserInfo findById(String id) {
       UserInfo userInfo= iUserDao.findById(id);

        return  userInfo;
    }
}
