package session_03.exercise;

import java.util.Scanner;

public class InsertElementInArray {
    public static void main(String[] args) {
        System.out.println("Delete a Element in a Array");
        Scanner scanner = new Scanner(System.in);
        int size;
        int[] array;
        int[] result;
        int insert;
        int index;

        System.out.println("Enter the size of Array (0 < size <= 50) :");
        do {
            size = scanner.nextInt();
            if ((size <= 0) || (size > 50)) {
                System.out.println("Invalid size. Enter again!");
            }
        } while ((size <= 0) || (size > 50));

        array = new int[size];
        result = new int[size +1];
        result[size] = 0;

        for (int i = 0; i < size; i++) {
            System.out.print("Element "+i+" :");
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
        for (int item : array) {
            System.out.print(" " + item);
        }
        System.out.println("\n");

        for (int i = 0; i < array.length; i++) {
            result[i] = array[i];
            if (i == index) {
                for (int j = array.length; j > i ; j--) {
                    result[j] = array[j-1];
                }
                result[index] = insert;
                break;
            }
        }
        System.out.print("Result :");
        for(int value : result) {
            System.out.print(" "+value);
        }
        System.out.println("\n");
    }
}
