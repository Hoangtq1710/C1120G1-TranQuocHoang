package session_02.exercise;

import java.util.Scanner;

import static session_02.practice.DesignMenu.Rectangle;

public class DisplayPolymorphism {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Display Something");
        System.out.println( "Menu\n" +
                            "1. Rectangle\n" +
                            "2. Square Triangle\n" +
                            "3. Isosceles Triangle\n" +
                            "4. Exit");
        boolean flag = true;
        do {
            int menu = scanner.nextInt();
            switch (menu) {
                case 1:
                    Rectangle();
                    break;
                case 2:
                    SquareTriangle();
                    break;
                case 3:
                    IsoscelesTriangle();
                    break;
                case 4:
                    flag = false;
                    break;
                default:
                    break;
            }
        } while (flag);

    }
    public static void SquareTriangle(){
        int edge = 5;
        //first
        for (int i = 1; i <= edge; i++) {
            for (int j = i; j > 0; j--) {
                System.out.print("*");
            }
            for (int j = edge - 1; j > 0; j--) {
                System.out.print(" ");
            }
            System.out.print("\n");
        }
        System.out.print("\n");
        //second
        for (int i = 1; i <= edge; i++) {
            for (int j = edge - i; j > 0; j--) {
                System.out.print(" ");
            }
            for (int j = i; j > 0; j--) {
                System.out.print("*");
            }
            System.out.print("\n");
        }
        System.out.print("\n");
        //third
        for (int i = 0; i < edge; i++) {
            for (int j = edge - i; j > 0; j--) {
                System.out.print("*");
            }
            for (int j = 0; j < i; j++) {
                System.out.print(" ");
            }
            System.out.print("\n");
        }
        System.out.print("\n");
        //fourth
        for (int i = 0; i < edge; i++) {
            for (int j = i; j > 0; j--) {
                System.out.print(" ");
            }
            for (int j = edge - i; j > 0; j--) {
                System.out.print("*");
            }
            System.out.print("\n");
        }
    }

    public static void IsoscelesTriangle(){
        int a = 1;
        int b = 6;
        int height = 6;
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < b; j++) {
                System.out.print(" ");
            }
            for (int j = 0; j < a; j++) {
                System.out.print("*");
            }
            for (int j = 0; j < b; j++) {
                System.out.print(" ");
            }
            System.out.print("\n");
            a += 2;
            b -= 1;
        }
    }
}
