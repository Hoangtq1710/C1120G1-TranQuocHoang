import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {Product} from '../../model/Product';

@Component({
  selector: 'app-view-product',
  templateUrl: './view-product.component.html',
  styleUrls: ['./view-product.component.css']
})
export class ViewProductComponent implements OnInit {

  @Input('product') viewProduct: Product;
  @Output('updatedProduct') product = new EventEmitter<Product>();
  @Input('listVisitedProduct') listVisitedProduct: string;

  constructor() {
  }

  ngOnInit(): void {
  }

  showUpQtyInput() {
    document.getElementById('tbNewQty').style.display = 'block';
  }

  updateQty(viewProduct: Product, value: string) {
    viewProduct.quantity = parseInt(value);
    this.product.emit(viewProduct);
    document.getElementById('tbNewQty').style.display = 'none';
  }
}
