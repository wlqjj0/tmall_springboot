package com.how2java.tmall.web;

import com.how2java.tmall.dao.UserDAO;
import com.how2java.tmall.pojo.Category;
import com.how2java.tmall.pojo.User;
import com.how2java.tmall.service.CategoryService;
import com.how2java.tmall.service.UserService;
import com.how2java.tmall.util.Result;
import org.apache.commons.lang.math.RandomUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.HtmlUtils;

import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by GaryLee on 2018-11-13 09:00.
 */
@RestController
public class ForeController {
    @Autowired
    CategoryService categoryService;
    @Autowired
    UserService userService;
    @Autowired
    UserDAO userDao;
//    @PostMapping("foreregister")
//    public Object register(@RequestBody User user){
//        String name = user.getUsername();
//        String password = user.getPassword();
//        //可将name转义,防止有人恶意注册,如 “<script>alert('papapa')</script> ”,导致打开网页就会弹窗
//        //转义后则为“&lt;script&gt;alert(&#39;papapa&#39;)&lt;/script&gt;”
//        name = HtmlUtils.htmlEscape(name);
//        user.setUsername(name);
//        boolean exist = userService.isExist(name);
//        if(exist){
//            String message = "用户名已经被使用,不能使用";
//            return Result.fail(message);
//        }
//
//        //shiro
//        //盐,随机生成,用于与已有字符串拼接
//        String salt = new SecureRandomNumberGenerator().nextBytes().toString();
//        //加密次数(即加密后的字符串继续加密)
//        int times = 2;
//        //加密算法
//        String algorithmName = "md5";
//        //生成加密码
//        String encodedPassword = new SimpleHash(algorithmName,password,salt,times).toString();
//        user.setSalt(salt);
//        user.setPassword(encodedPassword);
//
//        userService.add(user);
//        return Result.success();
//    }
    @PostMapping("forelogin")
    /**
    * @RequestBody: 可将请求体中的JSON字符串绑定到相应的bean上
     * 前端用ajax发起请求
     * 把name和password绑定到userParam中
    */
    public Object login(@RequestBody User userParam, HttpSession session){
       String name = userParam.getName();
       name = HtmlUtils.htmlEscape(name);
       System.out.println("name="+name);
//
//        //shiro
//        //获取subject对象
//        Subject subject = SecurityUtils.getSubject();
//        //token传递输入的账号和密码
//        UsernamePasswordToken token = new UsernamePasswordToken(name,userParam.getPassword());
//        try {
//            //登陆操作,没报错的话则登陆成功
//            subject.login(token);
//            //根据name到数据库获取对应的user
//            User user = userDao.findByUsername(name);
//            //没catch到错误说明
//            session.setAttribute("user",user);
//            return Result.success();
//        }catch (AuthenticationException e){
//            String message = "账号或密码错误";
//            return Result.fail(message);
//        }

//        User user = userService.getUser(name,userParam.getPassword());
//        if(null!=user){
//            //将用户登陆信息存放到session中，前端即可判断用户是否登陆，如果登陆即可获取其信息
//            session.setAttribute("user",user);
//            return Result.success();
//        }else {
//            String message = "账号或密码错误";
//            return Result.fail(message);
//        }
        User user = userDao.findByName(name);
            //没catch到错误说明
        System.out.println("user="+user);
        System.out.println("userParam.getPassword="+userParam.getPassword());
        System.out.println("user.getPassword()="+user.getPassword());

        if(userParam.getPassword().equals(user.getPassword())){
            session.setAttribute("user",user);
            System.out.println("if对比Result.success()="+Result.success());
            return Result.success();
        }else {
            System.out.println("if对比Result.FAIL_CODE="+Result.FAIL_CODE);
            return Result.FAIL_CODE;
        }

    }
}
