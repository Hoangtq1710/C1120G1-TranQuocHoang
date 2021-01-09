package ExtraExer;

import java.util.Scanner;
//in ra tổng các kí tự số có trong 1 số nguyên
public class Ex03_SumDigitInteger {
    public static Integer SumDigit(long number) {
        String str;
        int[] array;
        int sum = 0;
        str = Long.toString(number);
        array = new int[str.length()];
        int pow = str.length() -1;
        for (int i = 0; i < str.length(); i++) {
            array[i] = (int) (number/(Math.pow(10, pow)));
            number = (int) (number - array[i]*Math.pow(10, pow));
            pow -= 1;
        }
        for(int value : array) {
            sum += value;
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println("Sum Of Digits Integer");
        long number;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number : ");
        do {
            number = scanner.nextLong();
            if (number < 1) {
                System.out.println("Please enter the positive number");
            }
        } while (number < 1);
        System.out.println("Sum of digits integer number is "+ Ex03_SumDigitInteger.SumDigit(number));
    }
}
