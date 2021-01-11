package session_07.exercise.resizeable;

import session_06.practice.shape_class.Rectangle;

public class ResizeableRectangle extends Rectangle implements Resizeable{
    public ResizeableRectangle() {
    }

    public ResizeableRectangle(double width, double length) {
        super(width, length);
    }

    public ResizeableRectangle(String color, boolean filled, double width, double length) {
        super(color, filled, width, length);
    }

    @Override
    public void resize(double percent) {
        System.out.println(this.getArea() * (1+ percent/100));
    }
}
