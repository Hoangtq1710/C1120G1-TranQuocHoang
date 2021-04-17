package com.soren.model;

import javax.persistence.*;

@Entity
@Table( name = "User_Role",
        uniqueConstraints = {
        @UniqueConstraint(name = "USER_ROLE_UK", columnNames = {"User_Id", "Role_Id"})
        })
public class UserRole {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "User_Id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "Role_Id")
    private Role role;
}
