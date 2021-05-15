import {Component, OnInit} from '@angular/core';
import {Product} from '../../model/Product';
import {ProductService} from '../../service/product.service';

@Component({
  selector: 'app-list-product',
  templateUrl: './list-product.component.html',
  styleUrls: ['./list-product.component.css']
})
export class ListProductComponent implements OnInit {

  public listProduct: Product[] = [];
  message: any;

  constructor(private _productService:ProductService) {
  }

  ngOnInit(): void {
    this._productService.getListProduct().subscribe(data => {
      this.listProduct = data;
    }, error => {
      console.log("Get "+error+" on getListProduct()");
    });
    this.message = this._productService.getMessage();
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
