import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {Router} from '@angular/router';
import {StudentService} from '../../service/student.service';
import {Student} from '../../model/Student';
import {Group} from '../../model/Group';
import {Teacher} from '../../model/Teacher';

@Component({
  selector: 'app-add-student',
  templateUrl: './add-student.component.html',
  styleUrls: ['./add-student.component.css']
})
export class AddStudentComponent implements OnInit {
  form:FormGroup;
  listGroup: Group[] = [];
  listTeacher: Teacher[] = [];

  constructor(private formBuilder:FormBuilder,
              private studentService:StudentService,
              private router:Router) { }

  ngOnInit(): void {
    this.studentService.getListGroup().subscribe(data => {
      this.listGroup = data;
    }, error => {
      console.log("get "+error+" at getListGroup on AddStudentComponent");
    })

    this.studentService.getListTeacher().subscribe(data => {
      this.listTeacher = data;
    }, error => {
      console.log("get "+error+" at getListTeacher on AddStudentComponent");
    })

    this.initForm();

  }

  initForm() {
    this.form = this.formBuilder.group({
      code: ['', [Validators.required, Validators.pattern('^102[\\d]{6}$')]],
      name: ['', [Validators.required, Validators.pattern('^[a-zA-Z0-9 ]+$')]],
      group: ['', [Validators.required]],
      subject: ['', [Validators.required,]],
      teacher: ['', [Validators.required]],
      email: ['', [Validators.required, Validators.email]],
      phone: ['', [Validators.required, Validators.pattern('^[\\d]{10,12}$')]]
    });
  }

  backToList() {
    this.router.navigateByUrl("student");
  }

  submitForm(form: FormGroup) {
    let student:Student = form.value;
    console.log(student)
    this.studentService.save(student).subscribe(data => {
      console.log("Add Success "+data);
      this.backToList();
    }, error => {
      console.log("Add Fail "+error);
    })
  }
}
