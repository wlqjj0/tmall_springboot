package com.how2java.tmall.service;

import com.how2java.tmall.dao.PermissionDAO;
import com.how2java.tmall.pojo.Permission;
import com.how2java.tmall.pojo.Role;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Log4j2
@Service
public class PermissionService {

    @Autowired
    PermissionDAO permissionDAO;
    @Autowired
    UserService userService;
    @Autowired
    RoleService roleService;

    public List<Permission> list() {
        Sort sort = new Sort(Sort.Direction.ASC, "id");//创建一个 Sort 对象，表示通过 id 正排序， 然后通过 categoryDAO进行查询
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
    public boolean needInterceptor(String requestURI) {
        List<Permission> ps = list();
        for (Permission p : ps) {
            log.info("Permission p ="+p.getUrl());
            if (p.getUrl().equals(requestURI))
                return true;
        }
        return false;
    }
    public Set<Permission> listPermissions(List<Role> roles) {
        Set<Permission> permissions = new HashSet<>();
        for (Role role : roles) {
            for (Permission permission : role.getPermissions()){
                permissions.add(permission);
            }
        }
        return permissions;
    }
    public Set<String> listPermissionURLs(String userName) {
        Set<String> result = new HashSet<>();
        List<Role> roles = roleService.listRoles(userName);
        Set<Permission> listPermissions=listPermissions(roles);
        for (Permission permission : listPermissions) {
            result.add(permission.getUrl());
        }
        return result;
    }
}
