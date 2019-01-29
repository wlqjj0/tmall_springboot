package com.how2java.tmall.service;


import com.how2java.tmall.dao.UserDAO;
import com.how2java.tmall.pojo.User;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UserDAO userDAO;

    public List<User> list() {
        Sort sort = new Sort(Sort.Direction.DESC, "id");//创建一个 Sort 对象，表示通过 id 倒排序， 然后通过 categoryDAO进行查询
        return userDAO.findAll(sort);
    }
    public void add(User bean) {
        userDAO.save(bean);
        System.out.println("userDAO--已经成功增加--"+bean.getName());
    }
    public void delete(int id) {
        userDAO.delete(id);
        System.out.println("userDAO--已经成功删除--"+id);
    }
    public void edit(User bean) {
        userDAO.save(bean);
    }
    public User get(int id) {
        //categoryDAO.getOne(id);
        User c=userDAO.findOne(id);
        return c;
    }
    public User getByName(String name) {
        User c=userDAO.findByName(name);
        return c;
    }
    public boolean isExist(String name) {
        User user = userDAO.findByName(name);
        return null!=user;
    }

}
