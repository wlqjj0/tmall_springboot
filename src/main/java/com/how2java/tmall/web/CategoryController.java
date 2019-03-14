package com.how2java.tmall.web;



import com.how2java.tmall.pojo.Category;
import com.how2java.tmall.service.CategoryService;
import com.how2java.tmall.util.ImageUtil;
import com.how2java.tmall.util.Page4Navigator;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.List;

@Log4j2
@RestController//表示这是一个控制器，并且对每个方法的返回值都会直接转换为 json 数据格式。
public class CategoryController {
    @Autowired//自动装配 CategoryService
    CategoryService categoryService;

    @GetMapping("/categories")//对于categories 访问，会获取所有的 Category对象集合，并返回这个集合。
                            // 因为是声明为 @RestController， 所以这个集合，又会被自动转换为 JSON数组抛给浏览器。
//    public List<Category> list() throws Exception {
//        return categoryService.list();
//    }
    public Page4Navigator<Category> listCategory(@RequestParam(value = "start", defaultValue = "1") int start,
                                                 @RequestParam(value = "size", defaultValue = "8") int size) throws Exception {
        start = start<0?0:start;
        Page4Navigator<Category> page=categoryService.listCategory(start,size);
        log.error("hhh哈哈哈Hi ! We have an Error. Hello World");
        log.debug("Debugging log");
        log.info("Info log");
        log.warn("Hey, This is a warning!");
        log.fatal("Damn! Fatal error. Please fix me.");
        return page;
    }

    @PostMapping("/categories")
    public Object add(Category bean, MultipartFile image, HttpServletRequest request) throws Exception{
        log.info("addcategoriesbean="+bean+"//request="+request);
        categoryService.add(bean);
        saveOrUpdateImageFile(bean,image,request);
        return bean;
    }
    @DeleteMapping("/categories/{id}")
    public String deleteCategory(@PathVariable("id") int id,HttpServletRequest request) throws Exception {
        categoryService.delete(id);
        File imageFolder=new File(request.getServletContext().getRealPath("img/category"));
        File file=new File(imageFolder,id+".jpg");
        file.delete();
        return null;
    }
    @PutMapping("/categories/{id}")
    public Category updateCategory(Category bean, MultipartFile image, HttpServletRequest request) throws Exception {
        String name=request.getParameter("name");//PUT不能直接传name值？？？
        bean.setName(name);
        categoryService.edit(bean);
        if(image!=null){
            saveOrUpdateImageFile(bean,image,request);
        }
        return bean;
    }
    @GetMapping("/categories/{id}")
    public Category get(@PathVariable("id") int id) throws Exception {
        Category bean=categoryService.get(id);
        return bean;
    }
    public void saveOrUpdateImageFile(Category bean, MultipartFile image, HttpServletRequest request) throws Exception{
        File imageFolder =new File(request.getServletContext().getRealPath("img/category"));
        File file = new File(imageFolder,bean.getId()+".jpg");
        if(!file.getParentFile().exists())
            file.getParentFile().mkdirs();
        image.transferTo(file);
        BufferedImage image1=ImageUtil.change2jpg(file);
        ImageIO.write(image1,"jpg",file);
    }
}
