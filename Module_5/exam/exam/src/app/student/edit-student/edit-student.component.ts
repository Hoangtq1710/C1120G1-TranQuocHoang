import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {Student} from '../../model/Student';
import {ActivatedRoute, Router} from '@angular/router';
import {StudentService} from '../../service/student.service';
import {Group} from '../../model/Group';
import {Teacher} from '../../model/Teacher';

@Component({
  selector: 'app-edit-student',
  templateUrl: './edit-student.component.html',
  styleUrls: ['./edit-student.component.css']
})
export class EditStudentComponent implements OnInit {

  form:FormGroup;
  student:Student;
  listGroup: Group[] = [];
  listTeacher: Teacher[] = [];
  id:number;

  constructor(
    private formBuilder:FormBuilder,
    private studentService:StudentService,
    private activatedRoute:ActivatedRoute,
    private router:Router
  ) { }

  ngOnInit(): void {

    this.studentService.getListGroup().subscribe(data => {
      this.listGroup = data;
    }, error => {
      console.log("get " + error + " at getListGroup on EditStudentComponent");
    })

    this.studentService.getListTeacher().subscribe(data => {
      this.listTeacher = data;
    }, error => {
      console.log("get " + error + " at getListTeacher on EditStudentComponent");
    })

    let id:number = this.activatedRoute.snapshot.params['id'];
    this.id = id;

    this.studentService.getStudentById(id).subscribe(data => {
      this.initForm();
      this.form.patchValue(data);

      this.form.get("group").setValue(data["group"])
      this.form.get("teacher").setValue(data["teacher"])

      this.student = data;
    }, error => {
      console.log("get "+error+" at getStudentById on EditStudentComponent");
    })
  }

  initForm() {
    this.form = this.formBuilder.group({
      code: ['', [Validators.required]],
      name: ['', [Validators.required, Validators.pattern('^[a-zA-Z0-9 ]+$')]],
      group: ['', [Validators.required]],
      subject: ['', [Validators.required,]],
      teacher: ['', [Validators.required]],
      email: ['', [Validators.required, Validators.email]],
      phone: ['', [Validators.required, Validators.pattern('^[\\d]{10,12}$')]]
    });
  }

  submitForm(form: FormGroup) {
    let student: Student = form.value;
    console.log(form.value['group'].toString())
    this.studentService.updateStudentById(student, this.id).subscribe(data => {
      console.log("Success "+data);
      this.backToList();
    });
  }

  backToList() {
    this.router.navigateByUrl("student");
  }
}
