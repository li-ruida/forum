package com.lrdhappy.forum.controller;

import com.lrdhappy.forum.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author lrd
 * @date 2023-01-29 2:46
 */
@Slf4j
@Controller
public class UserController {
    @Autowired
    UserService userService;
    @GetMapping("/profile")
    public String getProfile(){
        return "profile";
    }
}
