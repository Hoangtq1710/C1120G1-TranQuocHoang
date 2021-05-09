import {Component, Input, OnInit} from '@angular/core';

@Component({
  selector: 'app-progress',
  templateUrl: './progress.component.html',
  styleUrls: ['./progress.component.css']
})
export class ProgressComponent implements OnInit {

  @Input('percentShow') percent:number;
  public message:string;

  constructor() { }

  ngOnInit(): void {
  }

  public internalPro;

  public startProgress(){
    this.internalPro = setInterval(x => this.plusPercent(), 1000);
  }

  public plusPercent(){
    let progress = document.getElementById('progress');
    ++this.percent;
    progress.style.width = this.percent.toString()+'%';
    if (this.percent == 100) {
      this.message = 'Progress is done';
      clearInterval(this.internalPro);
      return;
    }
  }

  public stopProgress(){
    clearInterval(this.internalPro)
  }

  public resetProgress() {
    let progress = document.getElementById('progress');
    clearInterval(this.internalPro);
    this.percent = 0;
    progress.style.width = this.percent.toString()+'%';
  }
}
