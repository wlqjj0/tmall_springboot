package com.how2java.tmall.service;

import com.how2java.tmall.dao.Role_permissionDAO;
import com.how2java.tmall.pojo.Role_permission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Role_permissionService {

    @Autowired
    Role_permissionDAO role_permissionDAO;

    public List<Role_permission> list() {
        Sort sort = new Sort(Sort.Direction.DESC, "id");//创建一个 Sort 对象，表示通过 id 倒排序， 然后通过 categoryDAO进行查询
        return role_permissionDAO.findAll(sort);
    }
    public void add(Role_permission bean) {
        role_permissionDAO.save(bean);
        System.out.println("userDAO--已经成功增加--"+bean.getId());
    }
    public void delete(int id) {
        role_permissionDAO.delete(id);
        System.out.println("userDAO--已经成功删除--"+id);
    }
    public void edit(Role_permission bean) {
        role_permissionDAO.save(bean);
    }
    public Role_permission get(int id) {
        //categoryDAO.getOne(id);
        Role_permission c=role_permissionDAO.findOne(id);
        return c;
    }
}
