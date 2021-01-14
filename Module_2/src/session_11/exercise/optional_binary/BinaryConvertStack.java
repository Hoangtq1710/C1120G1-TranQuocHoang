package session_11.exercise.optional_binary;

import java.util.Scanner;
import java.util.Stack;

public class BinaryConvertStack {
    public static int[] binaryToArray(int n) {
        Stack<Integer> stackBinary = new Stack<>();

        while (n > 1) {
            stackBinary.push(n % 2);
            n /= 2;
        }
        stackBinary.push(n);
        for (int i = 8 - stackBinary.size() -1; i >= 0; i--) {
            stackBinary.push(0);
        }
//
//        for (int i = stackBinary.size() -1; i >= 0 ; i--) {
//            System.out.print(stackBinary.pop());
//        }

        int[] array = new int[stackBinary.size()];
        for (int i = 0; i < array.length; i++) {
            array[i] = stackBinary.pop();
        }
        return array;
    }
    public static void printPositiveBinary(int n) {
        int[] array = binaryToArray(n);
        System.out.print(n+"(10) = ");
        for(int value : array) {
            System.out.print(value);
        }
        System.out.println("(2)");
    }
    public static void printNegativeBinary(int number){
        System.out.print(number+"(10) = ");
        int n = Math.abs(number);
        int[] array = binaryToArray(n);
        for (int i = 0; i < array.length; i++) {
            if (array[i] == 0) {
                array[i] = 1;
            } else {
                array[i] = 0;
            }
        }
        array[array.length -1] = 1;
        for(int value : array) {
            System.out.print(value);
        }
        System.out.println("(2)");
    }
    public static void main(String[] args) {
        System.out.println("Convert To Binary");
        Scanner scanner = new Scanner(System.in);
        int n;
        for (int i = 0; i < 5; i++) {
            do {
                System.out.print("Enter n : ");
                n = scanner.nextInt();
                if (n < -127 || n > 128) {
                    System.out.println("n must be in range of [-127,128]");
                }
            } while (n < -127 || n > 128);
            if (n >= 0) {
                printPositiveBinary(n);
            } else {
                printNegativeBinary(n);
            }
        }
    }
}
