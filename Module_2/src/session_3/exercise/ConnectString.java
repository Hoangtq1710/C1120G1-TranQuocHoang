package session_3.exercise;
import java.util.Scanner;

public class ConnectString {
    public static void main(String[] args) {
        System.out.println("Con Cat Function");
        Scanner scanner = new Scanner(System.in);
        int size1;
        int size2;
        int size3;
        int[] array1;
        int[] array2;
        int[] array3;
        System.out.println("Enter the size of Array 1");
        size1 = scanner.nextInt();
        array1 = new int[size1];
        for (int i = 0; i < size1; i++) {
            System.out.println("Element " + i);
            array1[i] = scanner.nextInt();
        }

        System.out.println("Enter the size of Array 2");
        size2 = scanner.nextInt();
        array2 = new int[size2];
        for (int i = 0; i < size2; i++) {
            System.out.println("Element " + i);
            array2[i] = scanner.nextInt();
        }

        size3 = size1 + size2;
        array3 = new int[size3];
        for (int i = 0; i < array1.length; i++) {
            array3[i] = array1[i];
        }
        for (int i = 0; i < array2.length; i++) {
            array3[i + array1.length] = array2[i];
        }
        System.out.print("Array 1 :");
        for (int element : array1) {
            System.out.print(" " + element);
        }
        System.out.println("\n");

        System.out.print("Array 2 :");
        for (int element : array2) {
            System.out.print(" " + element);
        }
        System.out.println("\n");

        System.out.print("Array 3 :");
        for (int value : array3) {
            System.out.print(" " + value);
        }
    }
}
