package com.how2java.tmall.web;

import com.how2java.tmall.pojo.Role;
import com.how2java.tmall.pojo.User;
import com.how2java.tmall.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RoleController {

    @Autowired//自动装配 CategoryService
    RoleService roleService;

    @GetMapping("/roles")//对于categories 访问，会获取所有的 Category对象集合，并返回这个集合。
     //因为是声明为 @RestController， 所以这个集合，又会被自动转换为 JSON数组抛给浏览器。
    public List<Role> list() throws Exception {
        return roleService.list();
    }

}
