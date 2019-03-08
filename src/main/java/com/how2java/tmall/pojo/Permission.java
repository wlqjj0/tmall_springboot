package com.how2java.tmall.pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Set;

@Entity //表示这是一个实体类
@Table(name = "permission") //表示对应的表名是 category
@JsonIgnoreProperties({ "handler","hibernateLazyInitializer" })
public class Permission {
    @Id//表明主键
    @GeneratedValue(strategy = GenerationType.IDENTITY)//表明自增长方式
    @Column(name = "id")//表明对应的数据库字段名
    private int id;

    @Column(name = "name")//表明对应的数据库字段名
    private String name;

    @Column(name = "desc_")//表明对应的数据库字段名
    private String desc_;

    @Column(name = "url")//表明对应的数据库字段名
    private String url;


    @ManyToMany(mappedBy = "permissions")
    @JsonIgnore
    private Set<Role> roles;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc_() {
        return desc_;
    }

    public void setDesc_(String desc_) {
        this.desc_ = desc_;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    @Override
    public String toString() {
        return "Permission{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", desc_='" + desc_ + '\'' +
                ", url='" + url + '\'' +

                '}';
    }
}
