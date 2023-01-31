package com.lrdhappy.forum.service.impl.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lrdhappy.forum.bean.Comment;
import com.lrdhappy.forum.mapper.CommentMapper;
import com.lrdhappy.forum.service.impl.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author lrd
 * @date 2023-01-28 16:41
 */
@Service
public class CommentServiceImpl extends ServiceImpl<CommentMapper, Comment> implements CommentService {
    @Autowired
    CommentMapper commentMapper;
    @Override
    public List<Comment> selectCommentByPostId(int postid) {
        return commentMapper.selectAllByPostCommentList(postid);
    }
}
