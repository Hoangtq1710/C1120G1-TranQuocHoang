package ExtraExer;

import java.util.Scanner;

public class Ex19_SumDigitPrime {
    public static boolean sumDigitOfPrime(int number, int s) {
        String str = Integer.toString(number);
        int n = str.length();
        int[] array = new int[n];
        int sum = 0;
        int pow;
        int temp = number;
        for (int i = 0; i < n; i++) {
            pow = (int) Math.pow(10, (n - i -1));
            array[i] = temp / pow;
            temp -= array[i] * pow;
        }
        for(int value : array){
            sum += value;
        }
        return sum == s;
    }

    public static void main(String[] args) {
        System.out.println("Checking Sum of Digits of Prime");
        Scanner scanner = new Scanner(System.in);
        int number;
        System.out.print("Enter the number : ");
        number = scanner.nextInt();
        System.out.print("Enter the sum : ");
        int sum = scanner.nextInt();
        if (sumDigitOfPrime(number, sum)){
            System.out.println("Summary of Digits Prime equals to Sum");
        } else {
            System.out.println("Summary of Digits Prime NOT equals to Sum");
        }
    }
}
