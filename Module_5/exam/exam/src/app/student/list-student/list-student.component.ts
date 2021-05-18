import { Component, OnInit } from '@angular/core';
import {Student} from '../../model/Student';
import {StudentService} from '../../service/student.service';
import {Group} from '../../model/Group';
import {Teacher} from '../../model/Teacher';

@Component({
  selector: 'app-list-student',
  templateUrl: './list-student.component.html',
  styleUrls: ['./list-student.component.css']
})
export class ListStudentComponent implements OnInit {

  listStudent: Student[] = [];
  listGroup: Group[] = [];
  listTeacher: Teacher[] = [];

  fullSearch: string = '';

  constructor(private studentService:StudentService) { }

  ngOnInit(): void {
    this.studentService.getListGroup().subscribe(data => {
      this.listGroup = data;
    }, error => {
      console.log("get " + error + " at getListGroup on ListStudentComponent");
    })

    this.studentService.getListTeacher().subscribe(data => {
      this.listTeacher = data;
    }, error => {
      console.log("get " + error + " at getListTeacher on ListStudentComponent");
    })

    this.studentService.getListStudent().subscribe(data => {
      this.listStudent = data;
    }, error => {
      console.log("get " + error + " at getListStudent on ListStudentComponent");
    })
  }

  fullSearchMethod() {
    this.studentService.fullSearch(this.fullSearch).subscribe(data => {
      this.listStudent = data;
    }, error => {
      console.log("get " + error + " at fullSearch on ListStudentComponent");
    })
  }
}
