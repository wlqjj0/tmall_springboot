package com.how2java.tmall.sqlpojo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;

@Entity //表示这是一个实体类
@Table(name = "dbo.testb") //表示对应的表名是 category
@JsonIgnoreProperties({ "handler","hibernateLazyInitializer" })
public class Dbo_testb implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
//    @Column(name = "btm")
//    private String btm;//,referencedColumnName = "tm")

//    @JsonIgnore
//    @ManyToOne
//    @JoinColumn(name = "tm" ,referencedColumnName = "tm")
//    private Dbo_baser dboBaser;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

//    public String getTm() {
//        return tm;
//    }
//
//    public void setTm(String tm) {
//        this.tm = tm;
//    }
//    public String getBid() {
//        return bid;
//    }
//
//    public void setBid(String bid) {
//        this.bid = bid;
//    }
//

//    public Dbo_baser getDboBaser() {
//        return dboBaser;
//    }
//
//    public void setDboBaser(Dbo_baser dboBaser) {
//        this.dboBaser = dboBaser;
//    }

//    public String getBtm() {
//        return btm;
//    }
//
//    public void setBtm(String btm) {
//        this.btm = btm;
//    }


    @Override
    public String toString() {
        return "Dbo_testb{" +
                "id=" + id +
               // ", dboBaser=" + dboBaser +
                '}';
    }
}
