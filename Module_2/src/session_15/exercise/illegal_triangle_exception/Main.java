package session_15.exercise.illegal_triangle_exception;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    static int[] triangle() throws IllegalTriangleException {
        Scanner scanner = new Scanner(System.in);
        int a;
        int b;
        int c;
        try {
            System.out.print("Enter a : ");
            a = scanner.nextInt();
            System.out.print("Enter b : ");
            b = scanner.nextInt();
            System.out.print("Enter c : ");
            c = scanner.nextInt();
            if (a < 0 || b < 0 || c < 0) {
                throw new IllegalTriangleException("Number must be positive");
            }
            if ((a + b < c) || (a + c < b) || (b + c < a)) {
                throw new IllegalTriangleException("Invalid Triangle");
            }
        } catch (InputMismatchException e){
            throw new IllegalTriangleException("Input must be number");
        }
        return new int[]{a,b,c};
    }

    public static void main(String[] args) {
        System.out.println("Triangle Try - Catch");
        int[] side;
        try {
            side = triangle();
            int peri = 0;
            for(int i : side) {
                peri += i;
            }
            System.out.println("Perimeter of triangle is "+ peri);
        } catch (IllegalTriangleException e) {
            System.out.println(e.getMessage());
        }
    }
}
