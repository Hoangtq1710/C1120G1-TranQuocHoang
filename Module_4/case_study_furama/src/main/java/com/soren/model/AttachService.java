package com.soren.model;

import javax.persistence.*;

@Entity
public class AttachService {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "attach_service_id")
    private Integer attachServiceId;

    @Column(name = "attach_service_name", columnDefinition = "VARCHAR(45) NOT NULL")
    private String attachServiceName;

    @Column(name = "attach_service_cost", nullable = false)
    private double attachServiceCost;

    @Column(name = "attach_service_unit", columnDefinition = "VARCHAR(45) NOT NULL")
    private String attachServiceUnit;

    @Column(name = "attach_service_status", columnDefinition = "VARCHAR(255) NOT NULL")
    private String attachServiceStatus;

    public AttachService() {
    }

    public AttachService(Integer attachServiceId, String attachServiceName, double attachServiceCost, String attachServiceUnit, String attachServiceStatus) {
        this.attachServiceId = attachServiceId;
        this.attachServiceName = attachServiceName;
        this.attachServiceCost = attachServiceCost;
        this.attachServiceUnit = attachServiceUnit;
        this.attachServiceStatus = attachServiceStatus;
    }

    public Integer getAttachServiceId() {
        return attachServiceId;
    }

    public void setAttachServiceId(Integer attachServiceId) {
        this.attachServiceId = attachServiceId;
    }

    public String getAttachServiceName() {
        return attachServiceName;
    }

    public void setAttachServiceName(String attachServiceName) {
        this.attachServiceName = attachServiceName;
    }

    public double getAttachServiceCost() {
        return attachServiceCost;
    }

    public void setAttachServiceCost(double attachServiceCost) {
        this.attachServiceCost = attachServiceCost;
    }

    public String getAttachServiceUnit() {
        return attachServiceUnit;
    }

    public void setAttachServiceUnit(String attachServiceUnit) {
        this.attachServiceUnit = attachServiceUnit;
    }

    public String getAttachServiceStatus() {
        return attachServiceStatus;
    }

    public void setAttachServiceStatus(String attachServiceStatus) {
        this.attachServiceStatus = attachServiceStatus;
    }
}
