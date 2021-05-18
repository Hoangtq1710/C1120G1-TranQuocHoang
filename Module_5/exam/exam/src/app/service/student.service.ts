import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Student} from '../model/Student';
import {Group} from '../model/Group';
import {Teacher} from '../model/Teacher';

@Injectable({
  providedIn: 'root'
})

export class StudentService {

  httpOptions:any;

  private API_URL_STUDENT:string = "http://localhost:8080/student";
  private API_URL_GROUP:string = "http://localhost:8080/group";
  private API_URL_TEACHER:string = "http://localhost:8080/teacher";

  constructor(private httpClient: HttpClient) {
    this.httpOptions = {
      headers: new HttpHeaders({
        'Content-Type': 'application/json'}),
        'Access-Control-Allow-Origin': 'http://localhost:4200',
        'Access-Control-Allow-Methods': 'GET,PUT,POST,DELETE,PATCH,OPTIONS',
        'Access-Control-Allow-Credentials': "true"
    };
  }

  getListStudent():Observable<Student[]>{
    return this.httpClient.get<Student[]>(this.API_URL_STUDENT+"/list");
  }

  getListGroup():Observable<Group[]>{
    return this.httpClient.get<Group[]>(this.API_URL_GROUP);
  }

  getListTeacher():Observable<Teacher[]>{
    return this.httpClient.get<Teacher[]>(this.API_URL_TEACHER);
  }

  getStudentById(id:number):Observable<Student>{
    return this.httpClient.get<Student>(`${this.API_URL_STUDENT}/view/${id}`);
  }

  save(student: Student):Observable<Student> {
    return this.httpClient.post<Student>(`${this.API_URL_STUDENT}/add`, student);
  }

  updateStudentById(student: Student, id: number):Observable<Student> {
    return this.httpClient.put<Student>(`${this.API_URL_STUDENT}/edit/${id}`, student);
  }

  deleteStudentById(id: number):Observable<Student> {
    return this.httpClient.delete<Student>(`${this.API_URL_STUDENT}/delete/${id}`);
  }

  fullSearch(fullSearch: string):Observable<Student[]> {
    return this.httpClient.get<Student[]>(this.API_URL_STUDENT+"?q="+fullSearch);
  }
}
