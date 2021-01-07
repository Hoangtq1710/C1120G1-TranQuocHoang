package session_3.practice;

import java.util.Scanner;

public class ReverseArray {
    public static void main(String[] args) {
        System.out.println("Reverse a Array");
        Scanner scanner = new Scanner(System.in);
        int size;
        int[] array;
        do {
            System.out.println("Enter the size of Array");
            size = scanner.nextInt();
        } while (size < 1);
        array = new int[size];
        for (int i = 0; i < array.length; i++) {
            System.out.println("Element "+(i+1));
            array[i] = scanner.nextInt();
        }
        System.out.print("Array before reverse : ");
        for (int item : array) {
            System.out.print(item + " ");
        }
        System.out.println("\n");

        for (int i = 0; i < array.length/2; i++) {
            int temp = array[i];
            array[i] = array[array.length - i - 1];
            array[array.length - i - 1] = temp;
        }
        System.out.print("Array after reverse : ");
        for (int value : array) {
            System.out.print(value + " ");
        }
    }
}
