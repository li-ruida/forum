package com.lrdhappy.forum.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lrdhappy.forum.bean.Comment;
import com.lrdhappy.forum.config.RedisConfig;
import com.lrdhappy.forum.mapper.CommentMapper;
import com.lrdhappy.forum.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
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
    @Cacheable(value = RedisConfig.REDIS_KEY_DATABASE, key = "'forum:comment:getbypostid'+#postid", unless = "#result==null")
    @Override
    public List<Comment> selectCommentByPostId(int postid) {
        System.out.println("未使用缓存 获取评论");
        return commentMapper.selectAllByPostCommentList(postid);
    }
}
