export class Product {

  private _id:number;
  private _name:string;
  private _price:number;
  private _quantity:number;
  private _manufacture:string;


  constructor(id: number, name: string, price: number, quantity: number, manufacture: string) {
    this._id = id;
    this._name = name;
    this._price = price;
    this._quantity = quantity;
    this._manufacture = manufacture;
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

  get quantity(): number {
    return this._quantity;
  }

  set quantity(value: number) {
    this._quantity = value;
  }

  get manufacture(): string {
    return this._manufacture;
  }

  set manufacture(value: string) {
    this._manufacture = value;
  }
}
