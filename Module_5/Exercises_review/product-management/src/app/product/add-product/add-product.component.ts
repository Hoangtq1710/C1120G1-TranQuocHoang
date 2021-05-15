import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {ProductService} from '../../service/product.service';
import {Router} from '@angular/router';
import {validateDate} from '../../validators/DateValidators';
import {Product} from '../../model/Product';

@Component({
  selector: 'app-add-product',
  templateUrl: './add-product.component.html',
  styleUrls: ['./add-product.component.css']
})
export class AddProductComponent implements OnInit {

  public listOrigin: string[] = [];

  createForm: FormGroup;

  constructor(private _formBuilder: FormBuilder,
              private productService:ProductService,
              private router:Router)
  { }

  ngOnInit(): void {
    this.productService.getListOrigin().subscribe(data => {
      this.listOrigin = data;
    }, error => {
      console.log("get "+error+" on add-product.component.ts")
    })

    this.createForm = this._formBuilder.group({
      code: ['PR-', [Validators.required, Validators.pattern('^PR-[\\d]{4}$')]],
      name: ['', Validators.required],
      price: [0, [Validators.required, Validators.min(10000), Validators.max(50000000)]],
      date: ['', [Validators.required, validateDate]],
      quantity: [0, [Validators.required, Validators.pattern('^[\\d]+$')]],
      origin: ['', [Validators.required]]
    });
  }

  submitCreateForm(createForm: FormGroup) {
    let product:Product = createForm.value;
    console.log(this.createForm.value)
    this.productService.save(product).subscribe(data => {
      this.backToList();
    }, error => {
      console.log("Get error on submitCreateForm()");
    })
  }

  backToList() {
    this.router.navigateByUrl("list");
  }
}
