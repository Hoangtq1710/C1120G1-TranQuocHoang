import {Component, EventEmitter, OnInit, Output} from '@angular/core';
import {Article} from '../../model/Article';
import {Like} from '../../model/Like';

@Component({
  selector: 'app-add-article',
  templateUrl: './add-article.component.html',
  styleUrls: ['./add-article.component.css']
})
export class AddArticleComponent implements OnInit {
  public article:Article;

  @Output('article') createArticle = new EventEmitter<Article>();
  constructor() { }

  ngOnInit(): void {
  }

  addArticle(id:string, title:string, postTime:string, content:string) {
    this.article = new Article(parseInt(id), title, new Date(postTime), content, new Like(0));
    this.createArticle.emit(this.article);
  }
}
