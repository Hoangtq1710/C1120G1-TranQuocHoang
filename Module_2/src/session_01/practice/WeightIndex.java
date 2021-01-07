package session_01.practice;

import java.util.Scanner;

public class WeightIndex {
    public static void main(String[] args) {
        System.out.println("Weight Index");
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter your weight");
        float weight = scanner.nextFloat();

        System.out.println("Enter your height");
        float height = scanner.nextFloat();

        float bmi = weight / (height * height);

        if (bmi < 18.5) {
            System.out.println("Underweight");
        } else if (bmi < 25) {
            System.out.println("Normal");
        } else if (bmi < 30) {
            System.out.println("Overweight");
        } else {
            System.out.println("Obese");
        }
    }
}
