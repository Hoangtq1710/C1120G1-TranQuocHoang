import { Component, OnInit } from '@angular/core';
import {StudentService} from '../../service/student.service';
import {Student} from '../../model/Student';
import {ActivatedRoute, Router} from '@angular/router';

@Component({
  selector: 'app-view-student',
  templateUrl: './view-student.component.html',
  styleUrls: ['./view-student.component.css']
})
export class ViewStudentComponent implements OnInit {

  student:Student;

  constructor(private studentService:StudentService,
              private activatedRoute:ActivatedRoute,
              private router:Router) { }

  ngOnInit(): void {
    let id:number = this.activatedRoute.snapshot.params['id'];
    this.studentService.getStudentById(id).subscribe(data => {
     return this.student = data;
    }, error => {
      console.log("get "+error.message+" at getStudentById on ViewStudentComponent");
    })
  }

  backToList() {
    this.router.navigateByUrl("student");
  }
}
