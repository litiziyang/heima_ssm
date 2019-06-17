package com.itheima.ssm.dao;

import com.itheima.ssm.domain.Traveller;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ITraveller {

    @Select("select * from Traveller where id in(select travellerId from order_traveller where orderId=#{ordersId} )")
//    select * from traveller where id in (select travellerId from order_traveller where orderId=#{ordersId})
    List<Traveller> findById(String ordersid);
}
