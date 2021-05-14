import {Injectable} from '@angular/core';
import {Product} from '../model/Product';

@Injectable({
  providedIn: 'root'
})
export class ProductService {

  private listProduct: Product[] = [
    {id: 'OTO-1546', name: 'Lexus', price: 15000, manuDate: new Date('2020-08-14'), quantity: 16, description: 'Lexus\'s oto'},
    {id: 'OTO-0481', name: 'Mazda', price: 19000, manuDate: new Date('2021-02-28'), quantity: 0, description: 'Mazda\'s oto'},
    {id: 'OTO-1403', name: 'Toyota', price: 24500, manuDate: new Date('2021-03-31'), quantity: 25, description: 'Toyota\'s oto'},
    {id: 'OTO-0623', name: 'Porsche', price: 17400, manuDate: new Date('2020-10-29'), quantity: 10, description: 'Porsche\'s oto'},
    {id: 'OTO-3471', name: 'Genesis', price: 12500, manuDate: new Date('2019-09-16'), quantity: 26, description: 'Genesis\'s oto'},
    {id: 'OTO-9523', name: 'Hyundai', price: 13200, manuDate: new Date('2021-04-04'), quantity: 8, description: 'Hyundai\'s oto'},
    {id: 'OTO-1045', name: 'Subaru', price: 9400, manuDate: new Date('2019-02-03'), quantity: 9, description: 'Subaru\'s oto'},
    {id: 'OTO-0379', name: 'Dodge', price: 10200, manuDate: new Date('2021-01-18'), quantity: 7, description: 'Dodge\'s oto'},
    {id: 'OTO-0692', name: 'KIA', price: 21600, manuDate: new Date('2020-07-25'), quantity: 0, description: 'KIA\'s oto'},
    {id: 'OTO-1158', name: 'Mini', price: 8000, manuDate: new Date('2021-01-01'), quantity: 23, description: 'Mini\'s oto'},
  ];

  private message: string = '';

  constructor() {
  }

  getList(): Product[] {
    return this.listProduct;
  }

  save(product: Product): void {
    this.listProduct.push(product);
    this.message = 'Product ' + product.name + ' added successfully!';
  }

  getProductById(id: string): Product {
    for (let i = 0; i < this.listProduct.length; i++) {
      if (this.listProduct[i].id === id) {
        return this.listProduct[i];
      }
    }
    return null;
  }

  edit(product: Product): void {
    for (let i = 0; i < this.listProduct.length; i++) {
      if (this.listProduct[i].id === product.id) {
        this.listProduct[i] = product;
        this.message = 'Product ID ' + product.name + ' was updated!';
        return;
      }
    }
  }

  deleteById(id: string) {
    for (let i = 0; i < this.listProduct.length; i++) {
      if (this.listProduct[i].id === id) {
        this.listProduct.splice(i, 1);
        this.message = 'Product ID ' + id + ' was deleted!';
        return;
      }
    }
  }

  getMessage(): string
    {
      return this.message;
    }
  }
