package com.lrdhappy.forum.service.impl.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lrdhappy.forum.bean.User;
import com.lrdhappy.forum.mapper.UserMapper;
import com.lrdhappy.forum.service.impl.UserService;
import org.springframework.stereotype.Service;

/**
 * @author lrd
 * @date 2023-01-28 15:31
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
