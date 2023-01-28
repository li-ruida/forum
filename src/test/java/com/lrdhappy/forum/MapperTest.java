package com.lrdhappy.forum;

import com.lrdhappy.forum.bean.User;
import com.lrdhappy.forum.service.impl.CommentService;
import com.lrdhappy.forum.service.impl.PostService;
import com.lrdhappy.forum.service.impl.ThemeService;
import com.lrdhappy.forum.service.impl.UserService;
import lombok.val;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author lrd
 * @date 2023-01-28 15:27
 */
@SpringBootTest
public class MapperTest {
    @Autowired
    UserService userService;

    @Autowired
    PostService postService;

    @Autowired
    ThemeService themeService;

    @Autowired
    CommentService commentService;
    @Test
    void userTest(){
        User byId;
        byId = userService.getById(1);
        System.out.println(byId);
    }
    @Test
    void postTest(){
        System.out.println(postService.getById(1));
    }
    @Test
    void themeTest(){
        System.out.println(themeService.getById(1));
    }
    @Test
    void commentTest(){
        System.out.println(commentService.getById(1));
    }
    @Test
    void userSelectByAccount(){
        System.out.println(userService.selectAccount("1002"));
    }
}
