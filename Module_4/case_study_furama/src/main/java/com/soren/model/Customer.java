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
public class Customer {

    @Id
    @Column(name = "customer_id", columnDefinition = "VARCHAR(45) NOT NULL")
    private String customerId;

    @Column(name = "customer_name", columnDefinition = "VARCHAR(45) NOT NULL")
    private String customerName;

    @Column(name = "customer_birthday", columnDefinition = "DATE")
    private String customerBirthday;

    @Column(name = "customer_gender")
    private boolean customerGender;

    @Column(name = "customer_id_card", columnDefinition = "VARCHAR(45) NOT NULL UNIQUE")
    private String customerIdCard;

    @Column(name = "customer_phone", columnDefinition = "VARCHAR(45)")
    private String customerPhone;

    @Column(name = "customer_email", columnDefinition = "VARCHAR(45)")
    private String customerEmail;

    @Column(name = "customer_address", columnDefinition = "VARCHAR(255)")
    private String customerAddress;

    @ManyToOne
    @JoinColumn(name = "customer_type_id", nullable = false)
    private CustomerType customerType;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    private Set<Contract> contractSet;

}
