import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { ProductComponent } from './product/product.component';
import { ListProductComponent } from './product/list-product/list-product.component';
import { AddProductComponent } from './product/list-product/add-product/add-product.component';
import { ViewProductComponent } from './product/list-product/view-product/view-product.component';

@NgModule({
  declarations: [
    AppComponent,
    ProductComponent,
    ListProductComponent,
    AddProductComponent,
    ViewProductComponent
  ],
  imports: [
    BrowserModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
