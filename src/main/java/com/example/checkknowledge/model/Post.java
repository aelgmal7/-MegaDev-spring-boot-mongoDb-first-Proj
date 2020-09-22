package com.example.checkknowledge.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

// post model
@Document("sportsNews")
public class Post {
    @Id
    private String id;
    private String title;
    private String des;

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDes() {
        return des;
    }

    @Override
    public String toString() {
        return "Post{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", des='" + des + '\'' +
                '}';
    }

    public Post(String id, String title, String des) {
        this.id = id;
        this.title = title;
        this.des = des;
    }
}
