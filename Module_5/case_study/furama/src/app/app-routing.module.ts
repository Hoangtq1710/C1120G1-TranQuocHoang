import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {ListCustomerComponent} from "./customer/list-customer/list-customer.component";
import {AddCustomerComponent} from "./customer/add-customer/add-customer.component";
import {ViewCustomerComponent} from "./customer/view-customer/view-customer.component";
import {EditCustomerComponent} from "./customer/edit-customer/edit-customer.component";
import {DeleteCustomerComponent} from "./customer/delete-customer/delete-customer.component";


const routes: Routes = [
  {
    path:'', redirectTo:'customer', pathMatch:'full'
  },
  {
    path:'customer', component: ListCustomerComponent
  },
  {
    path:'customer/add', component: AddCustomerComponent
  },
  {
    path:'customer/view/:id', component:ViewCustomerComponent
  },
  {
    path:'customer/edit/:id', component: EditCustomerComponent
  },
  {
    path:'customer/delete/:id', component: DeleteCustomerComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
