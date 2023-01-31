package com.lrdhappy.forum.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lrdhappy.forum.bean.Comment;
import com.lrdhappy.forum.bean.Post;
import com.lrdhappy.forum.bean.Theme;
import com.lrdhappy.forum.bean.User;
import com.lrdhappy.forum.service.impl.CommentService;
import com.lrdhappy.forum.service.impl.PostService;
import com.lrdhappy.forum.service.impl.ThemeService;
import com.lrdhappy.forum.service.impl.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author lrd
 * @date 2023-01-29 9:46
 */
@Controller
@Slf4j
public class PostController {
    @Autowired
    UserService userService;
    @Autowired
    PostService postService;
    @Autowired
    ThemeService themeService;
    @Autowired
    CommentService commentService;

    @Autowired
    User loginUser;
    @GetMapping("/")
    public String index(HttpSession session, Model model){
        Page<Post> postPage = postService.postSelectByVisible(1, 5);
        model.addAttribute("postpage",postPage);
        return "index";
    }
    @GetMapping("/post/{id}")
    public String getPostDetail(@PathVariable("id") String id,
                                HttpSession session,Model model
                                ){
        loginUser = (User) session.getAttribute("loginUser");
        int power;
        if(loginUser!=null)
            power=loginUser.getPower();
        else
            power=0;
        Post post=postService.postSelectByIdAndVisible(Integer.parseInt(id),power);
        User writter = userService.getById(post.getWritter());
        Theme theme = themeService.getById(post.getTheme());
        List<Comment> comments = commentService.selectCommentByPostId(post.getId());
        Map<Comment,User> commentsmap=new HashMap<>();
        for(Comment c:comments){
            User user=userService.getById(c.getWritter());
            commentsmap.put(c,user);
        }
        System.out.println(commentsmap.toString());
        //评论
        model.addAttribute("theme",theme);
        model.addAttribute("writter",writter);
        model.addAttribute("postdetail",post);
        model.addAttribute("commentsmap",commentsmap);
        return "postdetail";
    }
    @GetMapping("/page")
    public String postPost(@RequestParam(value = "pagenum",defaultValue = "1") String pagenum,
                           @RequestParam(value = "pagelen",defaultValue = "5") String pagelen
                            ,Model model){
        Page<Post> postPage = postService.postSelectByVisible(Integer.parseInt(pagenum), Integer.parseInt(pagelen));
        model.addAttribute("postpage",postPage);
        return "index";
    }
}
