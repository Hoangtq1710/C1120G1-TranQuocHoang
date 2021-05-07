export class Like {
  private _like:number;

  constructor(like: number) {
    this._like = like;
  }

  get like(): number {
    return this._like;
  }

  set like(value: number) {
    this._like = value;
  }
}
