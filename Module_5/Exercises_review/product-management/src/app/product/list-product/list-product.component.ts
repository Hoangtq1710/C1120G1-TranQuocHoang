import {Component, OnInit} from '@angular/core';
import {Product} from '../../model/Product';

@Component({
  selector: 'app-list-product',
  templateUrl: './list-product.component.html',
  styleUrls: ['./list-product.component.css']
})
export class ListProductComponent implements OnInit {

  public origin:string[] = ["China", "England", "USA", "VietNam"];
  public viewProduct:Product;
  public listVisitedProduct:string = 'List Viewed Products : ';

  public listProduct:Product[] = [
    new Product(1,"Oppo", 45000, new Date('2021-03-05'), 9, this.origin[0]),
    new Product(2,"Iphone X", 61000, new Date('2021-02-19'), 13, this.origin[2]),
    new Product(3,"Iphone 12", 72000, new Date('2021-03-27'), 6, this.origin[2]),
    new Product(4,"Iphone 8", 30000, new Date('2020-08-01'), 0, this.origin[2]),
    new Product(5,"Nokia", 26000, new Date('2020-12-07'), 5, this.origin[1]),
    new Product(6,"Samsung", 50000, new Date('2021-04-19'), 16, this.origin[3]),
    new Product(7,"LG", 40000, new Date('2021-02-28'), 0, this.origin[1]),
    new Product(8,"Vsmart", 32000, new Date('2021-01-17'), 11, this.origin[3])
  ]

  constructor() { }

  ngOnInit(): void {
  }

  createProduct(value: Product) {
    this.listProduct.push(value);
  }

  viewCustomer(id: number) {
    for(let product of this.listProduct) {
      if (product.id == id) {
        this.viewProduct = product;
        this.listVisitedProduct += product.name+' ,';
        return;
      }
    }
  }

  getUpdatedProduct(value: Product) {
    for(let product of this.listProduct) {
      if (product.id == value.id) {
        product = value;
        return;
      }
    }
  }

  showCreateForm() {
    document.getElementById('createForm').style.display = 'block';
  }
}
