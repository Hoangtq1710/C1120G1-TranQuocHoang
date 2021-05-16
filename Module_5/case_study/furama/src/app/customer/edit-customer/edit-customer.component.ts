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

  form:FormGroup;
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
      this.initForm();
      this.form.patchValue(data);

      return this.editCustomer = data;
    }, error => {
      console.log("get "+error+" at getCustomerById on EditCustomerComponent");
    })
  }

  initForm(){
    this.form = this.formBuilder.group({
      code: ['', [Validators.required, Validators.pattern('^KH-[\\d]{4}$')]],
      name: ['', [Validators.required, Validators.minLength(5)]],
      type: ['', [Validators.required]],
      birthday: ['', [Validators.required, validateDate]],
      idCard: ['',[Validators.required, Validators.pattern('^[\\d]{9}$')]],
      phone: ['',[Validators.required, Validators.pattern('^090[\\d]{7}$')]],
      email: ['', [Validators.required,Validators.email]],
      address: ['', [Validators.required, Validators.minLength(3)]]
    });
  }

  submitForm(form: FormGroup) {
    let customer: Customer = form.value;

    this.customerService.updateCustomerById(customer, this.id).subscribe(data => {
      console.log("Success");
      this.backToList();
    });
  }

  backToList() {
    this.router.navigateByUrl("customer");
  }
}
