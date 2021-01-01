package session_2.practice;

import java.util.Scanner;

public class DesignMenu {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Draw Something");
        System.out.println( "Menu\n" +
                            "1. Draw a Triangle\n" +
                            "2. Draw a Rectangle\n" +
                            "3. Draw a Square\n" +
                            "0. Exit");
        boolean flag = true;
        do {
            int menu = scanner.nextInt();
            switch (menu) {
                case 1:
                    Triangle();
                    break;
                case 2:
                    Rectangle();
                    break;
                case 3:
                    Square();
                    break;
                case 0:
                    flag = false;
                    break;
                default:
                    System.out.println("Failed");
                    break;
            }
        } while (flag);

    }
    public static void Triangle(){
        for (int i = 1; i <= 5; i++) {
            for (int j = i; j > 0; j--) {
                System.out.print("*");
            }
            for (int k = 4; k > 0 ; k--) {
                System.out.print(" ");
            }
            System.out.println("\n");
        }
    }

    public static void Rectangle() {
        int width = 10;
        int height = 5;
        for (int i = 0; i < width; i++) {
            System.out.print("*");
        }
        System.out.println("\n");
        for (int i = 0; i < height - 2; i++) {
            System.out.print("*");
            for (int j = 0; j < width - 2; j++) {
                System.out.print(" ");
            }
            System.out.print("*");
            System.out.println("\n");
        }
        for (int i = 0; i < width; i++) {
            System.out.print("*");
        }
        System.out.println("\n");
    }

    public static void Square() {
        int edge = 6;
        for (int i = 0; i < edge; i++) {
            System.out.print("*");
        }
        System.out.println("\n");
        for (int i = 0; i < edge - 2; i++) {
            System.out.print("*");
            for (int j = 0; j < edge - 2; j++) {
                System.out.print(" ");
            }
            System.out.print("*");
            System.out.println("\n");
        }
        for (int i = 0; i < edge; i++) {
            System.out.print("*");
        }
        System.out.println("\n");
    }
}
