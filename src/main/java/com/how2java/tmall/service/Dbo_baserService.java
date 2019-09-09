package com.how2java.tmall.service;

import com.how2java.tmall.sqldao.Dbo_baser1DAO;
import com.how2java.tmall.sqldao.Dbo_baserDAO;
import com.how2java.tmall.sqlpojo.Dbo_baser;
import com.how2java.tmall.sqlpojo.Dbo_baser1;
import com.how2java.tmall.util.Page4Navigator;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.*;
import java.util.Date;
import java.util.List;

@Log4j2
@Service
public class Dbo_baserService {
    @Autowired //自动装配 上个步骤的 CategoryDAO 对象
    Dbo_baserDAO dboBaserDAO;
    //@Autowired
    Dbo_baser1DAO dbo_baser1DAO;
    public List<Dbo_baser> list() {
        Sort sort = new Sort(Sort.Direction.ASC, "id");//创建一个 Sort 对象，表示通过 id 倒排序， 然后通过 categoryDAO进行查询
        return dboBaserDAO.findAll(sort);
    }
    public Page4Navigator<Dbo_baser> listDbobaser(int start, int size) throws Exception {
        Sort sort1 = new Sort(Sort.Direction.DESC, "id");
        Pageable pageable = new PageRequest(start, size, sort1);
        log.info("pageable="+pageable);
        Page page =dboBaserDAO.findAll(pageable);
        log.info("page="+page);
        return new Page4Navigator<>(page);
    }
    public void add(Dbo_baser bean) {
        dboBaserDAO.save(bean);
    }
    public void delete(int id) {
        dboBaserDAO.delete(id);
        System.out.println("已经成功删除--"+id);
    }
    public void edit(Dbo_baser bean) {
        dboBaserDAO.save(bean);
    }
    public Dbo_baser get(int id) {
        //categoryDAO.getOne(id);
        Dbo_baser c=dboBaserDAO.findOne(id);
        return c;
    }
    public List<Dbo_baser> findlike(String name) {
        log.info("name=="+name);
        return dboBaserDAO.findByScbmLike("%"+name+"%");
    }

    /**
     * 复杂查询测试
     * @param page
     * @param size
     * @return
     */
    public Page<Dbo_baser> findByGc(int page, int size){

        PageRequest pageReq = this.buildPageRequest(page, size);
        Page<Dbo_baser> tasks = this.dbo_baser1DAO.findAll(new MyGc(), pageReq);
//传入了new MySpec() 既下面定义的匿名内部类 其中定义了查询条件
        return tasks;

    }

    /**
     * 建立分页排序请求
     * @param page
     * @param size
     * @return
     */
    private PageRequest buildPageRequest(int page, int size) {
        Sort sort = new Sort(Sort.Direction.DESC,"createTime");
        return new PageRequest(page,size, sort);
    }

    /**
     * 建立查询条件
     */
    private class MyGc implements Specification<Dbo_baser> {

        @Override
        public Predicate toPredicate(Root<Dbo_baser> root, CriteriaQuery<?> query, CriteriaBuilder cb) {

            //1.混合条件查询
            Path<String> exp1 = root.get("id");
            Path<Date>  exp2 = root.get("tm");
            Path<String> exp3 = root.get("scbm");
            Predicate predicate = cb.and(cb.like(exp1, "%gc%"),cb.lessThan(exp2, new Date()));
            return cb.or(predicate,cb.equal(exp3, "kkk"));

           /* 类似的sql语句为:
            Hibernate:
                select
                    count(task0_.id) as col_0_0_
                from
                    tb_task task0_
                where
                    (
                        task0_.task_name like ?
                    )
                    and task0_.create_time<?
                    or task0_.task_detail=?
            */

//            //2.多表查询
//            Join<Task,Project> join = root.join("project", JoinType.INNER);
//            Path<String> exp4 = join.get("projectName");
//            return cb.like(exp4, "%projectName%");
//
//           /* Hibernate:
//            select
//                count(task0_.id) as col_0_0_
//            from
//                tb_task task0_
//            inner join
//                tb_project project1_
//                    on task0_.project_id=project1_.id
//            where
//                project1_.project_name like ?*/
//            return null ;
        }
    }
}
