package com.lrdhappy.forum.controller;

import com.lrdhappy.forum.bean.User;
import com.lrdhappy.forum.service.impl.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

/**
 * @author lrd
 * @date 2023-01-28 14:29
 */
@Slf4j
@Controller
public class IndexController {
    @Autowired
    UserService userService;
    @RequestMapping("/")
    public String index(){
        return "index";
    }
    @GetMapping("/login")
    public String loginGetPage(){
        return "login";
    }
    @PostMapping("/login")
    public String loginPostPage(@RequestParam("account") String account,
                                @RequestParam("password") String password,
                                HttpSession session, Model model){
        User user=userService.selectAccount(account);
        if (user!=null&&user.getPassword().equals(password)){
            //把登陆成功的用户保存起来
            session.setAttribute("loginUser",user);
            return "redirect:/";
        }else {
            model.addAttribute("msg","账号或密码错误");
        }
        return "login";
    }
    @PostMapping("/forget")
    public String forgetPasswordPost(){
        return "redirect:/forgetpassword";
    }
    @GetMapping("/forgetpassword")
    public String forgetPasswordGet(){
        return "msg/forgetpassword";
    }
}
