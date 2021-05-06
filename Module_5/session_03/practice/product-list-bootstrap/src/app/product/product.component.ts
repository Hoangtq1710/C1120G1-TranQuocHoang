import { Component, OnInit } from '@angular/core';
import {Product} from "./model/Product";

@Component({
  selector: 'app-product',
  templateUrl: './product.component.html',
  styleUrls: ['./product.component.css']
})
export class ProductComponent implements OnInit {
  public title:string = "Product list";

  public sony:Product = new Product(1,"Sony", 750, 10, "Sony Inc");
  public oppo:Product = new Product(1,"Oppo", 800, 12, "Oppo Inc");


  constructor() { }

  ngOnInit(): void {
  }

}
