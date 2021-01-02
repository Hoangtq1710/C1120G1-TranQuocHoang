package session_3.exercise;

import java.util.Scanner;

public class InsertElementInArray {
    public static void main(String[] args) {
        System.out.println("Delete a Element in a Array");
        Scanner scanner = new Scanner(System.in);
        int size;
        int[] array;
        int insert;
        int index;

        System.out.println("Enter the size of Array (0 < size <= 50) :");
        do {
            size = scanner.nextInt();
            if ((size <= 0) || (size > 50)) {
                System.out.print("Invalid size. Enter again!\n");
            }
        } while ((size <= 0) || (size > 50));

        array = new int[size +1];

        for (int i = 0; i < size; i++) {
            System.out.println("Element "+i+" :");
            array[i] = scanner.nextInt();
        }
        System.out.println("Enter the Element you wanna insert :");
        insert = scanner.nextInt();
        System.out.println("Enter the index (0 <= index <= "+(size-1)+") :");
        do {
            index = scanner.nextInt();
            if ((index < 0) || (index >= size)) {
                System.out.print("Wrong index. Input again!\n");
            }
        } while ((index < 0) || (index >= size));

        System.out.print("Array :");
        for (int i = 0; i < array.length -1; i++) {
            System.out.print(" "+array[i]);
        }
        System.out.println("\n");

        for (int i = 0; i < array.length; i++) {
            if (i == index) {
                for (int j = array.length -1; j > i ; j--) {
                    array[j] = array[j-1];
                }
                array[i] = insert;
            }
        }
        System.out.print("Array :");
        for(int value : array) {
            System.out.print(" "+value);
        }
        System.out.println("\n");
    }
}
