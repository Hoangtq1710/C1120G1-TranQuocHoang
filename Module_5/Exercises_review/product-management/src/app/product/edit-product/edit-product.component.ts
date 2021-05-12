import {Component, EventEmitter, Input, OnChanges, OnInit, Output, SimpleChanges} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {Product} from '../../model/Product';
import {ProductService} from '../product.service';
import {ActivatedRoute, Route, Router} from '@angular/router';

@Component({
  selector: 'app-edit-product',
  templateUrl: './edit-product.component.html',
  styleUrls: ['./edit-product.component.css']
})
export class EditProductComponent implements OnInit {

  listOrigin:string[] = []
  editProduct:Product;
  editForm: FormGroup;

  constructor(private _formBuilder: FormBuilder,
              private productService:ProductService,
              private activatedRoute:ActivatedRoute,
              private router:Router)
  { }

  ngOnInit(): void {
    this.listOrigin = this.productService.listOrigin;
    let id:number = this.activatedRoute.snapshot.params['id'];
    this.editProduct = this.productService.getProductById(id);

    this.editForm = this._formBuilder.group({
      productId: [this.editProduct._id, [Validators.required, Validators.pattern('^[\\d]+$')]],
      productName: [this.editProduct._name, [Validators.required]],
      productPrice: [this.editProduct._price, [Validators.required, Validators.min(10000), Validators.max(50000000)]],
      productDate: [new Date(this.editProduct._date).toISOString().slice(0,10), [Validators.required]],
      productQuantity: [this.editProduct._quantity, [Validators.required, Validators.pattern('^[\\d]+$')]],
      productOrigin: [this.editProduct._origin, [Validators.required]]
    });
  }

  submitEditForm(editForm: FormGroup) {
    let product: Product = {
      _id: editForm.value['productId'],
      _name: editForm.value['productName'],
      _price: editForm.value['productPrice'],
      _date: editForm.value['productDate'],
      _quantity: editForm.value['productQuantity'],
      _origin: editForm.value['productOrigin']
    };
    this.productService.updatedProduct(product);
    this.backToList();
  }

  backToList() {
    this.router.navigateByUrl("list");
  }
}
