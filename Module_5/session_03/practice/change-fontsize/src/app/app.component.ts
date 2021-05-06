import {Component, OnInit} from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit{
  public fontSize = 14;

  constructor() {
  }

  ngOnInit(): void {
  }

  public changeFontSize(fontSize){
    this.fontSize = parseInt(fontSize);
  }

}
