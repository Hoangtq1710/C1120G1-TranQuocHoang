package com.soren.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
@Table(name = "blog")
public class Blog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "categories", nullable = false, referencedColumnName = "category_id")
    private Category category;

    @Column(columnDefinition = "text(10000)")
    private String content;

    public Blog() {
    }

    public Blog(Integer id, String title, Category category, String content) {
        this.id = id;
        this.title = title;
        this.category = category;
        this.content = content;
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


}
