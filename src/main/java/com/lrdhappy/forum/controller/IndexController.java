package com.lrdhappy.forum.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author lrd
 * @date 2023-01-28 14:29
 */
@Slf4j
@Controller
public class IndexController {
    @RequestMapping("/")
    public String index(){
        return "index";
    }
}
