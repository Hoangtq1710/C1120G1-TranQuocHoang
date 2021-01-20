package session_13.optional.optional_binary_search_recursive;

import java.util.Scanner;

public class BinarySearchRecursive {

    public static int binaryRecursive(int[] array, int start, int end, int value) {

        int mid = (start + end) / 2;
        if (start > end) {
            return -1;
        } else {
            if (array[mid] == value) {
                return mid;
            } else if (value < array[mid]) {
                return binaryRecursive(array, start, mid - 1, value);
            } else {
                return binaryRecursive(array, mid + 1, end, value);
            }
        }
    }

    public static void main(String[] args) {
        int[] list = {2, 4, 5, 6, 7, 9, 10, 12, 15, 18, 21, 27, 30, 34, 38, 41, 46, 49, 60};
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a value : ");
        int value = scanner.nextInt();
        int index = binaryRecursive(list, 0, list.length - 1, value);
        if (index != -1) {
            System.out.println(value + " is found in list at index " + index);
        } else {
            System.out.println("NOT found");
        }
    }
}
