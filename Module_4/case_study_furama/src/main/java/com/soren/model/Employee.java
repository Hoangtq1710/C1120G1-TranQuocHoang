package com.soren.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Pattern;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employee_id")
    private Integer employeeId;

    @Column(name = "employee_name", columnDefinition = "VARCHAR(45) NOT NULL")
    @NotNull
    private String employeeName;

    @Column(name = "employee_birthday", columnDefinition = "DATE")
    @PastOrPresent(message = "You picked a day in Future!")
    private String employeeBirthday;

    @Column(name = "employee_id_card", columnDefinition = "VARCHAR(45) UNIQUE NOT NULL")
    @NotNull
    @Pattern(regexp = "^[\\d]{9}|[\\d]{12}$",
            message = "Employee ID Card must contain 9 or 12 digits!\n Example : 205784694165")
    private String employeeIdCard;

    @Column(name = "employee_salary")
    @Pattern(regexp = "^[\\d]+(\\.[\\d]+)?$", message = "Salary must be positive! \nExample : 750 or 750.0")
    private double employeeSalary;

    @Column(name = "employee_phone", columnDefinition = "VARCHAR(45)")
    @Pattern(regexp = "^(091|090|\\(84\\)\\+90|\\(84\\)\\+91)[\\d]{7}$",
            message = "Phone start with 090 or 091 or (84)+90 or (84)+91 \nExample : 0905456121 or (84)+912365478")
    private String employeePhone;

    @Column(name = "employee_email", columnDefinition = "VARCHAR(45)")
    @Pattern(regexp = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\\.[a-zA-Z0-9-]+)*$",
            message = "Email must be in abc@abc.abc format!")
    private String employeeEmail;

    @Column(name = "employee_address", columnDefinition = "VARCHAR(255)")
    private String employeeAddress;

    @ManyToOne
    @JoinColumn(name = "position_id", nullable = false)
    private Position position;

    @ManyToOne
    @JoinColumn(name = "education_degree_id", nullable = false)
    private EducationDegree educationDegree;

    @ManyToOne
    @JoinColumn(name = "division_id", nullable = false)
    private Division division;

    @OneToOne
    @JoinColumn(name = "User_Name", nullable = false)
    private User user;

    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL)
    private Set<Contract> contractSet;

}
