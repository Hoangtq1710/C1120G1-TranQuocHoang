package com.soren.model;

import javax.persistence.*;

@Entity
@Table( name = "Role",
        uniqueConstraints = {
        @UniqueConstraint(name = "ROLE_UK", columnNames = "Role_Name")
        })
public class Role {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Integer id;

        @Column(name = "Role_Name")
        private String roleName;
}
