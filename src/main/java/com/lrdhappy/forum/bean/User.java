package com.lrdhappy.forum.bean;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;
import org.springframework.stereotype.Component;

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
@Component
public class User {
    int id;
    String name;
    int power;
    String account;
    String password;
    public User(String account,String name,String password){
        this.account=account;
        this.power=0;
        this.name=name;
        this.password=password;
    }
}
