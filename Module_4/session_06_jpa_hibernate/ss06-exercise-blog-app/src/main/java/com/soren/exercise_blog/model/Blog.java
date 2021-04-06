package com.soren.exercise_blog.model;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "blog")
public class Blog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title;
    private String category;

    @Column(columnDefinition = "blob")
    private String content;

    @Column(columnDefinition = "datetime")
    private String postDay;

    private String image;
    private String author;
    private String description;

    public Blog() {
    }

    public Blog(Integer id, String title, String category, String content,
                String postDay, String image, String author, String description) {
        this.id = id;
        this.title = title;
        this.category = category;
        this.content = content;
        this.postDay = postDay;
        this.image = image;
        this.author = author;
        this.description = description;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer blogId) {
        this.id = blogId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getPostDay() {
        return postDay;
    }

    public void setPostDay(String postDay) {
        this.postDay = postDay;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
