import {Shapes} from "./Shape";
import {ShapeInterface} from "./ShapeInterface";

export class Rectangle extends Shapes implements ShapeInterface{
    private _color:string;


    constructor(x: number, y: number, color: string) {
        super(x, y);
        this._color = color;
    }


    get color(): string {
        return this._color;
    }

    set color(value: string) {
        this._color = value;
    }

    getArea(): number {
        return this.x * this.y;
    }

    showInfor(): string {
        return "Rectangle has width = "+this.x+", height = "+this.y+", color is "+this.color+". Area is "+ this.getArea();
    }

}
