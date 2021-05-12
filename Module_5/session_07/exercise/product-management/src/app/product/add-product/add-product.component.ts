import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {ProductService} from '../../service/product.service';
import {Router} from '@angular/router';
import {validateManuDate} from '../../validators/ManuDateValidators';
import {Product} from '../../model/Product';

@Component({
  selector: 'app-add-product',
  templateUrl: './add-product.component.html',
  styleUrls: ['./add-product.component.css']
})
export class AddProductComponent implements OnInit {

  addForm:FormGroup;

  constructor(private formBuilder:FormBuilder,
              private productService:ProductService,
              private router:Router) { }

  ngOnInit(): void {
    this.addForm = this.formBuilder.group({
      id: ['OTO-', [Validators.required,Validators.pattern('^OTO-[\\d]{4}$')]],
      name: ['', [Validators.required]],
      price: [0, [Validators.required, Validators.min(4000), Validators.max(500000)]],
      manuDate: ['', [Validators.required, validateManuDate]],
      quantity: [0, [Validators.required, Validators.pattern('^[\\d]+$')]],
      description: ['', [Validators.required]]
    })
  }

  submitAddForm(addForm: FormGroup) {
    let product:Product = addForm.value;
    this.productService.save(product);
    this.backToList();
  }

  backToList() {
    this.router.navigateByUrl("product");
  }
}
