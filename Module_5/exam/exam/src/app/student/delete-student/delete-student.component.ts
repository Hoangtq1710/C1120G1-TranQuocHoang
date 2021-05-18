import { Component, OnInit } from '@angular/core';
import {Student} from '../../model/Student';
import {ActivatedRoute, Router} from '@angular/router';
import {StudentService} from '../../service/student.service';

@Component({
  selector: 'app-delete-student',
  templateUrl: './delete-student.component.html',
  styleUrls: ['./delete-student.component.css']
})
export class DeleteStudentComponent implements OnInit {

  id:number;
  student: Student;

  constructor(private studentService:StudentService,
              private activatedRoute:ActivatedRoute,
              private router: Router) { }

  ngOnInit(): void {
    let id:number = this.activatedRoute.snapshot.params['id'];
    this.id = id;

    this.studentService.getStudentById(id).subscribe(data => {
      this.student = data;
    }, error => {
      console.log("get "+error+" at getStudentById on DeleteStudentComponent");
    })
  }

  backToList() {
    this.router.navigateByUrl("student");
  }

  deleteCustomer() {
    this.studentService.deleteStudentById(this.id).subscribe(data => {
      console.log("success delete "+data)
      this.backToList();
    })
  }
}
