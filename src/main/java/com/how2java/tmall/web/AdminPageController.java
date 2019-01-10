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
}