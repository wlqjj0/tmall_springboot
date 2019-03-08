package com.how2java.tmall.pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Set;

@Entity //表示这是一个实体类
@Table(name = "role") //表示对应的表名是 category
@JsonIgnoreProperties({ "handler","hibernateLazyInitializer" })
public class Role {
    @Id//表明主键
    @GeneratedValue(strategy = GenerationType.IDENTITY)//表明自增长方式
    @Column(name = "id")//表明对应的数据库字段名
    private int id;

    @Column(name = "name")//表明对应的数据库字段名
    private String name;

    @Column(name = "desc_")//表明对应的数据库字段名
    private String desc_;

    @JsonIgnore
    @ManyToMany(mappedBy = "roles")
    private Set<User> users;

    @ManyToMany
    @JoinTable(name = "role_permission",
            joinColumns = @JoinColumn(name = "rid",referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "pid", referencedColumnName = "id") )
    //@JsonIgnore
    private Set<Permission> permissions;

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

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    //@JsonIgnore
    public Set<Permission> getPermissions() {
        return permissions;
    }

    //@JsonIgnore
    public void setPermissions(Set<Permission> permissions) {
        this.permissions = permissions;
    }

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", desc_='" + desc_ + '\'' +
                ", users=" + users +

                '}';
    }
}