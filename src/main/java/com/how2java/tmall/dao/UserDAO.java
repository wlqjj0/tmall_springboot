package com.how2java.tmall.dao;

import com.how2java.tmall.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDAO extends JpaRepository<User,Integer> {//Integer参数为User的id类型
    public User findByName(String name);

    public User findByNameAndPassword(String name,String password);
}
