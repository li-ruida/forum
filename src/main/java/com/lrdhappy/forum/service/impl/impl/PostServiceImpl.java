package com.lrdhappy.forum.service.impl.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lrdhappy.forum.bean.Post;
import com.lrdhappy.forum.mapper.PostMapper;
import com.lrdhappy.forum.service.impl.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author lrd
 * @date 2023-01-28 16:40
 */
@Service
public class PostServiceImpl extends ServiceImpl<PostMapper, Post> implements PostService {
    @Autowired
    PostMapper postMapper;
    @Override
    public Page<Post> postSelectByVisible(int pageNum, int pageLen) {
        Page<Post> page=new Page<>(pageNum,pageLen);
        LambdaQueryWrapper<Post> lambdaQueryWrapper=new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(Post::getVisible,1);
        lambdaQueryWrapper.orderByDesc(Post::getTime);
        Page<Post> postPage = postMapper.selectPage(page, lambdaQueryWrapper);
        return postPage;
    }

    @Override
    public Post postSelectByIdAndVisible(int id, int power) {
        Post post = postMapper.selectById(id);
        int visible=post.getVisible()==1?1:(power==-2?1:0);
        return visible==1?post:null;
    }

    @Override
    public List<Post> getAllPost() {
        return postMapper.getAllPost();
    }
}
