package com.how2java.tmall.web;

import com.how2java.tmall.service.Dbo_baserService;
import com.how2java.tmall.sqlpojo.Dbo_baser;
import com.how2java.tmall.util.Page4Navigator;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Log4j2
@RestController
public class Dbo_baserController {

    @Autowired//自动装配 CategoryService
    Dbo_baserService dboBaserService;

    @GetMapping("/dboBasers")//对于categories 访问，会获取所有的 Category对象集合，并返回这个集合。
     //因为是声明为 @RestController， 所以这个集合，又会被自动转换为 JSON数组抛给浏览器。
//    public List<Dbo_baser> list() throws Exception {
//        return dboBaserService.list();
//    }
    public Page4Navigator<Dbo_baser> listDbobaser(@RequestParam(value = "start", defaultValue = "1") int start,
                                                 @RequestParam(value = "size", defaultValue = "10") int size) throws Exception {
        start = start<0?0:start;
        Page4Navigator<Dbo_baser> page=dboBaserService.listDbobaser(start,size);
        log.error("hhh哈哈哈Hi ! We have an Error. Hello World");
        log.debug("Debugging log");
        log.info("Info log");
        log.warn("Hey, This is a warning!");
        log.fatal("Damn! Fatal error. Please fix me.");
        return page;
    }
//    @PostMapping("/users")
//    public Object add(@RequestBody User bean) throws Exception{
//        userService.add(bean);
//        return bean;
//    }
//    @DeleteMapping("/users/{id}")
//    public String delete(@PathVariable("id") int id,HttpServletRequest request) throws Exception {
//        userService.delete(id);
//        return null;
//    }
//    @PutMapping("/users")
//    public User update(@RequestBody User bean,String[] permissionIds) throws Exception {
//        userService.edit(bean);
//        //role_permissionService.setPermission(bean,permissionIds);
//        log.info("PutMapping==="+bean);
//        return bean;
//    }
//    @GetMapping("/users/{id}")
//    public User get(@PathVariable("id") int id) throws Exception {
//        User bean=userService.get(id);
//        log.debug("Debugging log"+bean);
//        return bean;
//    }
}
