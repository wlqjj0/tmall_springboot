package com.how2java.tmall.service;

import com.how2java.tmall.dao.PermissionDAO;
import com.how2java.tmall.pojo.Permission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PermissionService {

    @Autowired
    PermissionDAO permissionDAO;

    public List<Permission> list() {
        Sort sort = new Sort(Sort.Direction.DESC, "id");//创建一个 Sort 对象，表示通过 id 倒排序， 然后通过 categoryDAO进行查询
        return permissionDAO.findAll(sort);
    }
    public void add(Permission bean) {
        permissionDAO.save(bean);
        System.out.println("userDAO--已经成功增加--"+bean.getName());
    }
    public void delete(int id) {
        permissionDAO.delete(id);
        System.out.println("userDAO--已经成功删除--"+id);
    }
    public void edit(Permission bean) {
        permissionDAO.save(bean);
    }
    public Permission get(int id) {
        //categoryDAO.getOne(id);
        Permission c=permissionDAO.findOne(id);
        return c;
    }
}
