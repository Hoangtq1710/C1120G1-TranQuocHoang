import {Component, OnInit} from '@angular/core';

@Component({
  selector: 'app-countdown',
  templateUrl: './countdown.component.html',
  styleUrls: ['./countdown.component.css']
})
export class CountdownComponent implements OnInit {
  public message:string;

  public min:number = 0;
  public sec:number = 10;

  public minuteStr:string = '02';
  public secondStr:string = '00';

  constructor() { }

  ngOnInit(): void {
  }
  public interval;

  decrease(){
    if (this.min == 0 && this.sec == 0){
      this.message = 'Over!';
      clearInterval(this.interval); // stop Countdown
      return; // !important
      // stop decrease loop avoid minutes = -1;
      // if this statement is not present, when minutes = 0 then Countdown will show minute = -1 and second = 59
    }
    if (this.sec == 0) {
      this.sec = 60;
      this.min--; //only decrease minute if second is 0
    }
    this.sec--; // decrease sec every second

    this.minuteStr = (this.min < 10) ? '0'+this.min : ''+this.min;
    this.secondStr = (this.sec < 10) ? '0'+this.sec : ''+this.sec;
  }

  start() {
    this.interval = setInterval(x => this.decrease(), 1000); // every 1s
  }

  stop() {
    clearInterval(this.interval);
  }

  reset() {
    clearInterval(this.interval);
    this.min = 2;
    this.sec = 0;
    this.minuteStr = '0'+this.min;
    this.secondStr = '0'+this.sec;
    this.message = '';
  }
}
