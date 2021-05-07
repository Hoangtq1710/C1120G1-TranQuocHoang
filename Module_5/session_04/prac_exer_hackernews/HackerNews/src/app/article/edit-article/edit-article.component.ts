import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {Article} from '../../model/Article';
import {Like} from '../../model/Like';

@Component({
  selector: 'app-edit-article',
  templateUrl: './edit-article.component.html',
  styleUrls: ['./edit-article.component.css']
})
export class EditArticleComponent implements OnInit {

  @Input('article') editArticle:Article | undefined;
  @Output('afterEditArticle') article =  new EventEmitter<Article>();
  constructor() { }

  ngOnInit(): void {
  }

  editArticleMethod(id:number , title: string, postTime: string, content: string, like:Like) {
    this.editArticle.id = id;
    this.editArticle.title = title;
    this.editArticle.postTime = new Date(postTime);
    this.editArticle.content = content;
    this.editArticle.like = like;

    this.article.emit(this.editArticle);
  }
}
