import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {Product} from '../../model/Product';

@Component({
  selector: 'app-add-product',
  templateUrl: './add-product.component.html',
  styleUrls: ['./add-product.component.css']
})
export class AddProductComponent implements OnInit {

  @Input('listOrigin') listOrigin:string[];
  @Output('product') addProduct = new EventEmitter<Product>();

  constructor() { }

  ngOnInit(): void {
  }

  createProduct(id:string, name:string, price:string, date:string, quantity:string, origin:string) {
    let product:Product = new Product(parseInt(id) ,name, parseInt(price), new Date(date), parseInt(quantity), origin);

    this.addProduct.emit(product);
  }

  closeCreateForm() {
    document.getElementById('createForm').style.display = 'none';
  }
}
