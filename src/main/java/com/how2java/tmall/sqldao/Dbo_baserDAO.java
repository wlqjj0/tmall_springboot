package com.how2java.tmall.sqldao;

import com.how2java.tmall.sqlpojo.Dbo_baser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface Dbo_baserDAO extends JpaRepository<Dbo_baser,Integer> {

    List<Dbo_baser> findByScbmLike(String user);

}
