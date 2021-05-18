package com.soren.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "teachers")
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "teacher_id")
    private Integer teacherId;

    @Column(name = "teacher_name", columnDefinition = "VARCHAR(45) NOT NULL")
    private String teacherName;

    @JsonBackReference
    @OneToMany(mappedBy = "teacher",cascade = CascadeType.ALL)
    private Set<Student> studentSet;

    public Teacher() {
    }

    public Teacher(Integer teacherId, String teacherName, Set<Student> studentSet) {
        this.teacherId = teacherId;
        this.teacherName = teacherName;
        this.studentSet = studentSet;
    }

    public Integer getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Integer teacherId) {
        this.teacherId = teacherId;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public Set<Student> getStudentSet() {
        return studentSet;
    }

    public void setStudentSet(Set<Student> studentSet) {
        this.studentSet = studentSet;
    }
}
