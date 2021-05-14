import {Component, EventEmitter, Input, OnChanges, OnInit, Output, SimpleChanges} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {Product} from '../../model/Product';
import {ProductService} from '../../service/product.service';
import {ActivatedRoute, Route, Router} from '@angular/router';
import {validateDate} from '../../validators/DateValidators';

@Component({
  selector: 'app-edit-product',
  templateUrl: './edit-product.component.html',
  styleUrls: ['./edit-product.component.css']
})
export class EditProductComponent implements OnInit {

  listOrigin:string[] = []
  editProduct:Product;
  editForm: FormGroup;
  id:number;

  constructor(private _formBuilder: FormBuilder,
              private productService:ProductService,
              private activatedRoute:ActivatedRoute,
              private router:Router)
  { }

  ngOnInit(): void {
    this.productService.getListOrigin().subscribe(data => {
      this.listOrigin = data;
    }, error => {
      console.log("get error on getListOrigin() in edit-product.component.ts")
    });

    let id:number = this.activatedRoute.snapshot.params['id'];
    this.id = id;

    this.productService.getProductById(id).subscribe(data => {
      let product:Product = data;
      this.editForm = this._formBuilder.group({
        code: [product.code, [Validators.required, Validators.pattern('^PR-[\\d]{4}$')]],
        name: [product.name, [Validators.required]],
        price: [product.price, [Validators.required, Validators.min(10000), Validators.max(50000000)]],
        date: [new Date(product.date).toISOString().slice(0,10), [Validators.required, validateDate]],
        quantity: [product.quantity, [Validators.required, Validators.pattern('^[\\d]+$')]],
        origin: [product.origin, [Validators.required]]
      });
      return this.editProduct = data;
    },error => {
      console.log("get "+error+" on edit-product.component.ts")
    });
  }

  submitEditForm(editForm: FormGroup) {
    let product: Product = editForm.value;
    console.log("Product")
    console.log(product)
    this.productService.updateProductById(product, this.id).subscribe(data => {
      console.log("Success ");
      this.backToList();
    });
  }

  backToList() {
    this.router.navigateByUrl("list");
  }
}
