import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {Product} from '../../model/Product';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';

@Component({
  selector: 'app-add-product',
  templateUrl: './add-product.component.html',
  styleUrls: ['./add-product.component.css']
})
export class AddProductComponent implements OnInit {

  @Input('listOrigin') listOrigin: string[];
  @Output('product') addProduct = new EventEmitter<Product>();

  createForm: FormGroup;

  constructor(private _formBuilder: FormBuilder) {
  }

  ngOnInit(): void {
    this.createForm = this._formBuilder.group({
      productId: [0, [Validators.required, Validators.pattern('^[\\d]+$')]],
      productName: ['', Validators.required],
      productPrice: [0, [Validators.required, Validators.min(10000), Validators.max(50000000)]],
      productDate: ['', [Validators.required]],
      productQuantity: ['', [Validators.required, Validators.pattern('^[\\d]+$')]],
      productOrigin: ['', [Validators.required]]
    });
  }


  closeCreateForm() {
    document.getElementById('createForm').style.display = 'none';
  }

  submitCreateForm(createForm: FormGroup) {
    let product: Product = {
      _id: createForm.value['productId'],
      _name: createForm.value['productName'],
      _price: createForm.value['productPrice'],
      _date: createForm.value['productDate'],
      _quantity: createForm.value['productQuantity'],
      _origin: createForm.value['productOrigin']
    };
    this.addProduct.emit(product);
  }
}
