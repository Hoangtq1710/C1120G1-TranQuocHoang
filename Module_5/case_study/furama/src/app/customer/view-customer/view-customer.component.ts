import { Component, OnInit } from '@angular/core';
import {Customer} from "../../model/Customer";
import {CustomerService} from "../../service/customer.service";
import {ActivatedRoute, Router} from "@angular/router";

@Component({
  selector: 'app-view-customer',
  templateUrl: './view-customer.component.html',
  styleUrls: ['./view-customer.component.scss']
})
export class ViewCustomerComponent implements OnInit {

  customer:Customer;

  constructor(private customerService:CustomerService,
              private activatedRoute:ActivatedRoute,
              private router:Router) { }

  ngOnInit(): void {
    let id:number = this.activatedRoute.snapshot.params['id'];
    this.customerService.getCustomerById(id).subscribe(data => {
      this.customer = data;
    }, error =>  {
      console.log("get "+ error +" at getCustomerById on ViewCustomerComponent")
    })
  }

  close() {
    this.router.navigateByUrl("customer");
  }
}
