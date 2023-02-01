package com.lrdhappy.forum.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lrdhappy.forum.bean.User;

/**
 * @author lrd
 * @date 2023-01-28 15:30
 */
public interface UserService extends IService<User> {
    User selectAccount(String account);
}