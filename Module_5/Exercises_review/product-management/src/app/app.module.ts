import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';

import {AppComponent} from './app.component';
import {ProductComponent} from './product/product.component';
import {ListProductComponent} from './product/list-product/list-product.component';
import {AddProductComponent} from './product/add-product/add-product.component';
import {ViewProductComponent} from './product/view-product/view-product.component';
import {ReactiveFormsModule} from '@angular/forms';
import {EditProductComponent} from './product/edit-product/edit-product.component';
import {AppRoutingModule} from './app-routing.module';
import {DeleteProductComponent } from './product/delete-product/delete-product.component';
import {HttpClientModule} from '@angular/common/http';

@NgModule({
  declarations: [
    AppComponent,
    ProductComponent,
    ListProductComponent,
    AddProductComponent,
    ViewProductComponent,
    EditProductComponent,
    DeleteProductComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    ReactiveFormsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule {
}
