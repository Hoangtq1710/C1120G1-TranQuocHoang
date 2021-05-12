import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {ProductService} from '../../service/product.service';
import {ActivatedRoute, Router} from '@angular/router';
import {Product} from '../../model/Product';
import {validateManuDate} from '../../validators/ManuDateValidators';

@Component({
  selector: 'app-edit-product',
  templateUrl: './edit-product.component.html',
  styleUrls: ['./edit-product.component.css']
})
export class EditProductComponent implements OnInit {

  editForm:FormGroup;
  public product:Product;

  constructor(private formBuilder:FormBuilder,
              private productService:ProductService,
              private activatedRoute:ActivatedRoute,
              private router:Router) { }

  ngOnInit(): void {
    let id = this.activatedRoute.snapshot.params['id'];
    this.product = this.productService.getProductById(id);

    this.editForm = this.formBuilder.group({
      id: [this.product.id, [Validators.required,Validators.pattern('^OTO-[\\d]{4}$')]],
      name: [this.product.name, [Validators.required]],
      price: [this.product.price, [Validators.required, Validators.min(4000), Validators.max(500000)]],
      manuDate: [new Date(this.product.manuDate).toISOString().slice(0,10), [Validators.required]],
      quantity:[this.product.quantity, [Validators.required, Validators.pattern('^[\\d]+$')]],
      description: [this.product.description, [Validators.required]]
    })
  }

  submitEditForm(editForm: FormGroup) {
    let product = editForm.value;
    this.productService.edit(product);
    this.backToList();
  }

  backToList() {
    this.router.navigateByUrl("product");
  }
}
