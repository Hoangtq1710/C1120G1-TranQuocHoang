package model;

import java.sql.Date;

public class Contract {
    private int contractId;
    private String payment;
    private Date startDate;
    private Date endDate;
    private String address;
    private Product product;
    private Employee employee;
    private Customer customer;

    public Contract(int contractId, String payment, Date startDate, Date endDate, String address, Product product, Employee employee, Customer customer) {
        this.contractId = contractId;
        this.payment = payment;
        this.startDate = startDate;
        this.endDate = endDate;
        this.address = address;
        this.product = product;
        this.employee = employee;
        this.customer = customer;
    }

    public int getContractId() {
        return contractId;
    }

    public void setContractId(int contractId) {
        this.contractId = contractId;
    }

    public String getPayment() {
        return payment;
    }

    public void setPayment(String payment) {
        this.payment = payment;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
