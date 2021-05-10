import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {Customer} from "../../../model/Customer";

@Component({
  selector: 'app-edit-customer',
  templateUrl: './edit-customer.component.html',
  styleUrls: ['./edit-customer.component.scss']
})
export class EditCustomerComponent implements OnInit {

  @Input('customer') editCustomer:Customer;
  @Output('customer') customer = new EventEmitter<Customer>();

  constructor() { }

  ngOnInit(): void {
  }

  editCustomerMethod(id:string, name:string, type:string, birthday:string, idCard:string,
                     phone:string, email:string, address:string){
    let editCus = new Customer(id, name,parseInt(type), birthday,idCard,phone,email,address);
    this.customer.emit(editCus);
  }

}
