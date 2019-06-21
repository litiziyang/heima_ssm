package com.itheima.ssm.controller;


import com.github.pagehelper.PageInfo;
import com.itheima.ssm.domain.Role;
import com.itheima.ssm.domain.UserInfo;
import com.itheima.ssm.service.IRoleService;
import com.itheima.ssm.service.IUserSevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.security.RolesAllowed;
import java.util.List;

@Controller
@RequestMapping("user")
public class UserController {
    @Autowired
    private IUserSevice iUserSevice;
    @Autowired
    private IRoleService iRoleService;
@RequestMapping("findAll.do")
@PreAuthorize("hasRole('ROLE_ADMIN')")
    public String findAll(@RequestParam(value = "page",defaultValue = "1",required = true)int page,@RequestParam(value = "size",defaultValue = "7",required = true)int size, Model model){
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

    @RequestMapping("findById.do")
    public String findById(@RequestParam(value = "id",required = true)String id,Model model){
       UserInfo userInfo=  iUserSevice.findById(id);
       model.addAttribute("user",userInfo);

    return "user-show";
    }

    @RequestMapping("findUserByIdAndAllRole.do")
    public String findUserByIdAndAllRole(@RequestParam( name = "id", required = true) String id,Model model){
        UserInfo byId = iUserSevice.findById(id);
        List<Role> list = iRoleService.findById(id);
        model.addAttribute("user",byId);
        model.addAttribute("roleList",list);
        return "user-role-add";
    }
    @RequestMapping("addRoleToUser.do")
    public String addRoleToUser(@RequestParam(name = "userId",required = true) String id,@RequestParam(value = "ids",required = true) String[] ids){
    iUserSevice.saveUserAndRole(id,ids);
    return "redirect:findAll.do";
    }
}
