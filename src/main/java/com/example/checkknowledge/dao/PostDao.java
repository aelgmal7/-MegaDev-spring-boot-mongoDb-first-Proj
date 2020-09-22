package com.example.checkknowledge.dao;

import com.example.checkknowledge.model.Post;

import java.util.List;

public interface PostDao {

     List<Post> getData();
    Post showPostById(String id);
     void DeletePost(String id);
     int updatePost(String id , Post post);
    int insertPost(Post post);
}
