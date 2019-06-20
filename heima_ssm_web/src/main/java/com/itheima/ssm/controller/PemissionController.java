package com.itheima.ssm.controller;





import com.itheima.ssm.domain.Permission;
import com.itheima.ssm.service.IPermission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("permission")
public class PemissionController {
    @Autowired
     private IPermission iPermission;
    @RequestMapping("findAll.do")
    public String findAll(Model model){
        List<Permission> list = iPermission.findAll();
        model.addAttribute("permission",list);
        return "permission-list";
    }

    @RequestMapping("save.do")
    public String save(Permission permission){
        iPermission.save(permission);
        return "redirect:findAll.do";
    }
}
