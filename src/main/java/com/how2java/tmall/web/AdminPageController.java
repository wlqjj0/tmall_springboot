package com.how2java.tmall.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller//表示这是一个控制器。
public class AdminPageController {
    @GetMapping(value="/admin")//访问地址 admin,就会客户端跳转到 admin_category_list去。
    public String admin(){
        return "redirect:admin_category_list";
    }
    @GetMapping(value="/admin_category_list")//访问地址 admin_category_list 就会访问 admin/listCategory.html 文件。
    public String listCategory(){
        return "admin/listCategory";
    }
    @GetMapping(value="/admin_category_edit")//访问地址 admin_category_edit 就会访问 admin/editCategory.html 文件。
    public String editCategory(){
        return "admin/editCategory";
    }
    @GetMapping(value="/admin_property_list")//访问地址 admin_property_list 就会访问 admin/listProperty.html 文件。
    public String listProperty(){
        return "admin/listProperty";
    }
    @GetMapping(value="/admin_property_edit")//访问地址 admin_property_list 就会访问 admin/listProperty.html 文件。
    public String editProperty(){
        return "admin/editProperty";
    }
    @GetMapping(value="/admin_user_list")//访问地址 admin_property_list 就会访问 admin/listProperty.html 文件。
    public String listUser(){
        return "admin/listUser";
    }
    @GetMapping(value="/login")
    public String login(){
        return "fore/login";
    }
    @GetMapping(value="/register")
    public String register(){
        return "fore/register";
    }
    @GetMapping(value="/registerSuccess")
    public String registerSuccess(){
        return "fore/registerSuccess";
    }
}