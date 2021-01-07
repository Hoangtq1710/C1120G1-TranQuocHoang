package session_03.exercise;

import java.util.Scanner;

public class DeleteElementInArray {
    public static void main(String[] args) {
        System.out.println("Delete a Element In Array");
        Scanner scanner = new Scanner(System.in);
        int size;
        int[] array;
        int delete;

        System.out.println("Enter the size of Array (0 < size <= 50) :");
        do {
            size = scanner.nextInt();
        } while ((size < 1) || (size > 50));
        array = new int[size];
        for (int i = 0; i < size; i++) {
            System.out.println("Element "+(i+1));
            array[i] = scanner.nextInt();
        }

        System.out.println("Enter a element you wanna delete");
        delete = scanner.nextInt();
        System.out.print("Array :");
        for(int value : array) {
            System.out.print(" "+value);
        }
        System.out.println("\n");

        for (int i = 0; i < array.length; i++) {
            if (array[i] == delete) {
                for (int j = i; j < array.length -1; j++) {
                    array[j] = array[j+1];
                }
            }
            if (i == array.length -1) {
                array[array.length - 1] = 0;
            }
        }
        System.out.print("Array :");
        for(int value : array) {
            System.out.print(" "+value);
        }
        System.out.println("\n");
    }
}
