package com.soren.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table( name = "User",
        uniqueConstraints = {
        @UniqueConstraint(name = "USER_UK", columnNames = "User_Name")
        })
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userId;

    @Column(name = "User_Name")
    private String username;

    private String password;

    private boolean enabled;


}
