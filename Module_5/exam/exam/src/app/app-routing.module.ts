import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {ListStudentComponent} from './student/list-student/list-student.component';
import {EditStudentComponent} from './student/edit-student/edit-student.component';
import {DeleteStudentComponent} from './student/delete-student/delete-student.component';
import {AddStudentComponent} from './student/add-student/add-student.component';
import {ViewStudentComponent} from './student/view-student/view-student.component';


const routes: Routes = [
  {
    path:'', redirectTo:'student', pathMatch:'full'
  },
  {
    path:'student', component: ListStudentComponent
  },
  {
    path:'student/add', component: AddStudentComponent
  },
  {
    path:'student/view/:id', component: ViewStudentComponent
  },
  {
    path:'student/edit/:id', component: EditStudentComponent
  },
  {
    path:'student/delete/:id', component: DeleteStudentComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
