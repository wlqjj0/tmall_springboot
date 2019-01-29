package com.how2java.tmall.service;

import com.how2java.tmall.dao.RoleDAO;
import com.how2java.tmall.pojo.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService {

    @Autowired
    RoleDAO roleDAO;

    public List<Role> list() {
        Sort sort = new Sort(Sort.Direction.DESC, "id");//创建一个 Sort 对象，表示通过 id 倒排序， 然后通过 categoryDAO进行查询
        return roleDAO.findAll(sort);
    }
    public void add(Role bean) {
        roleDAO.save(bean);
        System.out.println("userDAO--已经成功增加--"+bean.getName());
    }
    public void delete(int id) {
        roleDAO.delete(id);
        System.out.println("userDAO--已经成功删除--"+id);
    }
    public void edit(Role bean) {
        roleDAO.save(bean);
    }
    public Role get(int id) {
        //categoryDAO.getOne(id);
        Role c=roleDAO.findOne(id);
        return c;
    }
}
