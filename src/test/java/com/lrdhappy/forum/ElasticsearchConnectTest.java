package com.lrdhappy.forum;

import com.lrdhappy.forum.bean.Post;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.data.elasticsearch.core.mapping.IndexCoordinates;
import org.springframework.test.context.junit4.SpringRunner;


/**
 * @author lrd
 * @date 2023-01-31 16:10
 */
@SpringBootTest
public class ElasticsearchConnectTest {
    @Autowired
    private ElasticsearchRestTemplate elasticsearchRestTemplate;
    @Test
    public void createIndex(){
        System.out.println("创建索引");
    }
    @Test
    public void deleteIndex(){
        boolean flg = elasticsearchRestTemplate.deleteIndex(Post.class);
        System.out.println("删除索引 = " + flg);
    }
}
