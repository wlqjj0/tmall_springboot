package com.how2java.tmall.service;

import com.how2java.tmall.dao.CategoryDAO;
import com.how2java.tmall.pojo.Category;
import com.how2java.tmall.util.Page4Navigator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service //标记这个类是 Service类
public class CategoryService {
    @Autowired //自动装配 上个步骤的 CategoryDAO 对象
    CategoryDAO categoryDAO;
    //    public List<Category> list() {
//        Sort sort = new Sort(Sort.Direction.DESC, "id");//创建一个 Sort 对象，表示通过 id 倒排序， 然后通过 categoryDAO进行查询
//        return categoryDAO.findAll(sort);
//    }
    public Page4Navigator<Category> listCategory(int start, int size) throws Exception {
        Sort sort = new Sort(Sort.Direction.ASC, "id");
        Pageable pageable = new PageRequest(start, size, sort);
        Page page =categoryDAO.findAll(pageable);
        return new Page4Navigator<>(page);
    }
    public void add(Category bean) {
        categoryDAO.save(bean);
    }
    public void delete(int id) {
        categoryDAO.delete(id);
        System.out.println("已经成功删除--"+id);
    }
    public void edit(Category bean) {
        categoryDAO.save(bean);
    }
    public Category get(int id) {
        //categoryDAO.getOne(id);
        Category c=categoryDAO.findOne(id);
        return c;
    }

}