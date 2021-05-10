import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HeaderComponent } from './component/header/header.component';
import { FooterComponent } from './component/footer/footer.component';
import { NavbarComponent } from './component/navbar/navbar.component';
import { CustomerComponent } from './customer/customer.component';
import { ListCustomerComponent } from './customer/list-customer/list-customer.component';
import { CreateCustomerComponent } from './customer/list-customer/create-customer/create-customer.component';
import { EditCustomerComponent } from './customer/list-customer/edit-customer/edit-customer.component';
import { DeleteCustomerComponent } from './customer/list-customer/delete-customer/delete-customer.component';
import { ViewCustomerComponent } from './customer/list-customer/view-customer/view-customer.component';
import {FormsModule} from "@angular/forms";

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    FooterComponent,
    NavbarComponent,
    CustomerComponent,
    ListCustomerComponent,
    CreateCustomerComponent,
    EditCustomerComponent,
    DeleteCustomerComponent,
    ViewCustomerComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
