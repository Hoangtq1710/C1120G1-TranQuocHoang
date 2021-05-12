import { Component, OnInit } from '@angular/core';
import {ProductService} from '../../service/product.service';
import {ActivatedRoute, Router} from '@angular/router';
import {Product} from '../../model/Product';

@Component({
  selector: 'app-delete-product',
  templateUrl: './delete-product.component.html',
  styleUrls: ['./delete-product.component.css']
})
export class DeleteProductComponent implements OnInit {

  product:Product;

  constructor(
    private productService:ProductService,
    private activatedRoute:ActivatedRoute,
    private router:Router
  ) { }

  ngOnInit(): void {
    let id = this.activatedRoute.snapshot.params['id'];
    this.product = this.productService.getProductById(id);
  }

  deleteProduct() {
    this.productService.deleteById(this.product.id);
    this.backToList();
  }

  backToList() {
    this.router.navigateByUrl("product");
  }

}
