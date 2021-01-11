package session_07.practice.comparator_interface;

import session_06.practice.shape_class.Square;

import java.util.Arrays;

public class SquareComparatorTest {
    public static void main(String[] args) {
        Square[] squares = new Square[3];
        squares[0] = new Square("purple",true, 13.1);
        squares[1] = new Square(7.4);
        squares[2] = new Square();

        System.out.println("Pre-sort : ");
        for(Square square : squares) {
            System.out.println(square);
        }

        SquareComparator squareComparator = new SquareComparator();
        Arrays.sort(squares, squareComparator);

        System.out.println("After-sort : ");
        for(Square square : squares) {
            System.out.println(square);
        }
    }
}
