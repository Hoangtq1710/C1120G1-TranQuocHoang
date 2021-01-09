package ExtraExer;

import java.util.Scanner;

public class Ex14_DisplayOnceElement {
    public static void main(String[] args) {
        System.out.println("Display Element Which Appear Once");
        Scanner scanner = new Scanner(System.in);
        int[] array;
        int size;

        System.out.print("Enter the size : ");
        do {
            size = scanner.nextInt();
            if (size < 0) {
                System.out.println("Size must be positive!");
            }
        } while (size <= 0);
        array = new int[size];
        for (int i = 0; i < size; i++) {
            do {
                System.out.print("Array["+i+"] : ");
                array[i] = scanner.nextInt();
            } while (array[i] < 0);
        }
        System.out.print("List of elements display once is");
        for (int item : array) {
            int count = 0;
            for (int value : array) {
                if (value == item) {
                    count++;
                }
            }
            if (count == 1) {
                System.out.print(" " + item);
            }
        }
    }
}