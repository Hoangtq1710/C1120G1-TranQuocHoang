import {Component, OnInit} from '@angular/core';
import {Product} from '../../model/Product';

@Component({
  selector: 'app-list-product',
  templateUrl: './list-product.component.html',
  styleUrls: ['./list-product.component.css']
})
export class ListProductComponent implements OnInit {

  public origin: string[] = ['China', 'England', 'USA', 'VietNam'];
  public listVisitedProduct: string = 'List Viewed Products : ';
  public viewProduct: Product;
  public editProduct: Product;

  public listProduct: Product[] = [

    {_id: 1, _name: 'Oppo', _price: 45000, _date: new Date('2021-03-05'), _quantity: 9, _origin: this.origin[0]},
    {_id: 2, _name: 'Iphone X', _price: 61000, _date: new Date('2021-02-19'), _quantity: 13, _origin: this.origin[2]},
    {_id: 3, _name: 'Iphone 12', _price: 72000, _date: new Date('2021-03-27'), _quantity: 6, _origin: this.origin[2]},
    {_id: 4, _name: 'Iphone 8', _price: 30000, _date: new Date('2020-08-01'), _quantity: 0, _origin: this.origin[2]},
    {_id: 5, _name: 'Nokia', _price: 26000, _date: new Date('2020-12-07'), _quantity: 5, _origin: this.origin[1]},
    {_id: 6, _name: 'Samsung', _price: 50000, _date: new Date('2021-04-19'), _quantity: 16, _origin: this.origin[3]},
    {_id: 7, _name: 'LG', _price: 40000, _date: new Date('2021-02-28'), _quantity: 0, _origin: this.origin[1]},
    {_id: 8, _name: 'Vsmart', _price: 32000, _date: new Date('2021-01-17'), _quantity: 11, _origin: this.origin[3]}
  ];

  public listAfterUpdate: Product[] = [];

  constructor() {
  }

  ngOnInit(): void {
  }

  createProduct(value: Product) {
    this.listProduct.push(value);
  }

  viewProductMethod(product: Product) {
    this.viewProduct = product;
    this.listVisitedProduct += product._name + ' ,';
    return;
  }

  getQtyUpdatedProduct(value: Product) {
    for (let product of this.listProduct) {
      if (product._id == value._id) {
        product = {
          _id: value._id,
          _name: value._name,
          _price: value._price,
          _date: value._date,
          _quantity: value._quantity,
          _origin: value._origin
        };
        return; //update exactly one product if get the right one
      }
    }
  }

  showCreateForm() {
    document.getElementById('createForm').style.display = 'block';
  }

  getUpdatedProduct(value: Product) {
    for (let i = 0; i < this.listProduct.length; i++) { // list is a Array<Product>[] now
      if (this.listProduct[i]._id == value._id) {
        this.listAfterUpdate[i] = value;
      } else {
        this.listAfterUpdate[i] = this.listProduct[i];
      }
    }
    this.listProduct = []; // !important
    // this statement is required cuz when for loop is done, you have the full list updated in this.listAfterUpdate
    // if you wanna assign whole list of this.listAfterUpdate to this.listProduct then you have to clear this.listProduct first
    // if not, the web page is failed to load the new list (the list after updated information)
    // (Infinity Loop => STACK OVER FLOW error : CPU is immediately hit to 100% from ~20%!)
    this.listProduct = this.listAfterUpdate;
  }

  editProductMethod(product: Product) {
    this.editProduct = product;
  }
}
