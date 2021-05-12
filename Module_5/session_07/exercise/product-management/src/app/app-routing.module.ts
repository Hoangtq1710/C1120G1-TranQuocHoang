import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {ListProductComponent} from './product/list-product/list-product.component';
import {AddProductComponent} from './product/add-product/add-product.component';
import {ViewProductComponent} from './product/view-product/view-product.component';
import {EditProductComponent} from './product/edit-product/edit-product.component';
import {DeleteProductComponent} from './product/delete-product/delete-product.component';


const routes: Routes = [
  {
    path: 'product',
    component: ListProductComponent
  },
  {
    path: 'product/add',
    component: AddProductComponent
  },
  {
    path: 'product/view/:id',
    component: ViewProductComponent
  },
  {
    path: 'product/edit/:id',
    component: EditProductComponent
  },
  {
    path: 'product/delete/:id',
    component: DeleteProductComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
