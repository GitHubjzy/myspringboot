package com.jizy.um.ummanager.controller;

import com.jizy.um.ummanager.pub.po.User;
import com.jizy.um.ummanager.pub.vo.WebResponseVO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author jizy
 * @create 2019/4/2
 * @since 1.0.0
 */
@Controller
@RequestMapping("/login")
public class LoginController {
    private static final String ENCRYPT_KEY = "com.jizy.um_manager";
    @RequestMapping("/login")
    //@ResponseBody
    public String login(HttpServletRequest request , HttpServletResponse response, User user){
       return "login";
    }
}
