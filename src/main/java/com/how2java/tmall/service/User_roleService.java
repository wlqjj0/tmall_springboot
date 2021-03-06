package com.how2java.tmall.service;

import com.how2java.tmall.dao.User_roleDAO;
import com.how2java.tmall.pojo.User_role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class User_roleService {
    @Autowired
    User_roleDAO user_roleDAO;

    public List<User_role> list() {
        Sort sort = new Sort(Sort.Direction.DESC, "id");//创建一个 Sort 对象，表示通过 id 倒排序， 然后通过 categoryDAO进行查询
        return user_roleDAO.findAll(sort);
    }
    public void add(User_role bean) {
        user_roleDAO.save(bean);
        System.out.println("userDAO--已经成功增加--"+bean.getId());
    }
    public void delete(int id) {
        user_roleDAO.delete(id);
        System.out.println("userDAO--已经成功删除--"+id);
    }
    public void edit(User_role bean) {
        user_roleDAO.save(bean);
    }
    public User_role get(int id) {
        //categoryDAO.getOne(id);
        User_role c=user_roleDAO.findOne(id);
        return c;
    }
    public void setRole(String s,String c[]) {
        //String s=String.valueOf(bean.getId());
        List<User_role> list=user_roleDAO.findByUid(s);
        System.out.println("哈哈哈--"+list);
        for (User_role rolePermission : list)
            user_roleDAO.delete(rolePermission.getId());
        //设置新的权限关系
        if(null!=c)
            for (String rid : c) {
                User_role user_role=new User_role();
                user_role.setUid(s+"");
                user_role.setRid(rid+"");
                user_roleDAO.save(user_role);

            }
    }
    public List<User_role> listUserRoles(String uid) {
        return user_roleDAO.findByUid(uid);
    }

}
