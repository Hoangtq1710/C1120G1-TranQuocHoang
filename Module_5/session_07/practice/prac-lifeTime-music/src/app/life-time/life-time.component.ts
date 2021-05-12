import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {birthdayValidate} from '../validators/BirthdayValidators';
import {LifetimeService} from '../service/lifetime.service';

@Component({
  selector: 'app-life-time',
  templateUrl: './life-time.component.html',
  styleUrls: ['./life-time.component.css']
})
export class LifeTimeComponent implements OnInit {

  lifeTimeForm:FormGroup;
  lifeDay:string;

  constructor(private formBuilder:FormBuilder,
              private lifetimeService:LifetimeService)
  { }

  ngOnInit(): void {
    this.lifeTimeForm = this.formBuilder.group({
      birthday: ['', [Validators.required, birthdayValidate]]
    })
  }

  submitLifeTime(lifeTimeForm: FormGroup) {
    this.lifeDay = this.lifetimeService.getLifeTime(lifeTimeForm.value["birthday"]);
  }
}
