package com.soren.model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Service {

    @Id
    @Column(name = "service_id", columnDefinition = "VARCHAR(45) NOT NULL")
    private String serviceId;

    @Column(name = "service_name", columnDefinition = "VARCHAR(45) NOT NULL")
    private String serviceName;

    @Column(name = "service_area", columnDefinition = "NOT NULL")
    private Integer serviceArea;

    @Column(name = "service_cost", columnDefinition = "NOT NULL")
    private double serviceCost;

    @Column(name = "service_max_people", columnDefinition = "NOT NULL")
    private Integer serviceMaxPeople;

    @Column(name = "standard_room", columnDefinition = "VARCHAR(45)")
    private String standardRoom;

    @Column(name = "description", columnDefinition = "VARCHAR(255)")
    private String description;

    @Column(name = "pool_area")
    private double poolArea;

    @Column(name = "number_of_floor")
    private int NumberOfFloor;

    @ManyToOne
    @JoinColumn(name = "rent_type_id", nullable = false)
    private RentType rentType;

    @ManyToOne
    @JoinColumn(name = "service_type_id", nullable = false)
    private ServiceType serviceType;

    @OneToMany(mappedBy = "service")
    private Set<Contract> contractSet;

    public Service() {
    }

    public Service(String serviceId, String serviceName, Integer serviceArea, double serviceCost,
                   Integer serviceMaxPeople, String standardRoom, String description, double poolArea,
                   int numberOfFloor, RentType rentType, ServiceType serviceType, Set<Contract> contractSet) {
        this.serviceId = serviceId;
        this.serviceName = serviceName;
        this.serviceArea = serviceArea;
        this.serviceCost = serviceCost;
        this.serviceMaxPeople = serviceMaxPeople;
        this.standardRoom = standardRoom;
        this.description = description;
        this.poolArea = poolArea;
        this.NumberOfFloor = numberOfFloor;
        this.rentType = rentType;
        this.serviceType = serviceType;
        this.contractSet = contractSet;
    }

    public String getServiceId() {
        return serviceId;
    }

    public void setServiceId(String serviceId) {
        this.serviceId = serviceId;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public Integer getServiceArea() {
        return serviceArea;
    }

    public void setServiceArea(Integer serviceArea) {
        this.serviceArea = serviceArea;
    }

    public double getServiceCost() {
        return serviceCost;
    }

    public void setServiceCost(double serviceCost) {
        this.serviceCost = serviceCost;
    }

    public Integer getServiceMaxPeople() {
        return serviceMaxPeople;
    }

    public void setServiceMaxPeople(Integer serviceMaxPeople) {
        this.serviceMaxPeople = serviceMaxPeople;
    }

    public String getStandardRoom() {
        return standardRoom;
    }

    public void setStandardRoom(String standardRoom) {
        this.standardRoom = standardRoom;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPoolArea() {
        return poolArea;
    }

    public void setPoolArea(double poolArea) {
        this.poolArea = poolArea;
    }

    public int getNumberOfFloor() {
        return NumberOfFloor;
    }

    public void setNumberOfFloor(int numberOfFloor) {
        NumberOfFloor = numberOfFloor;
    }

    public RentType getRentType() {
        return rentType;
    }

    public void setRentType(RentType rentType) {
        this.rentType = rentType;
    }

    public ServiceType getServiceType() {
        return serviceType;
    }

    public void setServiceType(ServiceType serviceType) {
        this.serviceType = serviceType;
    }

    public Set<Contract> getContractSet() {
        return contractSet;
    }

    public void setContractSet(Set<Contract> contractSet) {
        this.contractSet = contractSet;
    }
}
