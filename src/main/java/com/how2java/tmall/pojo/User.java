package com.how2java.tmall.pojo;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity //表示这是一个实体类
@Table(name = "user") //表示对应的表名是 category
@JsonIgnoreProperties({ "handler","hibernateLazyInitializer" })
public class User {
    @Id//表明主键
    @GeneratedValue(strategy = GenerationType.IDENTITY)//表明自增长方式
    @Column(name = "id")//表明对应的数据库字段名
    private int id;

    @Column(name = "name")//表明对应的数据库字段名
    private String name;

    @Column(name = "user_Property")//表明对应的数据库字段名
    private String user_Property;//用户属性

    @Column(name = "password")//表明对应的数据库字段名
    private String password;

    @Column(name = "salt")
    private String salt;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUser_Property() {
        return user_Property;
    }

    public void setUser_Property(String user_Property) {
        this.user_Property = user_Property;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", user_Property='" + user_Property + '\'' +
                ", password='" + password + '\'' +
                ", salt='" + salt + '\'' +
                '}';
    }
}
