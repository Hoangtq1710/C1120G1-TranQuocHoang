import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  public listCountry:string[] = ['VietNam', 'Canada', 'Japan', 'Korean', 'USA', 'Brazil'];

  rfUser:FormGroup;

  constructor(private _formBuilder:FormBuilder) {
  }

  ngOnInit(): void {
    this.rfUser = this._formBuilder.group({
      userName: ['', [Validators.required]],
      userGender: ['', Validators.required],
      userAge: [0, [Validators.required, Validators.min(18), Validators.max(100)]],
      userPhone: ['', [Validators.required, Validators.pattern('^\\+84[0-9]{9,10}$')]],
      userCountry: ['', [Validators.required]],
      userEmail: ['', [Validators.required, Validators.email]],
      userPassword: ['',[Validators.required, Validators.minLength(6)]],
    })
  }


  submitForm() {
    console.log(this.rfUser.value)
  }
}
