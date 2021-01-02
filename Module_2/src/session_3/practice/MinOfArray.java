package session_3.practice;

import java.util.Scanner;

public class MinOfArray {
    public static void main(String[] args) {
        System.out.println("Min Of Array");
        Scanner scanner = new Scanner(System.in);
        int size;
        int[] array;
        System.out.println("Enter the size of array (0 < size <= 50)");
        do {
            size = scanner.nextInt();
        } while ((size <= 0) || (size > 50));
        array = new int[size];
        for (int i = 0; i < size; i++) {
            System.out.println("Element "+ (i+1));
            array[i] = scanner.nextInt();
         }
        System.out.print("Array : ");
        for(int value : array) {
            System.out.print(value+" ");
        }
        System.out.println("\n");
        int min = array[0];
        for(int value : array) {
            if (min > value) {
                min  = value;
            }
        }
        System.out.println("Min of Array is "+min);
    }
}
