package com.lrdhappy.forum;

import com.lrdhappy.forum.bean.Post;
import com.lrdhappy.forum.dao.PostDao;
import com.lrdhappy.forum.service.impl.PostService;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.query.TermQueryBuilder;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.data.elasticsearch.core.mapping.IndexCoordinates;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;


/**
 * @author lrd
 * @date 2023-01-31 16:10
 */
@SpringBootTest
public class ElasticsearchConnectTest {
    @Autowired
    private ElasticsearchRestTemplate elasticsearchRestTemplate;
    @Autowired
    PostService postService;
    @Autowired
    PostDao postDao;
    @Test
    public void createIndex(){
        System.out.println("创建索引");
    }
    @Test
    public void deleteIndex(){
        boolean flg = elasticsearchRestTemplate.deleteIndex(Post.class);
        System.out.println("删除索引 = " + flg);
    }
    @Test
    public void initPost(){
        List<Post> allPost = postService.getAllPost();
        postDao.saveAll(allPost);
    }
    @Test
    public void searchTest(){
        Iterable<Post> posts = postDao.findByContentOrName("大学","有意思");
        System.out.println(1);
        for(Post tmp:posts){
            System.out.println(tmp);
        }
    }
}



