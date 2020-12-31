package session_1.practice;

import java.util.Scanner;

public class AreaRectangle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < 2; i++) {
            System.out.println("Enter Width : ");
            float width = scanner.nextFloat();
            System.out.println("Enter Height : ");
            float height = scanner.nextFloat();

            float area = width * height;
            float perimeter = (width+height) *2;

            System.out.println("Area of Rectangle : "+area);
            System.out.println("Perimeter of Rectangle : "+perimeter);
        }
    }
}
