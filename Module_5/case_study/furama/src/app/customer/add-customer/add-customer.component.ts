import { Component, OnInit } from '@angular/core';
import {CustomerService} from "../../service/customer.service";
import {Router} from "@angular/router";
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {validateDate} from "../../validator/DateValidators";
import {Customer} from "../../model/Customer";

@Component({
  selector: 'app-add-customer',
  templateUrl: './add-customer.component.html',
  styleUrls: ['./add-customer.component.scss']
})
export class AddCustomerComponent implements OnInit {

  createForm:FormGroup;
  listType: string[] = [];

  constructor(private formBuilder:FormBuilder,
              private customerService:CustomerService,
              private router:Router) { }

  ngOnInit(): void {
    this.customerService.getListType().subscribe(data => {
      this.listType = data;
    }, error => {
      console.log("get "+error+" at getListType on AddCustomerComponent");
    });

    this.createForm = this.formBuilder.group({
      code: ['KH-', [Validators.required, Validators.pattern('^KH-[\\d]{4}$')]],
      name: ['', [Validators.required, Validators.minLength(5)]],
      type: ['', [Validators.required]],
      birthday: ['', [Validators.required, validateDate]],
      idCard: ['',[Validators.required, Validators.pattern('^[\\d]{9}$')]],
      phone: ['',[Validators.required, Validators.pattern('^090[\\d]{7}$')]],
      email: ['', [Validators.required,Validators.email]],
      address: ['', [Validators.required, Validators.minLength(3)]]
    });
  }

  submitCreateForm(createForm: FormGroup) {
    let customer: Customer = createForm.value;
    this.customerService.save(customer).subscribe(data => {
      this.backToList();
    }, error => {
      console.log("get "+error+" at submitCreateForm on AddCustomerComponent");
    })
  }

  backToList() {
    this.router.navigateByUrl("customer");
  }
}
