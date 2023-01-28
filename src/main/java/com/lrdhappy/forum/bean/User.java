package com.lrdhappy.forum.bean;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

/**
 * @author lrd
 * @date 2023-01-28 15:24
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@TableName("user_table")
public class User {
    int id;
    String name;
    int power;
    String account;
    String password;
}
