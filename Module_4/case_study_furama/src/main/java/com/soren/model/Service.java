package com.soren.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Service {

    @Id
    @Column(name = "service_id", columnDefinition = "VARCHAR(45) NOT NULL")
    @Pattern(regexp = "^DV-[\\d]{4}$", message = "Service ID must be in DV-XXXX format !\nExample : DV-0306")
    private String serviceId;

    @Column(name = "service_name", columnDefinition = "VARCHAR(45) NOT NULL")
    @NotNull(message = "Service Name can not be NULL")
    private String serviceName;

    @Column(name = "service_area", nullable = false)
    @Min(value = 1, message = "Service Area must be positive! Example : 50")
    private Integer serviceArea;

    @Column(name = "service_cost", nullable = false)
    @DecimalMin(value = "1.0", message = "Cost must be positive! Example : 350 or 380.5")
    private double serviceCost;

    @Column(name = "service_max_people", nullable = false)
    @Min(value = 1, message = "Max People must be equal or greater than 1! Example : 6")
    private Integer serviceMaxPeople;

    @Column(name = "standard_room", columnDefinition = "VARCHAR(45)")
    private String standardRoom;

    @Column(name = "description", columnDefinition = "VARCHAR(255)")
    private String description;

    @Column(name = "pool_area")
    @DecimalMin(value = "1.0", message = "Pool Area must be greater than 1! Example : 45 or 45.6")
    private double poolArea;

    @Column(name = "number_of_floor")
    @Min(value = 0, message = "Number Of Floor must be positive! Example : 6")
    private int NumberOfFloor;

    @ManyToOne
    @JoinColumn(name = "rent_type_id", nullable = false)
    private RentType rentType;

    @ManyToOne
    @JoinColumn(name = "service_type_id", nullable = false)
    private ServiceType serviceType;

    @OneToMany(mappedBy = "service", cascade = CascadeType.ALL)
    private Set<Contract> contractSet;

}
