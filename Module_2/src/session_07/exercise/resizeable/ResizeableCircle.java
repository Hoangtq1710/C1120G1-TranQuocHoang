package session_07.exercise.resizeable;

import session_06.practice.shape_class.Circle;

public class ResizeableCircle extends Circle implements Resizeable{
    public ResizeableCircle() {
    }

    public ResizeableCircle(String color, boolean filled) {
        super(color, filled);
    }

    public ResizeableCircle(String color, boolean filled, double radius) {
        super(color, filled, radius);
    }

    @Override
    public void resize(double percent) {

        System.out.println(this.getArea() * (1 + percent/100));
    }
}
