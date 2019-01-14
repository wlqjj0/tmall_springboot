package com.how2java.tmall.service;

import com.how2java.tmall.dao.CategoryDAO;
import com.how2java.tmall.dao.PropertyDAO;
import com.how2java.tmall.pojo.Category;
import com.how2java.tmall.pojo.Property;
import com.how2java.tmall.util.Page4Navigator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service //标记这个类是 Service类
public class PropertyService {
    @Autowired //自动装配 上个步骤的 CategoryDAO 对象
    PropertyDAO propertyDAO;
    @Autowired CategoryService categoryService;

    public Page4Navigator<Property> listProperty(int cid,int start, int size) throws Exception {
        Category category=categoryService.get(cid);

        Sort sort = new Sort(Sort.Direction.ASC, "id");
        Pageable pageable = new PageRequest(start, size, sort);

        Page<Property> page =propertyDAO.findByCategory(category,pageable);
        return new Page4Navigator<>(page);
    }
    public void add(Property bean) {
        propertyDAO.save(bean);
        System.out.println("Property--已经成功增加--"+bean.getName());
    }
    public void delete(int id) {
        propertyDAO.delete(id);
        System.out.println("Property--已经成功删除--"+id);
    }
    public void edit(Property bean) {
        propertyDAO.save(bean);
    }
    public Property get(int id) {
        //categoryDAO.getOne(id);
        Property c=propertyDAO.findOne(id);
        return c;
    }

}