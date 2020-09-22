package com.example.checkknowledge.service;

import com.example.checkknowledge.dao.PostDao;
import com.example.checkknowledge.model.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    private final PostDao postDao;
@Autowired
    public PostService(@Qualifier("orign") PostDao postDao) {
        this.postDao = postDao;
    }


    public List<Post> getData(){
        return postDao.getData();
    }

    public int insertPost(Post post){
    return postDao.insertPost(post);
    }
    public Post showPostById(String id){
    return postDao.showPostById(id);

    };
    public void DeletePost(String id){
         postDao.DeletePost(id);
    };
    public int updatePost(String id , Post post){
        return postDao.updatePost(id,post);
    }
}
