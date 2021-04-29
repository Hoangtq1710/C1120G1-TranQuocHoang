package com.soren.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "product_type")
public class ProductType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_type_id")
    private Integer productTypeId;

    @Column(name = "product_type_name", columnDefinition = "VARCHAR(45) NOT NULL")
    private String productTypeName;

    @OneToMany(mappedBy = "productType", cascade = CascadeType.ALL)
    private Set<Product> productSet;

    public ProductType() {
    }

    public ProductType(Integer productTypeId, String productTypeName, Set<Product> productSet) {
        this.productTypeId = productTypeId;
        this.productTypeName = productTypeName;
        this.productSet = productSet;
    }

    public Integer getProductTypeId() {
        return productTypeId;
    }

    public void setProductTypeId(Integer productTypeId) {
        this.productTypeId = productTypeId;
    }

    public String getProductTypeName() {
        return productTypeName;
    }

    public void setProductTypeName(String productTypeName) {
        this.productTypeName = productTypeName;
    }

    public Set<Product> getProductSet() {
        return productSet;
    }

    public void setProductSet(Set<Product> productSet) {
        this.productSet = productSet;
    }
}
