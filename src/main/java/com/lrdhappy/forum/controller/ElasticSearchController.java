package com.lrdhappy.forum.controller;

import com.lrdhappy.forum.bean.Post;
import com.lrdhappy.forum.dao.PostDao;
import com.lrdhappy.forum.service.RedisService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author lrd
 * @date 2023-01-31 23:03
 */
@Controller
@Slf4j
public class ElasticSearchController {
    @Autowired
    PostDao postDao;
    @Autowired
    List<Post> postPage;
    @Autowired
    private RedisService redisService;
    @PostMapping("/search")
    public String searchPost(@RequestParam String searchword, Model model){
        postPage = postDao.findByContentOrName(searchword, searchword);
        Map<String,Object> map=new HashMap<>();
        Object count=  redisService.hGet("forum:search:hot",searchword);
        map.put(searchword,count==null?1:(Integer)count+1);
        redisService.hSetAll("forum:search:hot",map,60*60);
        model.addAttribute("postpage",postPage);
        return "search";
    }
}
