package com.itheima.ssm.dao;

import com.itheima.ssm.domain.Role;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface IRole {

    @Select("select * from role where id in(select roleId from users_role where roleId=#{userId})  ")
    List<Role> findById(String userId);
}
