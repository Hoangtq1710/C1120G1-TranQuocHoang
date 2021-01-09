package ExtraExer;

import java.util.Arrays;
import java.util.Scanner;

public class Ex16_DisplayTimesAppear {
    public static void main(String[] args) {
        System.out.println("Display Times Appear of Element");
        Scanner scanner = new Scanner(System.in);
        int[] array;
        int[] sub;
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
        sub = new int[size];
        Arrays.fill(sub, -1);for (int i = 0; i < array.length; i++) {
            int count = 0;
            for (int value : sub) {
                if (array[i] == value) {
                    count++;
                }
            }
            if (count == 0) {
                sub[i] = array[i];
            }
        }

        System.out.println("List of display times is : ");
        for(int item : sub) {
            int count = 0;
            for(int value : array) {
                if (item == value){
                    count++;
                }
            }
            if (item != -1){
                System.out.println(item+" : "+count);
            }
        }
    }
}
