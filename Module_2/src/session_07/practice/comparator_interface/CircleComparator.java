package session_07.practice.comparator_interface;

import session_06.practice.shape_class.Circle;

import java.util.Comparator;

public class CircleComparator implements Comparator<Circle> {

    @Override
    public int compare(Circle circle1, Circle circle2) {
        if (circle1.getRadius() > circle2.getRadius()) {
            return 1;
        } else if (circle1.getRadius() < circle2.getRadius()) {
            return -1;
        } else {
            return 0;
        }
    }
}
