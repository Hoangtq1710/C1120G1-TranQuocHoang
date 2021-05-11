import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {Product} from '../../model/Product';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';

@Component({
  selector: 'app-view-product',
  templateUrl: './view-product.component.html',
  styleUrls: ['./view-product.component.css']
})
export class ViewProductComponent implements OnInit {

  @Input('product') viewProduct: Product;
  @Output('updatedProduct') product = new EventEmitter<Product>();
  @Input('listVisitedProduct') listVisitedProduct: string;

  newQtyForm:FormGroup;

  constructor(private _formBuilder:FormBuilder) {
  }

  ngOnInit(): void {
    this.newQtyForm = this._formBuilder.group({
      newQty: ['1', [Validators.required, Validators.min(1), Validators.max(100)]]
    })
  }

  showUpQtyInput() {
    document.getElementById('tbNewQty').style.display = 'block';
  }

  submitNewQty(newQtyForm: FormGroup) {
    this.viewProduct._quantity = newQtyForm.value["newQty"];
    this.product.emit(this.viewProduct);
    document.getElementById('tbNewQty').style.display = 'none';
  }
}
