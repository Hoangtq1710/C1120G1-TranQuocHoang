package com.soren.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Integer productId;

    @Column(name = "product_name", columnDefinition = "VARCHAR(45) NOT NULL")
    private String productName;

    @Column(name = "cost", columnDefinition = "DOUBLE")
    private String cost;

    @Column(name = "status", columnDefinition = "VARCHAR(45) NOT NULL")
    private String status;

    @ManyToOne
    @JoinColumn(name = "product_type_id", nullable = false)
    private ProductType productType;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    private Set<Contract> contractSet;

    public Product() {
    }

    public Product(Integer productId, String productName,
                   String cost, String status, ProductType productType, Set<Contract> contractSet) {
        this.productId = productId;
        this.productName = productName;
        this.cost = cost;
        this.status = status;
        this.productType = productType;
        this.contractSet = contractSet;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public ProductType getProductType() {
        return productType;
    }

    public void setProductType(ProductType productType) {
        this.productType = productType;
    }

    public Set<Contract> getContractSet() {
        return contractSet;
    }

    public void setContractSet(Set<Contract> contractSet) {
        this.contractSet = contractSet;
    }
}
