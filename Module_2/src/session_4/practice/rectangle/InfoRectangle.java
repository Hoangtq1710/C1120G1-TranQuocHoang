package session_4.practice.rectangle;

import java.util.Scanner;

public class InfoRectangle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double width;
        double height;
        System.out.println("Enter the width : ");
        width = scanner.nextDouble();
        System.out.println("Enter the height : ");
        height = scanner.nextDouble();

        Rectangle rect = new Rectangle(width,height);
        System.out.println("Display : "+ rect.display()+"\n");
        System.out.println("Area : "+rect.getArea()+"\n");
        System.out.println("Perimeter : "+rect.getPerimeter()+"\n");
    }
}

