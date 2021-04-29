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
@Table(name = "transaction_types")
public class TransactionType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "transaction_type_id", columnDefinition = "INTEGER")
    private Integer transactionTypeId;

    @Column(name = "transaction_type_name", columnDefinition = "VARCHAR(45) NOT NULL")
    private String transactionTypeName;

    @OneToMany(mappedBy = "transactionType", cascade = CascadeType.ALL)
    private Set<Transaction> transactionSet;


}
