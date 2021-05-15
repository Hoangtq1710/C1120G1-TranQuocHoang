import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HeaderComponent } from './component/header/header.component';
import { FooterComponent } from './component/footer/footer.component';
import { NavbarComponent } from './component/navbar/navbar.component';
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import {HttpClientModule} from "@angular/common/http";
import { CustomerComponent } from './customer/customer.component';
import {ListCustomerComponent} from "./customer/list-customer/list-customer.component";
import {DeleteCustomerComponent} from "./customer/delete-customer/delete-customer.component";
import {AddCustomerComponent} from "./customer/add-customer/add-customer.component";
import {EditCustomerComponent} from "./customer/edit-customer/edit-customer.component";
import {ViewCustomerComponent} from "./customer/view-customer/view-customer.component";

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    FooterComponent,
    NavbarComponent,
    ListCustomerComponent,
    AddCustomerComponent,
    EditCustomerComponent,
    ViewCustomerComponent,
    DeleteCustomerComponent,
    CustomerComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    ReactiveFormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
