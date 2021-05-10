import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {Customer} from "../../../model/Customer";

@Component({
  selector: 'app-delete-customer',
  templateUrl: './delete-customer.component.html',
  styleUrls: ['./delete-customer.component.scss']
})
export class DeleteCustomerComponent implements OnInit {

  @Input('customer') deleteCustomer:Customer;
  @Output('idCustomer') idCustomer = new EventEmitter<string>();

  constructor() { }

  ngOnInit(): void {
  }

  deleteCustomerMethod(idCustomer: string) {
    this.idCustomer.emit(idCustomer);
  }
}
