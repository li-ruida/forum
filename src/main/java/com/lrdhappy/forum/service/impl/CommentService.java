package com.lrdhappy.forum.service.impl;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lrdhappy.forum.bean.Comment;

import java.util.List;

/**
 * @author lrd
 * @date 2023-01-28 16:39
 */
public interface CommentService extends IService<Comment> {
    public List<Comment> selectCommentByPostId(int postid);
}
