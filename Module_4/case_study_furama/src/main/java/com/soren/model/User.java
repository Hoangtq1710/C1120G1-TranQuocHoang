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
    @Column(name = "User_Id")
    private Integer userId;

    @Column(name = "User_Name", columnDefinition = "VARCHAR(45) NOT NULL")
    private String username;

    @Column(name = "Password", columnDefinition = "VARCHAR(45) NOT NULL")
    private String password;

    @Column(name = "enabled", length = 1, columnDefinition = "BIT DEFAULT 1")
    private boolean enabled;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private Employee employee;

}
