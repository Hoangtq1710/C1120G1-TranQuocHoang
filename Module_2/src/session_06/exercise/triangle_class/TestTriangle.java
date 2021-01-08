package session_06.exercise.triangle_class;

import java.util.Scanner;

public class TestTriangle {
    public static void main(String[] args) {
        System.out.println("Triangle");
        Scanner scanner = new Scanner(System.in);
        double a;
        double b;
        double c;
        String color = "";

        do {
            System.out.print("Enter a : ");
            a = scanner.nextDouble();
            if (a <= 0) {
                System.out.println("a must be positive!");
            }
        } while (a <= 0);

        do {
            System.out.print("Enter b : ");
            b = scanner.nextDouble();
            if (b <= 0) {
                System.out.println("b must be positive!");
            }
        } while (b <= 0);

        do {
            System.out.print("Enter c : ");
            c = scanner.nextDouble();
            if (c <= 0) {
                System.out.println("c must be positive!");
            }
        } while (c <= 0);

        scanner.nextLine();
        System.out.print("Enter color : ");
        color = scanner.nextLine();

        Triangle triangle = new Triangle(a,b,c);
        triangle.setColor(color);

        System.out.println(triangle);
    }
}
