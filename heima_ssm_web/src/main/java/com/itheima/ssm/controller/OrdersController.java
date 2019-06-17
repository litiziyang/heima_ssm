package com.itheima.ssm.controller;

import com.github.pagehelper.PageInfo;
import com.itheima.ssm.domain.Orders;
import com.itheima.ssm.service.IOrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/orders")
public class OrdersController {
    @Autowired
    private IOrdersService iOrdersService;

//    @RequestMapping("findAll.do")
//    private ModelAndView findAll(){
//        List<Orders> list = iOrdersService.findAll();
//        ModelAndView m = new ModelAndView();
//        m.setViewName("orders-list");
//        m.addObject("ordersList",list);
//        return m;
//    }
    @RequestMapping("findAll.do")
    private ModelAndView findAll(@RequestParam(name = "page",defaultValue = "1",required = true) int page,@RequestParam(name="size",defaultValue = "4",required = true)int size){
        List<Orders> list = iOrdersService.findAll(page,size);
        PageInfo pageInfo = new PageInfo(list);
        ModelAndView m = new ModelAndView();
        m.addObject("pageinfo",pageInfo);
        m.setViewName("orders-page-list");
        return m;

    }
@RequestMapping("findById.do")
    private ModelAndView findById(@RequestParam( required = true,name = "id") String orderId){
        ModelAndView m = new ModelAndView();
        Orders list=iOrdersService.findById(orderId);
        m.setViewName("orders-show");
        m.addObject("orders",list);
        System.out.println("sss");
        return m;

    }
}
