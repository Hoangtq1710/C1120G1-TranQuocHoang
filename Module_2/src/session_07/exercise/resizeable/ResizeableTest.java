package session_07.exercise.resizeable;

import session_06.practice.shape_class.Shape;

import java.util.Random;

public class ResizeableTest {
    public static void main(String[] args) {
        Shape[] shapes = new Shape[3];
        shapes[0] = new ResizeableCircle("red", true, 4.5);
        shapes[1] = new ResizeableRectangle(3.8,6.1);
        shapes[2] = new ResizeableSquare("orange",false,3.5);

        for (Shape shape : shapes) {
            System.out.print("Before resize : ");
            Random random = new Random();
            Resizeable resizeableShape = null;

            if (shape instanceof ResizeableCircle) {
                resizeableShape = (ResizeableCircle) (shape);
                System.out.println(((ResizeableCircle) shape).getArea());

            } else if (shape instanceof ResizeableRectangle) {
                resizeableShape = (ResizeableRectangle) (shape);
                System.out.println(((ResizeableRectangle) shape).getArea());

            } else if (shape instanceof ResizeableSquare) {
                resizeableShape = (ResizeableSquare) (shape);
                System.out.println(((ResizeableSquare) shape).getArea());
            }

            int percent = random.nextInt(99) +1;
            System.out.println("Percent : "+percent+" %");
            System.out.print("After resize : ");

            resizeableShape.resize(percent);
            System.out.println(resizeableShape+"\n");

        }
    }
}
