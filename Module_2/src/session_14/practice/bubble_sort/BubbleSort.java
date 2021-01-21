package session_14.practice.bubble_sort;

public class BubbleSort {
    static int[] list = {7, 5, 11, 2, 9, 4, 13, 6, 18, 74, 12, 10};

    public static void bubbleSort(int[] array) {
        boolean needNextPass = true;
        for (int i = 1; i < array.length && needNextPass; i++) {
            needNextPass = false;
            for (int j = 0; j < array.length - i; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    needNextPass = true;
                }
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("Bubble Sort Algorithm");
        bubbleSort(list);
        for (int value : list) {
            System.out.print(value + " ");
        }
    }
}
