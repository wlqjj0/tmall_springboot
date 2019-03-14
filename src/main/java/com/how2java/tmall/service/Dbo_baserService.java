package com.how2java.tmall.service;

import com.how2java.tmall.sqldao.Dbo_baserDAO;
import com.how2java.tmall.sqlpojo.Dbo_baser;
import com.how2java.tmall.util.Page4Navigator;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Log4j2
@Service
public class Dbo_baserService {
    @Autowired //自动装配 上个步骤的 CategoryDAO 对象
    Dbo_baserDAO dboBaserDAO;
    public List<Dbo_baser> list() {
        Sort sort = new Sort(Sort.Direction.ASC, "id");//创建一个 Sort 对象，表示通过 id 倒排序， 然后通过 categoryDAO进行查询
        return dboBaserDAO.findAll(sort);
    }
    public Page4Navigator<Dbo_baser> listDbobaser(int start, int size) throws Exception {
        Sort sort1 = new Sort(Sort.Direction.ASC, "id");
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
}
