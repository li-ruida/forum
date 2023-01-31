package com.lrdhappy.forum.controller;

import com.lrdhappy.forum.bean.Post;
import com.lrdhappy.forum.dao.PostDao;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

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
    @PostMapping("/search")
    public String searchPost(@RequestParam String searchword, Model model){
        postPage = postDao.findByContentOrName(searchword, searchword);
        model.addAttribute("postpage",postPage);
        return "search";
    }
}
