package com.soren.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "customers")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id", columnDefinition = "INTEGER NOT NULL")
    private Integer customerId;

    @Column(name = "customer_name", columnDefinition = "VARCHAR(45) NOT NULL")
    private String customerName;

    @Column(name = "phone", columnDefinition = "VARCHAR(45) NOT NULL")
    private String phone;

    @Column(name = "email", columnDefinition = "VARCHAR(45) NOT NULL")
    private String email;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    private Set<Transaction> transactionSet;

}
