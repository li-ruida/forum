package com.lrdhappy.forum;

import com.lrdhappy.forum.bean.User;
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
    @Test
    void userTest(){
        User byId;
        byId = userService.getById(1);
        System.out.println(byId);
    }
}
