import {ShapeInterface} from "./ShapeInterface";
import {Rectangle} from "./Rectangle";

export class Square extends Rectangle implements ShapeInterface{

    constructor(edge:number, color:string) {
        super(edge,edge,color);
    }

    showInfor(): string {
        return "Square has edge = "+this.x+", color is "+this.color+". Area is "+this.getArea();
    }
}
