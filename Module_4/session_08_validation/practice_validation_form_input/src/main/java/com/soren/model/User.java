package com.soren.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty
    @Size(min = 5, max = 30, message = "Từ 5 - 30 kí tự nghe chưa óc chó này")
    private String name;

    @Min(value = 18, message = "Mấy thằng nhóc, chưa đủ tuổi")
    private Integer age;

    public User() {
    }

    public User(Integer id,
                @NotEmpty @Size(min = 5, max = 30) String name,
                @Min(18) Integer age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
