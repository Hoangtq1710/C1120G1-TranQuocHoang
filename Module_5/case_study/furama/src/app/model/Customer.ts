export class Customer {
  private _idCustomer:string;
  private _name:string;
  private _typeCustomer:number;
  private _birthday:string;
  private _idCard:string;
  private _phone:string;
  private _email:string;
  private _address:string;


  constructor(idCustomer: string, name: string, typeCustomer: number, birthday: string,
              idCard: string, phone: string, email: string, address: string) {
    this._idCustomer = idCustomer;
    this._name = name;
    this._typeCustomer = typeCustomer;
    this._birthday = birthday;
    this._idCard = idCard;
    this._phone = phone;
    this._email = email;
    this._address = address;
  }

  get idCustomer(): string {
    return this._idCustomer;
  }

  set idCustomer(value: string) {
    this._idCustomer = value;
  }

  get name(): string {
    return this._name;
  }

  set name(value: string) {
    this._name = value;
  }

  get typeCustomer(): number {
    return this._typeCustomer;
  }

  set typeCustomer(value: number) {
    this._typeCustomer = value;
  }

  get birthday(): string {
    return this._birthday;
  }

  set birthday(value: string) {
    this._birthday = value;
  }

  get idCard(): string {
    return this._idCard;
  }

  set idCard(value: string) {
    this._idCard = value;
  }

  get phone(): string {
    return this._phone;
  }

  set phone(value: string) {
    this._phone = value;
  }

  get email(): string {
    return this._email;
  }

  set email(value: string) {
    this._email = value;
  }

  get address(): string {
    return this._address;
  }

  set address(value: string) {
    this._address = value;
  }
}
