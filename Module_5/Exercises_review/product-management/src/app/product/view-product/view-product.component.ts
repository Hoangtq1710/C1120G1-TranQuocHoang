import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {Product} from '../../model/Product';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {ProductService} from '../product.service';
import {ActivatedRoute, Router} from '@angular/router';

@Component({
  selector: 'app-view-product',
  templateUrl: './view-product.component.html',
  styleUrls: ['./view-product.component.css']
})
export class ViewProductComponent implements OnInit {

  public listVisitedProduct: string;

  newQtyForm:FormGroup;
  viewProduct:Product;

  constructor(private _formBuilder:FormBuilder,
              private productService:ProductService,
              private activatedRoute:ActivatedRoute,
              private router:Router) {
  }

  ngOnInit(): void {
    let id = this.activatedRoute.snapshot.params['id'];
    this.viewProduct = this.productService.viewProductById(id);
    this.listVisitedProduct = this.productService.listVisitedProduct;

    this.newQtyForm = this._formBuilder.group({
      newQty: ['1', [Validators.required, Validators.min(1), Validators.max(100)]]
    });
  }

  toggleUpQtyInput() {
    let newQtyInput = document.getElementById('tbNewQty');
    newQtyInput.style.display = (newQtyInput.style.display == 'block') ? 'none' : 'block';
  }

  submitNewQty(newQtyForm: FormGroup) {
    this.viewProduct._quantity = newQtyForm.value["newQty"];
    this.productService.updatedProduct(this.viewProduct);

    this.toggleUpQtyInput();
  }

  backToList() {
    this.router.navigateByUrl("list");
  }
}
