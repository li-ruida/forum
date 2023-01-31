package com.lrdhappy.forum.dao;

import com.lrdhappy.forum.bean.Post;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

/**
 * @author lrd
 * @date 2023-01-31 16:20
 */
@Repository
public interface PostDao extends ElasticsearchRepository<Post, Integer> {
}
