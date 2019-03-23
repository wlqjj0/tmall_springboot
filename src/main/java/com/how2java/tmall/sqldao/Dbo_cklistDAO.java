package com.how2java.tmall.sqldao;

import com.how2java.tmall.sqlpojo.Dbo_baser;
import com.how2java.tmall.sqlpojo.Dbo_cklist;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface Dbo_cklistDAO extends JpaRepository<Dbo_cklist,Integer> {
    //List<Dbo_cklist> findByTm(String tm);
}
