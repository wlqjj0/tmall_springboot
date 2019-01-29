package com.how2java.tmall.dao;

import com.how2java.tmall.pojo.Permission;
import org.springframework.data.jpa.repository.JpaRepository;

//CategoryDAO 类集成了 JpaRepository，就提供了CRUD和分页 的各种常见功能。 这就是采用 JPA 方便的地方~
public interface PermissionDAO extends JpaRepository<Permission,Integer> {
}