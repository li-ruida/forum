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
    @GetMapping("/register")
    public String getRegister(){
        return "register";
    }
    @PostMapping("/register")
    public String postRegister(@RequestParam("account") String account,
                               @RequestParam("name") String name,
                               @RequestParam("password") String password,
                               @RequestParam("password1") String password1,
                               HttpSession session, Model model){
        if(password.equals(password1)){
            User user=userService.selectAccount(account);
            if(user==null){
                user=new User(account,name,password);
                boolean save = userService.save(user);
                model.addAttribute("msg",save?"注册成功":"注册失败");
            }
            else {
                model.addAttribute("msg","账户已存在");
            }
        }
        else{
            model.addAttribute("msg","密码不一致,请重新输入");
        }

        return "register";
    }
}
