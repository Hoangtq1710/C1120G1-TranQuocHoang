import {Component, OnInit} from '@angular/core';
import {Product} from '../../model/Product';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {ProductService} from '../../service/product.service';
import {ActivatedRoute, Router} from '@angular/router';

@Component({
  selector: 'app-view-product',
  templateUrl: './view-product.component.html',
  styleUrls: ['./view-product.component.css']
})
export class ViewProductComponent implements OnInit {

  public listVisitedProduct: string = '';

  newQtyForm:FormGroup;
  viewProduct:Product;

  constructor(private _formBuilder:FormBuilder,
              private productService:ProductService,
              private activatedRoute:ActivatedRoute,
              private router:Router) {
  }

  ngOnInit(): void {
    this.newQtyForm = this._formBuilder.group({
      newQty: ['1', [Validators.required, Validators.min(1), Validators.max(100)]]
    });
    let id:number = this.activatedRoute.snapshot.params['id'];
    this.productService.getProductById(id).subscribe(data => {
      return this.viewProduct = data; // 23:58 13-05 Finally I got it
    }, error => {
      console.log("get error on view-product.component.ts")
    })
  }

  toggleUpQtyInput() {
    let newQtyInput = document.getElementById('tbNewQty');
    newQtyInput.style.display = (newQtyInput.style.display == 'block') ? 'none' : 'block';
  }

  submitNewQty(newQtyForm: FormGroup) {
    this.viewProduct.quantity = newQtyForm.value["newQty"];
    console.log(this.viewProduct.quantity)

    this.toggleUpQtyInput();
  }

  backToList() {
    this.router.navigateByUrl("list");
  }
}
