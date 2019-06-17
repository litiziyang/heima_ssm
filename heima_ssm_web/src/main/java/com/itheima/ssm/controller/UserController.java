package com.itheima.ssm.controller;


import com.github.pagehelper.PageInfo;
import com.itheima.ssm.domain.UserInfo;
import com.itheima.ssm.service.IUserSevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("user")
public class UserController {
    @Autowired
    private IUserSevice iUserSevice;
@RequestMapping("findAll.do")
    public String findAll(@RequestParam(value = "page",defaultValue = "1",required = true)int page,@RequestParam(value = "size",defaultValue = "4",required = true)int size, Model model){
     List<UserInfo> list=iUserSevice.findAll(page,size);
    PageInfo pageInfo = new PageInfo(list);
    model.addAttribute("userlist",pageInfo);
    return "user-list";
    }


    @RequestMapping("save.do")
    public String save(UserInfo userInfo){
    iUserSevice.save(userInfo);
    return "redirect:findAll.do";
    }
}
