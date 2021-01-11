package session_07.exercise.colorable;

import session_06.practice.shape_class.Square;

public class ColorableSquare extends Square implements Colorable{
    public ColorableSquare() {
    }

    public ColorableSquare(double size) {
        super(size);
    }

    public ColorableSquare(String color, boolean filled, double size) {
        super(color, filled, size);
    }

    @Override
    public void howToColor() {
        System.out.println("Color all four sides");
    }
}
