package com.how2java.tmall.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity //表示这是一个实体类
@Table(name = "property") //表示对应的表名是 category
@JsonIgnoreProperties({ "handler","hibernateLazyInitializer" }) // 因为是做前后端分离，而前后端数据交互用的是 json 格式。
                                                                // 那么 Category 对象就会被转换为 json 数据。
                                                                // 而本项目使用 jpa 来做实体类的持久化，jpa 默认会使用 hibernate,
                                                                // 在 jpa 工作过程中，就会创造代理类来继承 Category ，
                                                                // 并添加 handler 和 hibernateLazyInitializer 这两个无须 json 化的属性，
                                                                // 所以这里需要用 JsonIgnoreProperties 把这两个属性忽略掉。

public class Property {
    @Id//表明主键
    @GeneratedValue(strategy = GenerationType.IDENTITY)//表明自增长方式
    @Column(name = "id")//表明对应的数据库字段名
    private int id;

    @Column(name = "name")//表明对应的数据库字段名
    private String name;

    @ManyToOne
    @JoinColumn(name="cid")
    private Category category;
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Property{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", category=" + category +
                '}';
    }
}