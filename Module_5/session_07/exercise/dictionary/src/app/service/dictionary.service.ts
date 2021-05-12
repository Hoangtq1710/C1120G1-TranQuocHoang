import { Injectable } from '@angular/core';
import {Word} from '../model/Word';

@Injectable({
  providedIn: 'root'
})
export class DictionaryService {

  public list:Word[] = [
    {id: 1, keyword: 'star', means:'ngôi sao',usages:'Be a guiding Star!'},
    {id: 2, keyword: 'home', means:'ngôi nhà',usages:'A beautiful home!'},
    {id: 3, keyword: 'mouse', means:'con chuột',usages:'Catch a mouse!'},
    {id: 4, keyword: 'lamp', means:'cái đèn ngủ',usages:'Turn on the lamp, please!'},
    {id: 5, keyword: 'cup', means:'cái ly',usages:'Give me that cup of tea!'},
    {id: 6, keyword: 'white', means:'màu trắng',usages:'The shirt is white!'},
    {id: 7, keyword: 'key', means:'chìa khóa',usages:'I just lost my key!'},
  ]

  constructor() { }

  getDetailWordById(id: number) {
    console.log(id)
    for (let i = 0; i < this.list.length; i++) {
      if (this.list[i].id == id) {
        console.log(this.list[i])
        return this.list[id]
      }
    }
    return null;
  }
}
