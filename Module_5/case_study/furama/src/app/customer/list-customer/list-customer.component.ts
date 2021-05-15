import {Component, OnInit} from '@angular/core';
import {CustomerService} from "../../service/customer.service";
import {Customer} from "../../model/Customer";

@Component({
  selector: 'app-list-customer',
  templateUrl: './list-customer.component.html',
  styleUrls: ['./list-customer.component.scss']
})
export class ListCustomerComponent implements OnInit {

  listCustomer: Customer[] = [];
  listType: string[] = [];
  fullSearch: string = '';
  selectSearch: string;

  constructor(private customerService: CustomerService) {
  }

  ngOnInit(): void {
    this.customerService.getListType().subscribe(data => {
      this.listType = data;
    }, error => {
      console.log("get " + error + " at getListType on ListCustomerComponent");
    })
    
    this.customerService.getListCustomer().subscribe(data => {
      this.listCustomer = data;
    }, error => {
      console.log("get " + error + " at getListCustomer on ListCustomerComponent");
    })
  }

  search() {
    this.customerService.searchFull(this.fullSearch).subscribe(data => {
      this.listCustomer = data;
    }, error => {
      console.log(error)
    })
  }
}
