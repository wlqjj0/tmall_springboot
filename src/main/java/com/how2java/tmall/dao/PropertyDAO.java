package com.how2java.tmall.dao;

import com.how2java.tmall.pojo.Category;
import com.how2java.tmall.pojo.Property;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;



//CategoryDAO 类集成了 JpaRepository，就提供了CRUD和分页 的各种常见功能。 这就是采用 JPA 方便的地方~
public interface PropertyDAO extends JpaRepository<Property,Integer> {
    Page<Property> findByCategory(Category category, Pageable pageable);//提供根据分类进行查询
}
