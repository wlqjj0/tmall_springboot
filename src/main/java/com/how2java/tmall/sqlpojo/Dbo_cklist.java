package com.how2java.tmall.sqlpojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity //表示这是一个实体类
@Table(name = "dbo.cklist") //表示对应的表名是 category
@JsonIgnoreProperties({ "handler","hibernateLazyInitializer" })
public class Dbo_cklist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    //@JoinColumn(name = "cid")
    int id;
    String kind;
    String tm;
    String yg;
    String rutm;
    String drz;
    //String gjkk;
    //String gjnum;

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

    public String getTm() {
        return tm;
    }

    public void setTm(String tm) {
        this.tm = tm;
    }

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

    public String getDrz() {
        return drz;
    }

    public void setDrz(String drz) {
        this.drz = drz;
    }

    @Override
    public String toString() {
        return "Dbo_cklist{" +
                "id=" + id +
                ", kind='" + kind + '\'' +
                ", tm='" + tm + '\'' +
                ", yg='" + yg + '\'' +
                ", rutm='" + rutm + '\'' +
                ", drz='" + drz + '\'' +
                '}';
    }
}
