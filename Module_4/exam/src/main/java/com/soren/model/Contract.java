package com.soren.model;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
@Table(name = "contract")
public class Contract implements Validator {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "contract_id")
    private Integer contractId;

    @Column(name = "date", columnDefinition = "DATE")
    private String date;

    @Column(name = "quantity", columnDefinition = "INTEGER")
    @Pattern(regexp = "^[\\d]+$", message = "Quantity must be a Integer number! \nExample : 5")
    private String quantity;

    @Column(name = "total", columnDefinition = "DOUBLE")
    private Double total;

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    public Contract() {
    }

    public Contract(Integer contractId, String date, String quantity, Double total, Product product) {
        this.contractId = contractId;
        this.date = date;
        this.quantity = quantity;
        this.total = total;
        this.product = product;
    }

    public Integer getContractId() {
        return contractId;
    }

    public void setContractId(Integer contractId) {
        this.contractId = contractId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return Contract.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object object, Errors errors) {
        Contract contract = (Contract) object;
        String quantity = contract.getQuantity();

        try {
            Date date = new SimpleDateFormat("yyyy-MM-dd").parse(contract.getDate());

            Date currentDate = new Date();

            if (date.before(currentDate)){
                errors.rejectValue("date", "con.date.after");
            }
            if (quantity.equals("")){
                errors.rejectValue("quantity", "con.qty.reject");
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }




    }
}
