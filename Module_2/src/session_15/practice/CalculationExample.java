package session_15.practice;

import java.util.Scanner;

public class CalculationExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter x : ");
        int x = scanner.nextInt();
        System.out.print("Enter y : ");
        int y = scanner.nextInt();
        calculate(x, y);
    }
    public static void calculate(int x, int y){
        try {
            int a = x + y;
            int b = x - y;
            int c = x * y;
            int d = x / y;
            System.out.println("Sumary of "+x+" and "+y+" is "+a);
            System.out.println("Minus of "+x+" and "+y+" is "+b);
            System.out.println("Multiple of "+x+" and "+y+" is "+c);
            System.out.println("Divine of "+x+" and "+y+" is "+d);
        } catch (Exception e){
            System.out.println("Exception is : "+e.getMessage());
        }
    }
}
