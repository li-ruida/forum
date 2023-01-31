package com.lrdhappy.forum.bean;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;
import org.springframework.stereotype.Component;

import java.util.Date;


/**
 * @author lrd
 * @date 2023-01-28 16:09
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Component
@TableName("post_table")
public class Post {
    int id;
    String name;
    int writter;
    int visible;
    String content;
    int theme;
    Date time;
}
