export class Product {
  private _id:number;
  private _name:string;
  private _price:number;
  private _date:Date;
  private _quantity:number;
  private _origin:string;


  constructor(id: number, name: string, price: number, date: Date, quantity: number, origin: string) {
    this._id = id;
    this._name = name;
    this._price = price;
    this._date = date;
    this._quantity = quantity;
    this._origin = origin;
  }


  get id(): number {
    return this._id;
  }

  set id(value: number) {
    this._id = value;
  }

  get name(): string {
    return this._name;
  }

  set name(value: string) {
    this._name = value;
  }

  get price(): number {
    return this._price;
  }

  set price(value: number) {
    this._price = value;
  }

  get date(): Date {
    return this._date;
  }

  set date(value: Date) {
    this._date = value;
  }

  get quantity(): number {
    return this._quantity;
  }

  set quantity(value: number) {
    this._quantity = value;
  }

  get origin(): string {
    return this._origin;
  }

  set origin(value: string) {
    this._origin = value;
  }
}
