package com.example.checkknowledge.database;

import com.example.checkknowledge.model.Post;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
//to connect with database
@Repository
public interface PostRepo extends MongoRepository<Post,String> {
}
