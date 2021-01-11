package session_07.practice.comparator_interface;

import session_06.practice.shape_class.Circle;

import java.util.Arrays;

public class CircleComparatorTest {
    public static void main(String[] args) {
        Circle[] circles = new Circle[3];

        circles[0] = new Circle();
        circles[1] = new Circle(7.4);
        circles[2] = new Circle("pink", true, 2.4);

        System.out.println("Pre-sort : ");
        for(Circle circle : circles) {
            System.out.println(circle);
        }

        CircleComparator circleComparator = new CircleComparator();
        Arrays.sort(circles, circleComparator);

        System.out.println("After-sort : ");
        for(Circle circle : circles) {
            System.out.println(circle);
        }
    }
}
