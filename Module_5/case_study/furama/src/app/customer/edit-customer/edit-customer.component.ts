import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {validateDate} from "../../validator/DateValidators";
import {Customer} from "../../model/Customer";
import {CustomerService} from "../../service/customer.service";
import {ActivatedRoute, Router} from "@angular/router";

@Component({
  selector: 'app-edit-customer',
  templateUrl: './edit-customer.component.html',
  styleUrls: ['./edit-customer.component.scss']
})
export class EditCustomerComponent implements OnInit {

  editForm:FormGroup;
  editCustomer:Customer;
  listType: string[] = [];
  id:number;

  constructor(
    private formBuilder:FormBuilder,
    private customerService:CustomerService,
    private activatedRoute:ActivatedRoute,
    private router:Router
  ) { }

  ngOnInit(): void {
    this.customerService.getListType().subscribe(data => {
      this.listType = data;
    }, error => {
      console.log("get "+error+" at getListType on EditCustomerComponent");
    });

    let id:number = this.activatedRoute.snapshot.params['id'];
    this.id = id;

    this.customerService.getCustomerById(id).subscribe(data => {
      let customer:Customer = data;

      this.editForm = this.formBuilder.group({
        code: [customer.code, [Validators.required, Validators.pattern('^KH-[\\d]{4}$')]],
        name: [customer.name, [Validators.required, Validators.minLength(5)]],
        type: [customer.type, [Validators.required]],
        birthday: [customer.birthday, [Validators.required, validateDate]],
        idCard: [customer.idCard,[Validators.required, Validators.pattern('^[\\d]{9}$')]],
        phone: [customer.phone,[Validators.required, Validators.pattern('^090[\\d]{7}$')]],
        email: [customer.email, [Validators.required,Validators.email]],
        address: [customer.address, [Validators.required, Validators.minLength(3)]]
      });

      return this.editCustomer = data;
    }, error => {
      console.log("get "+error+" at getCustomerById on EditCustomerComponent");
    })
  }

  submitEditForm(editForm: FormGroup) {
    let customer: Customer = editForm.value;

    this.customerService.updateCustomerById(customer, this.id).subscribe(data => {
      console.log("Success");
      this.backToList();
    });
  }

  backToList() {
    this.router.navigateByUrl("customer");
  }
}
