package com.soren.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "transactions")
public class Transaction implements Validator {

    @Id
    @Column(name = "transaction_id", columnDefinition = "VARCHAR(45) NOT NULL")
    @Pattern(regexp = "^MGD-[\\d]{4}$", message = "Transaction ID must be in format MGD-XXXX \nExample : MGD-1451" )
    private String transactionId;

    @Column(name = "date", columnDefinition = "DATE")
    private String date;

    @Column(name = "cost", columnDefinition = "DOUBLE")
    @Pattern(regexp = "^[\\d]+$", message = "Cost must be a Integer. Example : 600000")
    private String cost;

    @Column(name = "area", columnDefinition = "DOUBLE")
    @Pattern(regexp = "^[\\d]+$", message = "Area must be a Integer. Example : 120")
    private String area;

    @ManyToOne
    @JoinColumn(name = "transaction_type_id", nullable = false)
    private TransactionType transactionType;

    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;

    @Override
    public boolean supports(Class<?> clazz) {
        return Transaction.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object object, Errors errors) {
        Transaction transaction = (Transaction) object;
        String cost = transaction.getCost();
        String area = transaction.getArea();
        String transactionId = transaction.getTransactionId();

        try {
            Date date = new SimpleDateFormat("yyyy-MM-dd").parse(transaction.getDate());
            Date currentDate = new Date();

            if (date.before(currentDate)){
                errors.rejectValue("date","transaction.date.reject");
            }
            try {
                double tranCost = Double.parseDouble(cost);
                if (tranCost < 500000) {
                    errors.rejectValue("cost", "transaction.cost.under500k");
                }
            } catch (NumberFormatException e){
                System.err.println("COST INVALID");
                errors.rejectValue("cost", "transaction.cost.notInteger");
            }
            try {
                double tranArea = Double.parseDouble(area);
                if (tranArea < 20){
                    errors.rejectValue("area", "transaction.area.under20");
                }
            } catch (NumberFormatException e){
                System.err.println("AREA INVALID");
                errors.rejectValue("cost", "transaction.area.notInteger");
            }

            if (transactionId.equals("")){
                errors.rejectValue("transactionId", "transaction.id.null");
            }
            if (transactionId.equals("")){
                errors.rejectValue("area", "transaction.area.null");
            }
            if (transactionId.equals("")){
                errors.rejectValue("cost", "transaction.cost.null");
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
