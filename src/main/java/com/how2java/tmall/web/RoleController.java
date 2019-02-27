package com.how2java.tmall.web;

import com.how2java.tmall.pojo.Role;
import com.how2java.tmall.service.RoleService;
import com.how2java.tmall.service.Role_permissionService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Log4j2
@RestController
public class RoleController {

    @Autowired//自动装配 CategoryService
    RoleService roleService;
    @Autowired
    Role_permissionService role_permissionService;

    @GetMapping("/roles")//对于categories 访问，会获取所有的 Category对象集合，并返回这个集合。
     //因为是声明为 @RestController， 所以这个集合，又会被自动转换为 JSON数组抛给浏览器。
    public List<Role> list() throws Exception {
        return roleService.list();
    }
    @PostMapping("/roles")
    public Object add(@RequestBody Role bean) throws Exception{
        roleService.add(bean);
        return bean;
    }
    @DeleteMapping("/roles/{id}")
    public String delete(@PathVariable("id") int id,HttpServletRequest request) throws Exception {
        roleService.delete(id);
        return null;
    }
    @PutMapping("/roles")
    public Role update(@RequestBody Role bean,String[] permissionIds) throws Exception {
        roleService.edit(bean);
        //role_permissionService.setPermission(bean,permissionIds);
        log.info("PutMapping==="+bean);
        return bean;
    }
    @GetMapping("/roles/{id}")
    public Role get(@PathVariable("id") int id) throws Exception {
        Role bean=roleService.get(id);
        log.debug("Debugging log"+bean);
        return bean;
    }
}
