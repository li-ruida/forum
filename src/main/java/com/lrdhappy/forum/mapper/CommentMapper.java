package com.lrdhappy.forum.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lrdhappy.forum.bean.Comment;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author lrd
 * @date 2023-01-28 16:33
 */
public interface CommentMapper extends BaseMapper<Comment> {
    @Select("select * from comment_table where post=#{post} order by time asc")
    public List<Comment> selectAllByPostCommentList(int post);
}
