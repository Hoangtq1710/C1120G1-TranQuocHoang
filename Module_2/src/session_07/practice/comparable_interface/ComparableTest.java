package session_07.practice.comparable_interface;

import java.util.Arrays;

public class ComparableTest {
    public static void main(String[] args) {
        ComparableCircle[] circles = new ComparableCircle[3];
        circles[0] = new ComparableCircle(4.2);
        circles[1] = new ComparableCircle();
        circles[2] = new ComparableCircle("yellow",false,2.9);

        System.out.println("Pre-sort : ");
        for(ComparableCircle comparableCircle : circles) {
            System.out.println(comparableCircle);
        }

        Arrays.sort(circles);

        System.out.println("After-sorted : ");
        for(ComparableCircle comparableCircle : circles) {
            System.out.println(comparableCircle);
        }
    }
}
