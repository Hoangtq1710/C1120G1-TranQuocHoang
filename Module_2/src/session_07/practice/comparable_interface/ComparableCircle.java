package session_07.practice.comparable_interface;

import session_06.practice.shape_class.Circle;

public class ComparableCircle extends Circle implements Comparable<ComparableCircle>{
    public ComparableCircle() {
    }
    public ComparableCircle(double radius) {
        super(radius);
    }

    public ComparableCircle(String color, boolean filled , double radius) {
        super(color, filled, radius);
    }

    @Override
    public int compareTo(ComparableCircle circle) {
        if (getRadius() > circle.getRadius()) {
            return 1;
        } else if (getRadius() < circle.getRadius()) {
            return -1;
        } else return 0;
    }
}
