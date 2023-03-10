package com.lrdhappy.forum.bean;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;
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
@Document(indexName = "post",shards = 1, replicas = 1)//一分片,一副本
public class Post {
    @Id
    @TableId(value = "id",type = IdType.AUTO)//设置自增主键后,保存操作之后,对象自动获得主键ID
    int id;
    @Field(type = FieldType.Text, analyzer = "ik_max_word")
    String name;
    int writter;
    int visible;
    @Field(type = FieldType.Text, analyzer = "ik_max_word")
    String content;
    @Field(type = FieldType.Keyword,analyzer = "ik_max_word")
    int theme;
    Date time;
}
