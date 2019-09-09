package com.how2java.tmall.web;

import com.how2java.tmall.service.Dbo_baserService;
import com.how2java.tmall.sqlpojo.Dbo_baser;
import com.how2java.tmall.util.Page4Navigator;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Log4j2
@RestController
public class Dbo_searchrController {

    @Autowired//自动装配 CategoryService
    Dbo_baserService dboBaserService;

    //@GetMapping("/dboSearch")//对于categories 访问，会获取所有的 Category对象集合，并返回这个集合。
     //因为是声明为 @RestController， 所以这个集合，又会被自动转换为 JSON数组抛给浏览器。
//    public List<Dbo_baser> list() throws Exception {
//        return dboBaserService.list();
//    }
//    public Page4Navigator<Dbo_baser> listDbobaser(@RequestParam(value = "start", defaultValue = "1") int start,
//                                                 @RequestParam(value = "size", defaultValue = "10") int size) throws Exception {
//        start = start<0?0:start;
//        Page4Navigator<Dbo_baser> page=dboBaserService.listDbobaser(start,size);
//        log.info("page===="+page.getPageFromJPA());
//        return page;
//    }
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
//    @GetMapping("/findByNameLike")
//    public List<Dbo_baser> findLike(@PathVariable("scbm") String name) throws Exception {
//        //Dbo_baser bean=.;
//        log.debug("Debugging log"+name);
//        return dboBaserService.findlike(name);
//    }
    @GetMapping("/dboSearch")
    public List<Dbo_baser> get(@RequestParam(value = "like") String like) throws Exception {
        log.info("findByNameLikelog=="+like);
        //List<Dbo_baser> like1=dboBaserService.findlike("121415");
        //log.info("findByNameLike11111=="+like1);
        return dboBaserService.findlike(like);

    }
}
