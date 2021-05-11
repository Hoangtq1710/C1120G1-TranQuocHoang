import {Component, EventEmitter, Input, OnChanges, OnInit, Output, SimpleChanges} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {Product} from '../../model/Product';

@Component({
  selector: 'app-edit-product',
  templateUrl: './edit-product.component.html',
  styleUrls: ['./edit-product.component.css']
})
export class EditProductComponent implements OnInit, OnChanges {

  @Input('product') editProduct: Product| undefined;
  @Output('product') updatedProduct = new EventEmitter<Product>();
  @Input('listOrigin') listOrigin: string[];

  editForm: FormGroup;

  constructor(private _formBuilder: FormBuilder) { }

  ngOnInit(): void { }

  ngOnChanges(changes: SimpleChanges): void {
    if (this.editProduct != null){
      console.log("Date : "+this.editProduct._date) //full time Date style
      console.log("Date toISOString : "+this.editProduct._date.toISOString().slice(0,10)) // yyyy-MM-dd

      this.editForm = this._formBuilder.group({
        productId: [this.editProduct._id, [Validators.required, Validators.pattern('^[\\d]+$')]],
        productName: [this.editProduct._name, [Validators.required]],
        productPrice: [this.editProduct._price, [Validators.required, Validators.min(10000), Validators.max(50000000)]],
        productDate: [new Date(this.editProduct._date).toISOString().slice(0,10), [Validators.required]],
        productQuantity: [this.editProduct._quantity, [Validators.required, Validators.pattern('^[\\d]+$')]],
        productOrigin: [this.editProduct._origin, [Validators.required]]
      });
    }
  }

  submitEditForm(editForm: FormGroup) {
    console.log("called submitEditForm");
    let product: Product = {
      _id: editForm.value['productId'],
      _name: editForm.value['productName'],
      _price: editForm.value['productPrice'],
      _date: editForm.value['productDate'],
      _quantity: editForm.value['productQuantity'],
      _origin: editForm.value['productOrigin']
    };
    this.updatedProduct.emit(product);
    console.log(product._date)
  }

}
