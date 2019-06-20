package com.itheima.ssm.controller;


import com.itheima.ssm.domain.Role;
import com.itheima.ssm.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("role")
public class RoleController {
    @Autowired
    private IRoleService iRoleService;
    @RequestMapping("findAll.do")
    public String findAll(Model model){
      List<Role> list = iRoleService.findAll();
      model.addAttribute("roleList",list);
     return "role-list";
    }

    @RequestMapping("save.do")
    public String save(Role role){
        iRoleService.save(role);
        return "redirect:findAll.do";
    }
}
