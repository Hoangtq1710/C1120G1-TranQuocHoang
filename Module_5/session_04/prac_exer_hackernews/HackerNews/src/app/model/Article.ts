import {Like} from './Like';

export class Article {
  private _id:number;
  private _title:string;
  private _postTime:Date;
  private _content:string;
  private _like:Like;


  constructor(id: number, title: string, postTime: Date, content: string, like: Like) {
    this._id = id;
    this._title = title;
    this._postTime = postTime;
    this._content = content;
    this._like = like;
  }


  get id(): number {
    return this._id;
  }

  set id(value: number) {
    this._id = value;
  }

  get title(): string {
    return this._title;
  }

  set title(value: string) {
    this._title = value;
  }

  get postTime(): Date {
    return this._postTime;
  }

  set postTime(value: Date) {
    this._postTime = value;
  }

  get content(): string {
    return this._content;
  }

  set content(value: string) {
    this._content = value;
  }

  get like(): Like {
    return this._like;
  }

  set like(value: Like) {
    this._like = value;
  }
}
