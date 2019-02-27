package com.how2java.tmall.web;

import com.how2java.tmall.pojo.Role;
import com.how2java.tmall.pojo.Role_permission;
import com.how2java.tmall.service.RoleService;
import com.how2java.tmall.service.Role_permissionService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Log4j2
@RestController
public class Role_permissionController {

    @Autowired//自动装配 CategoryService
    Role_permissionService role_permissionService;
    String checkes[];

    @GetMapping("/role_permissions")//对于categories 访问，会获取所有的 Category对象集合，并返回这个集合。
     //因为是声明为 @RestController， 所以这个集合，又会被自动转换为 JSON数组抛给浏览器。
    public List<Role_permission> list() throws Exception {
        return role_permissionService.list();
    }
    @PostMapping("/role_permissions")
    public Object add(Role_permission bean,String id, String checks[]) throws Exception{
        role_permissionService.setPermission(id,checks);
        //role_permissionService.add(bean);
        log.info("PostMapping==="+id+"/rid=="+checks+"/bean=="+bean);
        return id;
    }
    @DeleteMapping("/role_permissions/{id}")
    public String delete(@PathVariable("id") int id,HttpServletRequest request) throws Exception {
        role_permissionService.delete(id);
        return null;
    }
    @PutMapping("/role_permissions")
    public Role update(@RequestBody Role bean) throws Exception {
        //role_permissionService.setPermission(bean,checkedes);
        log.info("PutMapping==="+bean);
        return bean;
    }
    @GetMapping("/role_permissions/{id}")
    public Role_permission get(@PathVariable("id") int id) throws Exception {
        Role_permission bean=role_permissionService.get(id);
        log.info("Debugging log"+bean);
        return bean;
    }
}
