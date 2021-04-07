package com.soren.model;

import org.hibernate.validator.constraints.Range;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@Table(name = "users")
@Component
public class User implements Validator {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank
    @Size(min = 5, max = 45, message = "Length of First Name from 5 to 45")
    private String firstName;

    @NotBlank
    @Size(min = 5, max = 45, message = "Length of Last Name from 5 to 45")
    private String lastName;

    @NotNull
    @Range(min = 18, max = 120, message = "Age must be greater than 18 and lower than 120")
    private Integer age;

    private String phone;

    @Pattern(regexp = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\\.[a-zA-Z0-9-]+)*$")
    private String email;

    public User() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return User.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object object, Errors errors) {
        User user = (User) object;
        String phone = user.getPhone();
        ValidationUtils.rejectIfEmpty(errors,"phone","phone.empty");
        if (phone.length() > 11 || phone.length() < 10){
            errors.rejectValue("phone", "phone.length");
        }
        if (!phone.startsWith("0")){
            errors.rejectValue("phone","phone.startWith");
        }
        if (!phone.matches("^$|[\\d]*$")){
            errors.rejectValue("phone", "phone.matches");
        }
    }
}
