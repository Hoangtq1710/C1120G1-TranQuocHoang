import { Component } from '@angular/core';
import {Pet} from "./pet/Pet";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  public pet:Pet = new Pet("kin", 47, 12, "brown",
    "https://designzzz.com/wp-content/uploads/2013/11/a-beautiful-brown-dog.jpg");
}
