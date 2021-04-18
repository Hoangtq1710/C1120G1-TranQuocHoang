package com.soren.model;

import javax.persistence.*;

@Entity
@Table( name = "User",
        uniqueConstraints = {
        @UniqueConstraint(name = "USER_UK", columnNames = "User_Name")
        })
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "User_Id")
    private Integer userId;

    @Column(name = "User_Name", columnDefinition = "VARCHAR(45) NOT NULL")
    private String username;

    @Column(name = "Password", columnDefinition = "VARCHAR(45) NOT NULL")
    private String password;

    @Column(name = "enabled", length = 1, columnDefinition = "BIT DEFAULT 1")
    private boolean enabled;

    public User() {
    }

    public User(Integer userId, String username, String password, boolean enabled) {
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.enabled = enabled;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
}
