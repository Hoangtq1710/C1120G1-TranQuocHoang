import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-rating',
  templateUrl: './rating.component.html',
  styleUrls: ['./rating.component.css']
})
export class RatingComponent implements OnInit {
  public star:number = 0;

  constructor() { }

  ngOnInit(): void {
  }

  showRateInfo(comment:string){
    let msg:string = '';

    if (this.star == 0) {
      msg = "You didn't vote!";
      alert(msg);
      return;
    }
    if (comment != '') {
      msg = "You voted "+this.star+" stars!\nYour comment is : "+comment;
    } else {
      msg = "You voted "+this.star+" stars and no comment!";
    }
    alert(msg);
    return;
  }

  getStar(star: number) {
    this.star = star;
  }

  changeColor() {
    document.getElementById('btnRating').style.backgroundColor = 'palevioletred'
  }
}
