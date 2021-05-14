import { Component, OnInit } from '@angular/core';
import {Product} from '../../model/Product';
import {ProductService} from '../../service/product.service';

@Component({
  selector: 'app-list-product',
  templateUrl: './list-product.component.html',
  styleUrls: ['./list-product.component.css']
})
export class ListProductComponent implements OnInit {

  public listProduct:Product[] = [];
  message: any;

  constructor( private productService:ProductService )
  { }

  ngOnInit(): void {
    this.listProduct = this.productService.getList();
    this.message = this.productService.getMessage();
  }

  closeAlert() {
    let alert = document.getElementById('alertFade').style;
    // @ts-ignore
    alert.opacity = 1;
    (function fade(){
      // @ts-ignore
      (alert.opacity-=.1)<0?alert.display="none":setTimeout(fade,60)})();
  }

}
