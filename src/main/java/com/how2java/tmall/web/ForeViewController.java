package com.how2java.tmall.web;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

/**
 * Created by GaryLee on 2018-11-29 00:40.
 * 前台页面跳转
 */
@Controller
public class ForeViewController {
    @GetMapping("/forelogout")
    public String logout(HttpSession session) {
        Subject subject = SecurityUtils.getSubject();
        //shiro判断
        if(subject.isAuthenticated())
            subject.logout();

//        //退出登录，session移除user对象
//        session.removeAttribute("user");
        return "redirect:admin";
    }

}
