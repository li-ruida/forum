package com.lrdhappy.forum.controller;

import com.lrdhappy.forum.bean.Comment;
import com.lrdhappy.forum.bean.User;
import com.lrdhappy.forum.service.impl.CommentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.Date;

/**
 * @author lrd
 * @date 2023-01-31 10:41
 */
@Controller
@Slf4j
public class CommentController {
    @Autowired
    CommentService commentService;
    @Autowired
    User user;
    @Autowired
    Comment comment;
    @PutMapping("/comment/{id}")
    public String putComment(@PathVariable("id") String id ,
                             @RequestParam("postid") String postid,
                             @RequestParam("content") String content,
                             HttpSession session){
        comment=new Comment();
        comment.setTime(new Date(System.currentTimeMillis()));
        comment.setContent(content);
        comment.setPost(Integer.parseInt(postid));
        user= (User) session.getAttribute("loginUser");
        comment.setWritter(user.getId());
        comment.setVisible(1);
        comment.setReply(0);
        commentService.save(comment);
        return "redirect:/post/"+postid;
    }
}
