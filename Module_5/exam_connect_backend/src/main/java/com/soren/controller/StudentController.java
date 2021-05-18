package com.soren.controller;

import com.soren.model.Group;
import com.soren.model.Student;
import com.soren.model.Teacher;
import com.soren.service.GroupService;
import com.soren.service.StudentService;
import com.soren.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(value = "*", allowedHeaders = "*")
public class StudentController {

    @Autowired
    private StudentService studentService;
    @Autowired
    private GroupService groupService;
    @Autowired
    private TeacherService teacherService;

    @GetMapping("/group")
    public List<Group> getListGroup(){
        return groupService.findAll();
    }

    @GetMapping("/teacher")
    public List<Teacher> getListTeacher(){
        return teacherService.findAll();
    }

    @GetMapping("/student/list")
    public List<Student> getListStudent(){
        return studentService.findAll();
    }

    @GetMapping("/student/view/{studentId}")
    public Student getStudentById(@PathVariable(name = "studentId") Integer id){
        return studentService.findById(id);
    }

    @PostMapping("/student/add")
    public void addStudent(@RequestBody Student student){
        studentService.save(student);
    }

    @PutMapping("/student/edit/{studentId}")
    public void updateStudent(@RequestBody Student student, @PathVariable(name = "studentId") Integer id){
        student.setStudentId(id);
        studentService.save(student);
    }

    @DeleteMapping("/student/delete/{studentId}")
    public void deleteStudentById(@PathVariable(name = "studentId") Integer id){
        studentService.deleteById(id);
    }

    @GetMapping("/student")
    public List<Student> fullSearch(@RequestParam(name = "q") String q){
        return studentService.fullSearch("%"+q+"%");
    }
}
