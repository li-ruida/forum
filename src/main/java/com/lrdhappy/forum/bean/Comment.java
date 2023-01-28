package com.lrdhappy.forum.bean;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

import java.util.Date;

/**
 * @author lrd
 * @date 2023-01-28 16:29
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@TableName("comment_table")
public class Comment {
    int id;
    Date time;
    int writter;
    int visible;
    String content;
    int post;
    int reply;
}
