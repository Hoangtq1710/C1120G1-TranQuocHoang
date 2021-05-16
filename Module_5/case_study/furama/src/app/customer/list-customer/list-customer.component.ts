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

  selectSearch: string = '';
  nameSelect: string = '';

  nameSearch: string = '';
  idCardSearch: string = '';


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

  fullSearchMethod() {
    this.customerService.searchFull(this.fullSearch).subscribe(data => {
      this.listCustomer = data;
    }, error => {
      console.log("get "+error+" at fullSearchMethod on ListCustomerComponent");
    })
  }

  selectSearchMethod() {
    this.customerService.searchSelect(this.selectSearch, this.nameSelect).subscribe(data => {
      this.listCustomer = data;
    }, error => {
      console.log("get "+error+" at selectSearchMethod on ListCustomerComponent");
    })
  }

  searchByNameAndIdCard() {
    this.customerService.searchByNameAndIdCard(this.nameSearch, this.idCardSearch).subscribe(data => {
      this.listCustomer = data;
    }, error => {
      console.log("get "+error+" at searchByNameAndIdCard on ListCustomerComponent");
    })
  }
}
