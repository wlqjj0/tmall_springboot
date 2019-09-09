package com.how2java.tmall.sqlpojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.extern.log4j.Log4j2;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Log4j2
@Entity //表示这是一个实体类
@Table(name = "dbo.baser1") //表示对应的表名是 category
@JsonIgnoreProperties({ "handler","hibernateLazyInitializer" })
public class Dbo_baser1 implements Serializable {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "gc")
    private String gc;
    @Id
    @Column(name = "tm")
    private String tm;
    @Column(name = "scbm")
    private String scbm;
    @Column(name = "ce")
    private String ce;
    @Column(name = "zz")
    private String zz;
    @Column(name = "gjkk")
    private String gjkk;
    @Column(name = "gjnum")
    private String gjnum;

/**
 * Couldnot write JSON: failed to lazily initialize a collection of role:
 * com.how2java.tmall.sqlpojo.Dbo_baser.dboCklistls, could not initialize proxy - no Session;
 * nested exception is com.fasterxml.jackson.databind.JsonMappingException:
 * failed to lazily initialize a collection of role: com.how2java.tmall.sqlpojo.Dbo_baser.dboCklistls,
 * FetchType.LAZY 时属性加上@JsonIgnore，避免返回时报错：Could not write JSON: failed to lazily initialize a collection of role
 * 【示例】
 *
 * @OneToMany(fetch=FetchType.LAZY)
 * @JsonIgnore
 * @Fetch(FetchMode.SELECT)
 * @Cascade(value={CascadeType.SAVE_UPDATE})
 * @JoinColumn(name="userId",updatable=false)
 * private Set<UserRoleBean> userRoleSet = new HashSet<UserRoleBean>();

 * 【说明】
 *
 * json序列化时将java bean中的一些属性忽略掉,序列化和反序列化都受影响
 *
 * 上述代码userRoleSet 属性上加了  @JsonIgnore,这个时候从后台推数据到前台的时候,就会把userRoleSet 这个引用属性给忽略掉。
 *
 * 避免返回写json时报错：
 *
 * HTTP Status 500 - Could not write JSON: failed to lazily initialize a collection of role:
 */
//    @ManyToMany
//    @JoinTable(name = "dbo_cklist",
//            joinColumns = @JoinColumn(name = "tm",referencedColumnName = "tm"),
//            inverseJoinColumns = @JoinColumn(name = "ckid", referencedColumnName = "ckid") )

   //@JsonIgnore//不加就等报错吧
    @OneToMany(mappedBy = "dboBaser")//@JoinColumn(name = "tm",referencedColumnName = "btm",insertable = false,updatable = false)
    private List<Dbo_cklist> dboCklist;

//    @OneToOne //这是正确的一对一
//    @JoinColumn(name = "tm",referencedColumnName = "tm")
//    private Dbo_testb dboTestbs;
//    @OneToOne(mappedBy = "dboBaser") //这是正确的一对一
//    //@JoinColumn(name = "tm",referencedColumnName = "tm")
//    private Dbo_testb dboTestbs;
    public Dbo_baser1(){
        super();
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
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

//    public List<Dbo_testb> getDboTestbs() {
//
////        if(dboTestbs!=null&&!"".equals(dboTestbs)){
////            log.info("if==ces");
////            log.info("dboTestbs=="+dboTestbs);
////            return dboTestbs;
////        }else
//        return dboTestbs;
//    }
//
//    public void setDboTestbs(List<Dbo_testb> dboTestbs) {
//        this.dboTestbs = dboTestbs;
//    }

    public List<Dbo_cklist> getDboCklist() {
        return dboCklist;
    }

    public void setDboCklist(List<Dbo_cklist> dboCklist) {
        this.dboCklist = dboCklist;
    }

    @Override
    public String toString() {
        return "Dbo_baser1{" +
                "id=" + id +
                ", gc='" + gc + '\'' +
                ", tm='" + tm + '\'' +
                ", scbm='" + scbm + '\'' +
                ", ce='" + ce + '\'' +
                ", zz='" + zz + '\'' +
                ", gjkk='" + gjkk + '\'' +
                ", gjnum='" + gjnum + '\'' +
                ", dboCklist=" + dboCklist +
                '}';
    }
}