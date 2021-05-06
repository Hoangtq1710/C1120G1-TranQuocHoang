export class Pet {
  private _name:string;
  private _height:number;
  private _weight:number;
  private _color:string;
  private _image:string;


  constructor(name: string, height: number, weight: number, color: string, image: string) {
    this._name = name;
    this._height = height;
    this._weight = weight;
    this._color = color;
    this._image = image;
  }


  get name(): string {
    return this._name;
  }

  set name(value: string) {
    this._name = value;
  }

  get height(): number {
    return this._height;
  }

  set height(value: number) {
    this._height = value;
  }

  get weight(): number {
    return this._weight;
  }

  set weight(value: number) {
    this._weight = value;
  }

  get color(): string {
    return this._color;
  }

  set color(value: string) {
    this._color = value;
  }

  get image(): string {
    return this._image;
  }

  set image(value: string) {
    this._image = value;
  }
}
