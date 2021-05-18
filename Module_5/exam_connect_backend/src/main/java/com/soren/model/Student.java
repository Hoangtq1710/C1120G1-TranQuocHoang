package com.soren.model;

import javax.persistence.*;

@Entity
@Table(name = "students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "student_id")
    private Integer studentId;

    @Column(name = "code", columnDefinition = "INTEGER NOT NULL")
    private Integer code;

    @Column(name = "name", columnDefinition = "VARCHAR(45) NOT NULL")
    private String name;


    @ManyToOne
    @JoinColumn(name = "groupId", referencedColumnName = "group_id", nullable = false)
    private Group group;

    @Column(name = "subject" , columnDefinition = "VARCHAR(45)")
    private String subject;

    @ManyToOne
    @JoinColumn(name = "teacherId", referencedColumnName = "teacher_id", nullable = false)
    private Teacher teacher;

    @Column(name = "email")
    private String email;

    @Column(name = "phone")
    private String phone;

    public Student() {
    }

    public Student(Integer studentId, Integer code, String name, Group group,
                   String subject, Teacher teacher, String email, String phone) {
        this.studentId = studentId;
        this.code = code;
        this.name = name;
        this.group = group;
        this.subject = subject;
        this.teacher = teacher;
        this.email = email;
        this.phone = phone;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
