package session_03.practice;

import java.util.Scanner;

public class MaxOfArray {
    public static void main(String[] args) {
        System.out.println("Max Of Array");
        Scanner scanner = new Scanner(System.in);
        int size;
        int[] array;
        System.out.println("Enter the size of Array");
        do {
            size = scanner.nextInt();
            if ((size > 50) || (size < 1)) {
                System.out.println("Enter the size between 1 and 50");
            }
        } while ((size > 50) || (size < 1));
        array = new int[size];
        for (int i = 0; i < array.length; i++) {
            System.out.println("Element "+(i+1));
            array[i] = scanner.nextInt();
        }
        System.out.print("Array : ");
        for(int value : array) {
            System.out.print(value + " ");
        }
        System.out.println("\n");
        int max = array[0];
        for (int value : array) {
            if (max < value) {
                max = value;
            }
        }
        System.out.println("Max of array is "+max);
    }
}