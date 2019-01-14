package com.how2java.tmall.web;

import com.how2java.tmall.pojo.Category;
import com.how2java.tmall.pojo.Property;
import com.how2java.tmall.service.CategoryService;
import com.how2java.tmall.service.PropertyService;
import com.how2java.tmall.util.Page4Navigator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;

@RestController//表示这是一个控制器，并且对每个方法的返回值都会直接转换为 json 数据格式。
public class PropertyController {
    @Autowired//自动装配 CategoryService
    PropertyService propertyService;

    @GetMapping("/categories/{cid}/properties")//对于categories 访问，会获取所有的 Category对象集合，并返回这个集合。
    // 因为是声明为 @RestController， 所以这个集合，又会被自动转换为 JSON数组抛给浏览器。
    public Page4Navigator<Property> listCategory(@PathVariable("cid") int cid,@RequestParam(value = "start", defaultValue = "0") int start,
                                                 @RequestParam(value = "size", defaultValue = "8") int size) throws Exception {
        start = start<0?0:start;
        Page4Navigator<Property> page=propertyService.listProperty(cid,start,size);
        return page;
    }

    @PostMapping("/properties")
    public Object add(@RequestBody Property bean) throws Exception{
        propertyService.add(bean);
        return bean;
    }
    @DeleteMapping("/properties/{id}")
    public String delete(@PathVariable("id") int id,HttpServletRequest request) throws Exception {
        propertyService.delete(id);
        return null;
    }
    @PutMapping("/properties")
    public Property update(@RequestBody Property bean) throws Exception {
        propertyService.edit(bean);
        return bean;
    }
    @GetMapping("/properties/{id}")
    public Property get(@PathVariable("id") int id) throws Exception {
        Property bean=propertyService.get(id);
        return bean;
    }

}

