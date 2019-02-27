package com.how2java.tmall.web;

import com.how2java.tmall.pojo.Permission;
import com.how2java.tmall.pojo.User;
import com.how2java.tmall.service.PermissionService;
import com.how2java.tmall.service.UserService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Log4j2
@RestController
public class PermissionController {

    @Autowired//自动装配 CategoryService
    PermissionService permissionService;

    @GetMapping("/permissions")//对于categories 访问，会获取所有的 Category对象集合，并返回这个集合。
     //因为是声明为 @RestController， 所以这个集合，又会被自动转换为 JSON数组抛给浏览器。
    public List<Permission> list() throws Exception {
        return permissionService.list();
    }
    @PostMapping("/permissions")
    public Object add(@RequestBody Permission bean) throws Exception{
        log.info("PostMapping===="+bean);
        permissionService.add(bean);
        return bean;
    }
    @DeleteMapping("/permissions/{id}")
    public String delete(@PathVariable("id") int id,HttpServletRequest request) throws Exception {
        permissionService.delete(id);
        return null;
    }
    @PutMapping("/permissions")
    public Permission update(@RequestBody Permission bean) throws Exception {
        permissionService.edit(bean);
        log.info("PostMapping===="+bean);
        return bean;
    }
    @GetMapping("/permissions/{id}")
    public Permission get(@PathVariable("id") int id) throws Exception {
        Permission bean=permissionService.get(id);
        log.debug("Debugging log"+bean);
        return bean;
    }
}
