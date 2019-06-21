package com.itheima.ssm.dao;

import com.itheima.ssm.domain.Permission;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface Ipermission {
    @Select("select * from permission where id in(select permissionId from role_permission where roleId=#{id})")
    List<Permission> findById(String id);

@Select("select * from permission")
    List<Permission> findAll();
@Insert("insert into permission(permissionName,url)values('${permissionName}','${url}')")
    void save(Permission permission);
@Select("select * from Permission where id not in (select permissionId from role_Permission where roleId=#{id} )")
    List<Permission> findByIdOut(String id);
}
