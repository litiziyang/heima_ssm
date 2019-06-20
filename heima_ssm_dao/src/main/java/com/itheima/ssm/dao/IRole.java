package com.itheima.ssm.dao;

import com.itheima.ssm.domain.Role;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface IRole {

    @Select("select * from role where id in(select roleId from users_role where userId=#{userId})  ")
    @Results({
            @Result( id = true, property = "id",column = "id" ),
            @Result(  property = "roleName",column = "roleName" ),
            @Result(  property = "roleDesc",column = "roleDesc" ),
            @Result(  property = "permissions",column = "id",javaType = List.class,many = @Many(select = "com.itheima.ssm.dao.Ipermission.findById")),
    })
    List<Role> findById(String userId);

@Select("select * from Role")
    List<Role> findAll();

@Insert("insert into role(roleName,roleDesc) values('${roleName}','${roleDesc}')")
    void save(Role role);
}
