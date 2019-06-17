package com.itheima.ssm.dao;

import com.itheima.ssm.domain.Member;
import org.apache.ibatis.annotations.Select;

public interface IMemberDao {


    @Select("select * from Member where id =#{id}")
    Member findById(String memberId);
}
