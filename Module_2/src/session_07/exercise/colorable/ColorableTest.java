package session_07.exercise.colorable;

import session_06.practice.shape_class.Circle;
import session_06.practice.shape_class.Rectangle;
import session_06.practice.shape_class.Shape;

public class ColorableTest {
    public static void main(String[] args) {
        Shape[] shapes = new Shape[4];
        shapes[0] = new Circle("yellow", true, 5.2);
        shapes[1] = new Rectangle("gray", false, 6.1, 4.2);
        shapes[2] = new ColorableSquare("black",true, 6.7);
        shapes[3] = new ColorableSquare(8.1);

        for(Shape shape : shapes){
            System.out.println(shape);
            if (shape instanceof ColorableSquare) {
                ((Colorable) (shape)).howToColor();
            }
        }
    }
}