package com.lrdhappy.forum.controller;

import com.lrdhappy.forum.service.RedisService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author lrd
 * @date 2023-02-01 17:44
 */
@Slf4j
@Controller
public class HotSearchController {
    @Autowired
    private RedisService redisService;
    @GetMapping("/hotsearch")
    public String getHotSearch(Model model){
        Map<Object, Object> searchmap = redisService.hGetAll("forum:search:hot");
        model.addAttribute("hotmap",searchmap);
        return "table/hotsearch";
    }
}
