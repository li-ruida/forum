package com.lrdhappy.forum.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lrdhappy.forum.bean.Post;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author lrd
 * @date 2023-01-28 16:32
 */
public interface PostMapper extends BaseMapper<Post> {
    @Select("select *from post_table")
    public List<Post> getAllPost();
}
