import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {ListProductComponent} from './product/list-product/list-product.component';
import {AddProductComponent} from './product/add-product/add-product.component';
import {ViewProductComponent} from './product/view-product/view-product.component';
import {EditProductComponent} from './product/edit-product/edit-product.component';


const routes: Routes = [
  { path: "list", component: ListProductComponent },
  { path: "list/add", component: AddProductComponent },
  { path: "list/view/:id", component: ViewProductComponent },
  { path: "list/edit/:id", component: EditProductComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
