import { Component, OnInit } from '@angular/core';
import {Word} from '../../model/Word';
import {DictionaryService} from '../../service/dictionary.service';
import {ActivatedRoute, Router} from '@angular/router';

@Component({
  selector: 'app-details',
  templateUrl: './details.component.html',
  styleUrls: ['./details.component.css']
})
export class DetailsComponent implements OnInit {

  public detailWord:Word;

  constructor(private _dictionaryService:DictionaryService,
              private _activatedRoute:ActivatedRoute,
              private router:Router) { }

  ngOnInit(): void {
    let id = this._activatedRoute.snapshot.params['id'];
    this.detailWord = this._dictionaryService.getDetailWordById(parseInt(id));
  }

  backToList() {
    this.router.navigateByUrl("dictionary");
  }
}
