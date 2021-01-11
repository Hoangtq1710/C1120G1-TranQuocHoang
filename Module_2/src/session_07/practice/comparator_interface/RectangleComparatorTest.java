package session_07.practice.comparator_interface;

import session_06.practice.shape_class.Rectangle;

import java.util.Arrays;

public class RectangleComparatorTest {
    public static void main(String[] args) {
        Rectangle[] rectangles = new Rectangle[3];
        rectangles[0] = new Rectangle();
        rectangles[1] = new Rectangle(4.5,7.8);
        rectangles[2] = new Rectangle("brown", false, 3.6,4.5);

        System.out.println("Pre-sort : ");
        for(Rectangle rectangle : rectangles) {
            System.out.println(rectangle);
        }

        RectangleComparator rectangleComparator = new RectangleComparator();
        Arrays.sort(rectangles, rectangleComparator);

        System.out.println("After-sort : ");
        for(Rectangle rectangle : rectangles) {
            System.out.println(rectangle);
        }
    }
}
