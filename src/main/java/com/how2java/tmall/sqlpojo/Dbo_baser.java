package com.how2java.tmall.sqlpojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity //表示这是一个实体类
@Table(name = "dbo.baser") //表示对应的表名是 category
@JsonIgnoreProperties({ "handler","hibernateLazyInitializer" })
public class Dbo_baser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    //@JoinColumn(name = "cid")
    int id;

    String gc;
    String tm;
    String scbm;
    String ce;
    String zz;
    String gjkk;
    String gjnum;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getGc() {
        return gc;
    }

    public void setGc(String gc) {
        this.gc = gc;
    }

    public String getTm() {
        return tm;
    }

    public void setTm(String tm) {
        this.tm = tm;
    }

    public String getScbm() {
        return scbm;
    }

    public void setScbm(String scbm) {
        this.scbm = scbm;
    }

    public String getCe() {
        return ce;
    }

    public void setCe(String ce) {
        this.ce = ce;
    }

    public String getZz() {
        return zz;
    }

    public void setZz(String zz) {
        this.zz = zz;
    }

    public String getGjkk() {
        return gjkk;
    }

    public void setGjkk(String gjkk) {
        this.gjkk = gjkk;
    }

    public String getGjnum() {
        return gjnum;
    }

    public void setGjnum(String gjnum) {
        this.gjnum = gjnum;
    }

    @Override
    public String toString() {
        return "Dbo_baser{" +
                "id=" + id +
                ", gc='" + gc + '\'' +
                ", tm='" + tm + '\'' +
                ", scbm='" + scbm + '\'' +
                ", ce='" + ce + '\'' +
                ", zz='" + zz + '\'' +
                ", gjkk='" + gjkk + '\'' +
                ", gjnum='" + gjnum + '\'' +
                '}';
    }
}