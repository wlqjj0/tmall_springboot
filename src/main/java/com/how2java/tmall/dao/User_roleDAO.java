package com.how2java.tmall.dao;

import com.how2java.tmall.pojo.User_role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface User_roleDAO extends JpaRepository<User_role,Integer> {
    List<User_role> findByUid(String uid);
}
