package com.lrdhappy.forum.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lrdhappy.forum.bean.User;
import com.lrdhappy.forum.mapper.UserMapper;
import com.lrdhappy.forum.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author lrd
 * @date 2023-01-28 15:31
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
    @Autowired
    UserMapper userMapper;//这个报错不用管,可以运行...
    @Override
    public User selectAccount(String account){
        return  userMapper.selectAccount(account);
    }
}
