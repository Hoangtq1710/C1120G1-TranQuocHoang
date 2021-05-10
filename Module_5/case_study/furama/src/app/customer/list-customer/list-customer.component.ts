import {Component, Input, OnInit} from '@angular/core';
import {Customer} from "../../model/Customer";

@Component({
  selector: 'app-list-customer',
  templateUrl: './list-customer.component.html',
  styleUrls: ['./list-customer.component.scss']
})
export class ListCustomerComponent implements OnInit {

  @Input('listCustomer') listCustomer:Customer[]
  public customer:Customer;

  constructor() { }

  ngOnInit(): void {
  }

  viewCustomer(customer: Customer) {
    this.customer = customer;
  }

  showEditForm(customer: Customer) {
    this.customer = customer;
  }

  showDeleteForm(customer: Customer) {
    this.customer = customer;
  }

  addCustomer(customer: Customer) {
    this.listCustomer.push(customer);
  }

  editCustomer(value: Customer) {
    for(let customer of this.listCustomer) {
      if (customer.idCustomer == value.idCustomer){
        customer = value;
        return;
      }
    }
  }

  deleteCustomer(idCustomer: string) {
    for(let cus of this.listCustomer) {
      if (cus.idCustomer == idCustomer) {
        this.listCustomer.slice(this.listCustomer.indexOf(cus), 1);
      }
    }
  }
}
