package com.how2java.tmall.service;

import com.how2java.tmall.dao.RoleDAO;
import com.how2java.tmall.pojo.Role;
import com.how2java.tmall.pojo.User;
import com.how2java.tmall.pojo.User_role;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Log4j2
@Service
public class RoleService {

    @Autowired
    RoleDAO roleDAO;
    @Autowired
    UserService userService;
    @Autowired
    User_roleService userRoleService;
    @Autowired
    RoleService roleService;

    public List<Role> list() {
        Sort sort = new Sort(Sort.Direction.ASC, "id");//创建一个 Sort 对象，表示通过 id 倒排序， 然后通过 categoryDAO进行查询
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
    public List<Role> listRoles(String userName) {
        List<Role> roles = new ArrayList<>();
        User user=userService.getByName(userName);
        log.info("User user="+user);
        for(Role role : user.getRoles()){
            //Role role=roleService.get(userRole.getId());
            roles.add(role);
        }
        //roles=user.getRoles();

//        List<User_role> userRoles=userRoleService.listUserRoles(user.getId()+"");
//        for(User_role userRole : userRoles){
//        Role role=roleService.get(userRole.getId());
//        roles.add(role);
//        }
        return roles;
    }
}
