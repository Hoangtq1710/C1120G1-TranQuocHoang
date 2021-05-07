import {Component, Input, OnInit} from '@angular/core';
import {Article} from '../model/Article';
import {Like} from '../model/Like';

@Component({
  selector: 'app-article',
  templateUrl: './article.component.html',
  styleUrls: ['./article.component.css']
})
export class ArticleComponent implements OnInit {

  public editArticle:Article;
  constructor() { }

  ngOnInit(): void {
  }

  public listArticle:Article[] = [
    new Article(1,'Lost a Dog',
      new Date('Fri May 07 2021 11:05:23 GMT+0700 (Indochina Time)'),
      'Anyone found my dog can contact me via number 7914-451-412',
      new Like(2)),

    new Article(2,'Dumpy Fish',
      new Date('Fri May 07 2021 11:15:54 GMT+0700 (Indochina Time)'),
      'My fish was so dumpy. She try to attack herself while look at the glassy wall',
      new Like(6)),

    new Article(3,'Fantastic Movie Show',
      new Date('Fri May 07 2021 11:17:07 GMT+0700 (Indochina Time)'),
      'Fast and Furious 9 is on theatre. Watch now!',
      new Like(14)),

    new Article(4,'Moon Light',
      new Date('Fri May 07 2021 11:19:37 GMT+0700 (Indochina Time)'),
      'I saw a Ninja with Silver sword and black shadow',
      new Like(3)),
  ];

  public hitLikeBtn(id:number):void {
    for(let article of this.listArticle) {
      if (article.id == id) {
        article.like.like++;
        return;
      }
    }
  }

  addArticle(value: Article) {
    this.listArticle.push(value);
  }

  showEditArticle(article: Article) {
    this.editArticle = article;
  }
}
