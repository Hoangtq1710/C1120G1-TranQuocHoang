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

  public product:Product;
  public id:number;

  constructor(
    private productService:ProductService,
    private activatedRoute:ActivatedRoute,
    private router:Router
  ) { }

  ngOnInit(): void {
    let id:number = this.activatedRoute.snapshot.params['id'];
    this.id = id;
    this.productService.getProductById(id).subscribe( data => {
      this.product = data;
    })
  }

  deleteProduct() {
    console.log("ID PRODUCT DELETE : "+this.id)
    this.productService.deleteProductById(this.id).subscribe(data => {
      this.backToList();
    });
  }

  backToList() {
    this.router.navigateByUrl("list");
  }

}
