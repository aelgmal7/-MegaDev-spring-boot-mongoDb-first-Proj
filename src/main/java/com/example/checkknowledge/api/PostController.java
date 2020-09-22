package com.example.checkknowledge.api;

import com.example.checkknowledge.database.PostRepo;
import com.example.checkknowledge.model.Post;
import com.example.checkknowledge.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
// to avoid CORS error
@CrossOrigin(origins = "*")
@RequestMapping(value = "/api/v1/")
public class PostController {
    @Autowired
    public PostRepo postRepo;
    private PostService postService;
    @Autowired
    public PostController(PostRepo postRepo, PostService postService) {
        this.postRepo = postRepo;
        this.postService = postService;
    }
    //Post method
    @CrossOrigin
    @PostMapping("/add")
    public Post savePost(@RequestBody Post post){
         postService.insertPost(post);
        return post;
    }
    // Get method to collect all data
    @CrossOrigin
    @GetMapping("/show")
    public List<Post> showPosts(){
        return postService.getData();
    }

    // Get method to collect specific post by id

    @GetMapping(path = "show/{id}")
    public Post getPostById(@PathVariable("id") String id){
        return postService.showPostById(id);
    }

    // Delete method to remove post from database

@CrossOrigin
@DeleteMapping(path = "/posts/{id}")
    public void DeletePost(@PathVariable("id")String id){

       postService.DeletePost(id);
    };
    // update method to modify post data by passing id and changes , but didn't use in vue
    @PutMapping(path = "/posts/{id}")
    public void updatePost(@PathVariable("id") String id,@RequestBody Post post){
        postService.updatePost(id,post);

    }
}
