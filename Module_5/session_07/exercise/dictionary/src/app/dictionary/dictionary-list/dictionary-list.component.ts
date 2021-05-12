import { Component, OnInit } from '@angular/core';
import {Word} from '../../model/Word';
import {DictionaryService} from '../../service/dictionary.service';

@Component({
  selector: 'app-dictionary-list',
  templateUrl: './dictionary-list.component.html',
  styleUrls: ['./dictionary-list.component.css']
})
export class DictionaryListComponent implements OnInit {

  public list:Word[] = [];

  constructor(private _dictionaryService:DictionaryService) { }

  ngOnInit(): void {
    this.list = this._dictionaryService.list;
  }


}
