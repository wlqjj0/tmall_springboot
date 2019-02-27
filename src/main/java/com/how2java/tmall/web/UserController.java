package com.how2java.tmall.web;

import com.how2java.tmall.pojo.User;
import com.how2java.tmall.service.UserService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Log4j2
@RestController
public class UserController {

    @Autowired//自动装配 CategoryService
    UserService userService;

    @GetMapping("/users")//对于categories 访问，会获取所有的 Category对象集合，并返回这个集合。
     //因为是声明为 @RestController， 所以这个集合，又会被自动转换为 JSON数组抛给浏览器。
    public List<User> list() throws Exception {
        return userService.list();
    }
    @PostMapping("/users")
    public Object add(@RequestBody User bean) throws Exception{
        userService.add(bean);
        return bean;
    }
    @DeleteMapping("/users/{id}")
    public String delete(@PathVariable("id") int id,HttpServletRequest request) throws Exception {
        userService.delete(id);
        return null;
    }
    @PutMapping("/users")
    public User update(@RequestBody User bean,String[] permissionIds) throws Exception {
        userService.edit(bean);
        //role_permissionService.setPermission(bean,permissionIds);
        log.info("PutMapping==="+bean);
        return bean;
    }
    @GetMapping("/users/{id}")
    public User get(@PathVariable("id") int id) throws Exception {
        User bean=userService.get(id);
        log.debug("Debugging log"+bean);
        return bean;
    }
}
