package com.lrdhappy.forum.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.lrdhappy.forum.bean.Post;

import java.util.List;

/**
 * @author lrd
 * @date 2023-01-28 16:38
 */
public interface PostService extends IService<Post> {
    public Page<Post> postSelectByVisible(int pageNum, int pageLen);

    public Post postSelectByIdAndVisible(int id,int visible);

    public List<Post> getAllPost();
}
