import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {Customer} from "../../../model/Customer";

@Component({
  selector: 'app-create-customer',
  templateUrl: './create-customer.component.html',
  styleUrls: ['./create-customer.component.scss']
})
export class CreateCustomerComponent implements OnInit {

  @Output('customer') customer = new EventEmitter();

  constructor() { }

  ngOnInit(): void {
  }

  addCustomer(id: string, name: string, type: string, birthday: string, idCard: string,
              phone: string, email: string, address: string) {
    let addCus:Customer = new Customer(id, name, parseInt(type), birthday, idCard, phone, email, address);
    this.customer.emit(addCus);
  }
}
