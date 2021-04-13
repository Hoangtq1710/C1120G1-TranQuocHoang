package com.soren.model;

import javax.persistence.*;

@Entity
@Table(name = "blog")
public class Blog { //item

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title;

    @ManyToOne
    @JoinColumn(name = "categories", nullable = false, referencedColumnName = "category_id")
    private Category category;

    @Column(columnDefinition = "text(10000)")
    private String content;

    @Column(columnDefinition = "datetime")
    private String postDay;

    private String image;
    private String author;
    private String description;

    public Blog() {
    }

    public Blog(Integer id, String title, Category category, String content,
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

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
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
