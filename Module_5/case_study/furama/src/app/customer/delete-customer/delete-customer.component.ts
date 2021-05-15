import {Component, OnInit} from '@angular/core';
import {CustomerService} from "../../service/customer.service";
import {ActivatedRoute, Router} from "@angular/router";
import {Customer} from "../../model/Customer";

@Component({
  selector: 'app-delete-customer',
  templateUrl: './delete-customer.component.html',
  styleUrls: ['./delete-customer.component.scss']
})
export class DeleteCustomerComponent implements OnInit {

  id:number;
  customer: Customer;

  constructor(private customerService:CustomerService,
              private activatedRoute:ActivatedRoute,
              private router: Router) { }

  ngOnInit(): void {
    let id:number = this.activatedRoute.snapshot.params['id'];
    this.id = id;

    this.customerService.getCustomerById(id).subscribe(data => {
      return this.customer = data;
    }, error => {
      console.log("get "+error+" at getCustomerById on DeleteCustomerComponent");
    })
  }

  deleteCustomer() {
    this.customerService.deleteCustomerById(this.id).subscribe(data => {
      console.log(data+" success delete")
      this.backToList();
    })
  }

  backToList() {
    this.router.navigateByUrl("customer");
  }
}
