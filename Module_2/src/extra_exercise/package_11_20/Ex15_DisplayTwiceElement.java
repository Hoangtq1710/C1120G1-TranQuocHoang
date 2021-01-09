package extra_exercise.package_11_20;

import java.util.Arrays;
import java.util.Scanner;

public class Ex15_DisplayTwiceElement {
    public static void main(String[] args) {
        System.out.println("Display Element Which Appear Twice");
        Scanner scanner = new Scanner(System.in);
        int[] array;
        int size;
        int[] sub;

        System.out.print("Enter the size : ");
        do {
            size = scanner.nextInt();
            if (size < 0) {
                System.out.println("Size must be positive!");
            }
        } while (size <= 0);
        array = new int[size];
        sub = new int[size];
        Arrays.fill(sub, -1);

        for (int i = 0; i < size; i++) {
            do {
                System.out.print("Array["+i+"] : ");
                array[i] = scanner.nextInt();
            } while (array[i] < 0);
        }
        for (int i = 0; i < array.length; i++) {
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
        System.out.print("List of elements display twice is");
        for(int item : sub) {
            int count = 0;
            for(int value : array) {
                if (item == value){
                    count++;
                }
            }
            if (item != -1 && count == 2){
                System.out.print(" "+item);
            }
        }
    }
}
