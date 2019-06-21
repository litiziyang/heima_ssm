package com.itheima.ssm.controller;

import com.itheima.ssm.domain.Product;
import com.itheima.ssm.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.security.RolesAllowed;
import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private IProductService iProductService;
@RequestMapping("/save.do")
    public String save(Product product){
            iProductService.save(product);
        return "redirect:findAll.do";
    }

@RequestMapping("/findAll.do")
@PreAuthorize("hasRole('ROLE_ADMIN')")
    public ModelAndView findAll(){
        List<Product> all = iProductService.findAll();
        ModelAndView modelAndView =new ModelAndView();
        modelAndView.addObject("productList",all);
        modelAndView.setViewName("product-list");
        return modelAndView;

    }


}

