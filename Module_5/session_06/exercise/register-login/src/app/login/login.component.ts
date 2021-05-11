import {Component, Input, OnInit} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {User} from '../register/User';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  rfUserLogin:FormGroup;

  constructor(private _formBuilder:FormBuilder) { }

  ngOnInit(): void {
    this.rfUserLogin = this._formBuilder.group({
      userLoginEmail: ['', [Validators.required, Validators.email]],
      userLoginPw: ['',[Validators.required, Validators.minLength(6)]]
    })
  }

  submitLoginForm(rfUserLogin: FormGroup) {
    if( rfUserLogin.value.userLoginEmail == 'admin@gmail.com' &&
        rfUserLogin.value.userLoginPw == '123456') {
      alert("Welcome "+rfUserLogin.value.userLoginEmail.substring(0,5)+" Hoang");
    }
  }
}
