package com.lrdhappy.forum.service.impl.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lrdhappy.forum.bean.Post;
import com.lrdhappy.forum.mapper.PostMapper;
import com.lrdhappy.forum.service.impl.PostService;
import com.lrdhappy.forum.service.impl.ThemeService;
import org.springframework.stereotype.Service;

/**
 * @author lrd
 * @date 2023-01-28 16:40
 */
@Service
public class PostServiceImpl extends ServiceImpl<PostMapper, Post> implements PostService {
}
