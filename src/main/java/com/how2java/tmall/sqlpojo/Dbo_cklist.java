package com.how2java.tmall.sqlpojo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;

@Entity //表示这是一个实体类
@Table(name = "dbo.cklist") //表示对应的表名是 category
@JsonIgnoreProperties({ "handler","hibernateLazyInitializer" })
public class Dbo_cklist implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "kind")
    private String kind;
//    @Column(name = "tm")
//    private String tm;
    @Column(name = "yg")
    private String yg;
    @Column(name = "rutm")
    private String rutm;
//    @Column(name = "drz")
//    private String drz;
//    @Column(name = "ckid")
//    private String ckid;
    //String gjnum;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "tm")//,referencedColumnName = "tm")
    private Dbo_baser dboBaser;

    public Dbo_cklist(){
        super();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

//    public String getTm() {
//        return tm;
//    }
//
//    public void setTm(String tm) {
//        this.tm = tm;
//    }

    public String getYg() {
        return yg;
    }

    public void setYg(String yg) {
        this.yg = yg;
    }

    public String getRutm() {
        return rutm;
    }

    public void setRutm(String rutm) {
        this.rutm = rutm;
    }
//
//    public String getDrz() {
//        return drz;
//    }
//
//    public void setDrz(String drz) {
//        this.drz = drz;
//    }
//
//    public String getCkid() {
//        return ckid;
//    }
//
//    public void setCkid(String ckid) {
//        this.ckid = ckid;
//    }

    public Dbo_baser getDboBaser() {
        return dboBaser;
    }

    public void setDboBaser(Dbo_baser dboBaser) {
        this.dboBaser = dboBaser;
    }

    @Override
    public String toString() {
        return "Dbo_cklist{" +
                "id=" + id +
                ", kind='" + kind + '\'' +
                ", yg='" + yg + '\'' +
                ", rutm='" + rutm + '\'' +
                ", dboBaser=" + dboBaser +
                '}';
    }
}
