import {Component, OnInit} from '@angular/core';
import {Product} from '../../model/Product';
import {ProductService} from '../product.service';

@Component({
  selector: 'app-list-product',
  templateUrl: './list-product.component.html',
  styleUrls: ['./list-product.component.css']
})
export class ListProductComponent implements OnInit {

  public listProduct: Product[] = [];

  constructor(private _productService:ProductService) {
  }

  ngOnInit(): void {
    this.listProduct = this._productService.listProduct;
  }

}
