import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import {HttpClientModule} from '@angular/common/http';
import { StudentComponent } from './student/student.component';
import { ListStudentComponent } from './student/list-student/list-student.component';
import { EditStudentComponent } from './student/edit-student/edit-student.component';
import { DeleteStudentComponent } from './student/delete-student/delete-student.component';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import { AddStudentComponent } from './student/add-student/add-student.component';
import { ViewStudentComponent } from './student/view-student/view-student.component';

@NgModule({
  declarations: [
    AppComponent,
    StudentComponent,
    ListStudentComponent,
    EditStudentComponent,
    DeleteStudentComponent,
    AddStudentComponent,
    ViewStudentComponent
  ],
    imports: [
        BrowserModule,
        AppRoutingModule,
        HttpClientModule,
        ReactiveFormsModule,
        FormsModule
    ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
