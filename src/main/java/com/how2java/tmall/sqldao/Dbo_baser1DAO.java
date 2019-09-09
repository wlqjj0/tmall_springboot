package com.how2java.tmall.sqldao;
import com.how2java.tmall.sqlpojo.Dbo_baser;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

//JpaRepository<Dbo_baser,Integer>

public interface Dbo_baser1DAO extends JpaSpecificationExecutor<Dbo_baser> {

    //List<Dbo_baser> findByScbmLike(String user);

}
