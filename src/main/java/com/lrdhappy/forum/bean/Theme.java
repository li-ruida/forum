package com.lrdhappy.forum.bean;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

/**
 * @author lrd
 * @date 2023-01-28 16:07
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@TableName("theme_table")
public class Theme {
    int id;
    String name;
    int moderator;
    int visible;
}
