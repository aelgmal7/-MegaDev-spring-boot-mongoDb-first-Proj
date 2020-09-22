package com.example.checkknowledge.dao;

import com.example.checkknowledge.database.PostRepo;
import com.example.checkknowledge.model.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository("orign")
public class PostAccessDataService implements PostDao{

    private PostRepo postRepo;
    private List<Post> data= new ArrayList<>(
            Arrays.asList(
                    new Post("first","ahmed","dsd"),
                    new Post("second","mohamed","dsd"),
                    new Post("third","yasser","dsd"),
                    new Post("dsad","dasd","dsd")
            )
    );
    @Autowired
    public PostAccessDataService(PostRepo postRepo) {
        this.postRepo = postRepo;
    }

    public int insertPost(Post post){
        postRepo.save(new Post(post.getId(),post.getTitle(),post.getDes()));
        return 1;
    }
    public List<Post> getData() {
        return postRepo.findAll();
    }
    public Post showPostById(String id){
        return  postRepo.findById(id).get();
    }
    public void DeletePost(String id){

        postRepo.deleteById(id);
    }
    public int updatePost(String id , Post post){
//        return showPostById(id).map(post1 -> {
//            int indexOfPostToUpdate=getData().indexOf(post1);
//            if (indexOfPostToUpdate>=0){
//                getData().set(indexOfPostToUpdate,new Post(id,post.getTitle(),post.getDes()));
//                return 1;
//            }
//            return 0;
//
//        }).orElse(0);
        int indexOfUpdatedPost=postRepo.findAll().indexOf(id);
        if (indexOfUpdatedPost>=0) {
            postRepo.findAll().set(indexOfUpdatedPost,post);
            return 1;
        }
        return 0;

    }
}
