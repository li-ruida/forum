package com.lrdhappy.forum.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lrdhappy.forum.bean.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * @author lrd
 * @date 2023-01-28 15:29
 */
public interface UserMapper extends BaseMapper<User> {
    @Select("select *from user_table where account=#{account}")
    public User selectAccount(@Param("account") String account);
}
