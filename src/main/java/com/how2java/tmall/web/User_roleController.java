package com.how2java.tmall.web;

import com.how2java.tmall.pojo.Role;
import com.how2java.tmall.pojo.Role_permission;
import com.how2java.tmall.pojo.User_role;
import com.how2java.tmall.service.Role_permissionService;
import com.how2java.tmall.service.User_roleService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Log4j2
@RestController
public class User_roleController {

    @Autowired//自动装配 CategoryService
    User_roleService user_roleService;
    String checkes[];

    @GetMapping("/user_roles")//对于categories 访问，会获取所有的 Category对象集合，并返回这个集合。
     //因为是声明为 @RestController， 所以这个集合，又会被自动转换为 JSON数组抛给浏览器。
    public List<User_role> list() throws Exception {
        return user_roleService.list();
    }
    @PostMapping("/user_roles")
    public Object add(User_role bean, String id, String checks[]) throws Exception{
        user_roleService.setRole(id,checks);
        //role_permissionService.add(bean);
        log.info("PostMapping==="+id+"/rid=="+checks+"/bean=="+bean);
        return id;
    }
    @DeleteMapping("/user_roles/{id}")
    public String delete(@PathVariable("id") int id,HttpServletRequest request) throws Exception {
        user_roleService.delete(id);
        return null;
    }
    @PutMapping("/user_roles")
    public Role update(@RequestBody Role bean) throws Exception {
        //role_permissionService.setPermission(bean,checkedes);
        log.info("PutMapping==="+bean);
        return bean;
    }
    @GetMapping("/user_roles/{id}")
    public User_role get(@PathVariable("id") int id) throws Exception {
        User_role bean=user_roleService.get(id);
        log.info("Debugging log"+bean);
        return bean;
    }
}
