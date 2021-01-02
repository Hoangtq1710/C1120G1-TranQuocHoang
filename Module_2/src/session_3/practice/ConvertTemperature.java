package session_3.practice;

import java.util.Scanner;

public class ConvertTemperature {
    public static void main(String[] args) {
        System.out.println("Convert Temperature");
        Scanner scanner = new Scanner(System.in);
        System.out.println( "Menu\n" +
                            "1. Celsius to Fahrenheit\n" +
                            "2. Fahrenheit to Celsius\n" +
                            "3. Exit");
        int menu;
        boolean flag = true;
        do {
            double temp;
            menu = scanner.nextInt();
            switch (menu) {
                case 1:
                    System.out.println("Enter the Celsius");
                    temp = scanner.nextDouble();
                    System.out.println(temp+" °C = "+Math.floor(convertCtoF(temp)*100)/100+" °F");
                    break;
                case 2:
                    System.out.println("Enter the Fahrenheit");
                    temp = scanner.nextDouble();
                    System.out.println(temp+" °F = "+Math.floor(convertFtoC(temp)*100)/100+" °C");
                    break;
                case 3:
                    flag = false;
                    break;
                default:
                    System.out.println("Failed");
                    break;
            }
        } while (flag);
    }
    public static double convertCtoF(double celsius){
        return 1.8 * celsius;
    }
    public static double convertFtoC(double fahrenheit){
        return 5.0/9 * fahrenheit;
    }
}
