import {Component, Input, OnInit} from '@angular/core';
import {Customer} from "../../../model/Customer";

@Component({
  selector: 'app-view-customer',
  templateUrl: './view-customer.component.html',
  styleUrls: ['./view-customer.component.scss']
})
export class ViewCustomerComponent implements OnInit {

  @Input('customer') viewCustomer:Customer;

  constructor() { }

  ngOnInit(): void {
  }

}
