package com.soren.repository;

import com.soren.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

    @Query(value =  "select * from students " +
                    "inner join app_group on students.group_id = app_group.group_id " +
                    "inner join teachers on students.teacher_id = teachers.teacher_id " +
                    "where concat(`code`, email, `name`, phone, `subject`, group_name, teacher_name) like ?1",
            nativeQuery = true)
    List<Student> fullSearch(String q);
}
