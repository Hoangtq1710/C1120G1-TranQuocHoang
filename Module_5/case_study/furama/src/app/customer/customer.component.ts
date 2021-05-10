import {Component, Input, OnInit} from '@angular/core';
import {Customer} from "../model/Customer";

@Component({
  selector: 'app-customer',
  templateUrl: './customer.component.html',
  styleUrls: ['./customer.component.scss']
})
export class CustomerComponent implements OnInit {


  public listCustomer:Customer[] = [
    new Customer('KH-1410','Hoang',1,'1995-10-17','205148565',
      '0904121036', 'hoang@gmail.com','Quang Nam'),
    new Customer('KH-0306','Vi',2,'1992-03-06','205962417',
      '0901254887', 'vi.36@gmail.com','Da Nang'),
    new Customer('KH-7484','Thuan',3,'1998-08-14','205166748',
      '0901248745', 'thuan@gmail.com','Hue'),
    new Customer('KH-1187','Quang',4,'1993-09-24','205004896',
      '0905484130', 'quang@gmail.com','Da Nang'),
    new Customer('KH-2405','Nhan',1,'1995-05-24','205730294',
      '0905964512', 'nhan@gmail.com','Quang Nam')
  ]

  constructor() { }

  ngOnInit(): void {
  }

}
