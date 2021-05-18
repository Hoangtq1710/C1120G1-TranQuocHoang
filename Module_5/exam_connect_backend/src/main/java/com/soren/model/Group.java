package com.soren.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "AppGroup")
public class Group {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "group_id")
    private Integer groupId;

    @Column(name = "group_name", columnDefinition = "VARCHAR(45) NOT NULL")
    private String groupName;

    @JsonBackReference
    @OneToMany(mappedBy = "group",cascade = CascadeType.ALL)
    private Set<Student> studentSet;

    public Group() {
    }

    public Group(Integer groupId, String groupName, Set<Student> studentSet) {
        this.groupId = groupId;
        this.groupName = groupName;
        this.studentSet = studentSet;
    }

    public Integer getGroupId() {
        return groupId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public Set<Student> getStudentSet() {
        return studentSet;
    }

    public void setStudentSet(Set<Student> studentSet) {
        this.studentSet = studentSet;
    }
}
