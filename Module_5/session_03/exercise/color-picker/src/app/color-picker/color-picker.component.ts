import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-color-picker',
  templateUrl: './color-picker.component.html',
  styleUrls: ['./color-picker.component.css']
})
export class ColorPickerComponent implements OnInit {
  public title = 'Color Picker';

  public colorCode:string = "#387c73";

  constructor() { }

  ngOnInit(): void {
  }

  public getColor(red:string, green:string, blue:string){
    let redNumber:number = parseInt(red);
    let greenNumber:number = parseInt(green);
    let blueNumber:number = parseInt(blue);

    let redStr:string = redNumber.toString(16);
    let greenStr:string = greenNumber.toString(16);
    let blueStr:string = blueNumber.toString(16);

    if (redNumber < 16)   redStr = '0'+redStr;
    if (greenNumber < 16) greenStr = '0'+greenStr;
    if (blueNumber < 16)  blueStr = '0'+blueStr;

    this.colorCode = "#"+redStr+greenStr+blueStr;
  }

}
