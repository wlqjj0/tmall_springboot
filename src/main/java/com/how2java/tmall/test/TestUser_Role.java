package com.how2java.tmall.test;

import com.how2java.tmall.dao.RoleDAO;
import com.how2java.tmall.dao.UserDAO;
import com.how2java.tmall.pojo.Role;
import com.how2java.tmall.pojo.User;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;


public class TestUser_Role {

    User user=new User();
    Role role=new Role();
    @Autowired
    UserDAO userDAO=new UserDAO() {
        @Override
        public User findByName(String name) {
            return null;
        }

        @Override
        public User findByNameAndPassword(String name, String password) {
            return null;
        }

        @Override
        public List<User> findAll() {
            return null;
        }

        @Override
        public List<User> findAll(Sort sort) {
            return null;
        }

        @Override
        public List<User> findAll(Iterable<Integer> integers) {
            return null;
        }

        @Override
        public <S extends User> List<S> save(Iterable<S> entities) {
            return null;
        }

        @Override
        public void flush() {

        }

        @Override
        public <S extends User> S saveAndFlush(S entity) {
            return null;
        }

        @Override
        public void deleteInBatch(Iterable<User> entities) {

        }

        @Override
        public void deleteAllInBatch() {

        }

        @Override
        public User getOne(Integer integer) {
            return null;
        }

        @Override
        public <S extends User> List<S> findAll(Example<S> example) {
            return null;
        }

        @Override
        public <S extends User> List<S> findAll(Example<S> example, Sort sort) {
            return null;
        }

        @Override
        public Page<User> findAll(Pageable pageable) {
            return null;
        }

        @Override
        public <S extends User> S save(S entity) {
            return null;
        }

        @Override
        public User findOne(Integer integer) {
            return null;
        }

        @Override
        public boolean exists(Integer integer) {
            return false;
        }

        @Override
        public long count() {
            return 0;
        }

        @Override
        public void delete(Integer integer) {

        }

        @Override
        public void delete(User entity) {

        }

        @Override
        public void delete(Iterable<? extends User> entities) {

        }

        @Override
        public void deleteAll() {

        }

        @Override
        public <S extends User> S findOne(Example<S> example) {
            return null;
        }

        @Override
        public <S extends User> Page<S> findAll(Example<S> example, Pageable pageable) {
            return null;
        }

        @Override
        public <S extends User> long count(Example<S> example) {
            return 0;
        }

        @Override
        public <S extends User> boolean exists(Example<S> example) {
            return false;
        }
    };
    @Autowired
    RoleDAO roleDAO=new RoleDAO() {
        @Override
        public List<Role> findAll() {
            return null;
        }

        @Override
        public List<Role> findAll(Sort sort) {
            return null;
        }

        @Override
        public List<Role> findAll(Iterable<Integer> integers) {
            return null;
        }

        @Override
        public <S extends Role> List<S> save(Iterable<S> entities) {
            return null;
        }

        @Override
        public void flush() {

        }

        @Override
        public <S extends Role> S saveAndFlush(S entity) {
            return null;
        }

        @Override
        public void deleteInBatch(Iterable<Role> entities) {

        }

        @Override
        public void deleteAllInBatch() {

        }

        @Override
        public Role getOne(Integer integer) {
            return null;
        }

        @Override
        public <S extends Role> List<S> findAll(Example<S> example) {
            return null;
        }

        @Override
        public <S extends Role> List<S> findAll(Example<S> example, Sort sort) {
            return null;
        }

        @Override
        public Page<Role> findAll(Pageable pageable) {
            return null;
        }

        @Override
        public <S extends Role> S save(S entity) {
            return null;
        }

        @Override
        public Role findOne(Integer integer) {
            return null;
        }

        @Override
        public boolean exists(Integer integer) {
            return false;
        }

        @Override
        public long count() {
            return 0;
        }

        @Override
        public void delete(Integer integer) {

        }

        @Override
        public void delete(Role entity) {

        }

        @Override
        public void delete(Iterable<? extends Role> entities) {

        }

        @Override
        public void deleteAll() {

        }

        @Override
        public <S extends Role> S findOne(Example<S> example) {
            return null;
        }

        @Override
        public <S extends Role> Page<S> findAll(Example<S> example, Pageable pageable) {
            return null;
        }

        @Override
        public <S extends Role> long count(Example<S> example) {
            return 0;
        }

        @Override
        public <S extends Role> boolean exists(Example<S> example) {
            return false;
        }
    };


    public void  TestUser_Role(){


//        user.setId(123);
//        user.setName("123");
//        user.setPassword("123");
//        user.setSalt("123");
      user.getRoles().add(role);
//        userDAO.save(user);
        System.out.println(user);
    }
    //@Test
    public List<User> list() {
        Sort sort = new Sort(Sort.Direction.DESC, "id");//创建一个 Sort 对象，表示通过 id 倒排序， 然后通过 categoryDAO进行查询
        System.out.println(userDAO.findAll(sort));
        return userDAO.findAll(sort);
    }

}