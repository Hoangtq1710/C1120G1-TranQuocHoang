package session_14.practice.bubble_sort;

public class BubbleSort {
    static int[] list = {7,5,11,2,9,4,13,6,18,74,12,10};

    public static void bubbleSort(int[] array) {
        for (int i = 0; i < array.length -1; i++) {
            for (int j = i +1; j < array.length; j++) {
                if (array[j] < array[i]) {
                    int temp = array[j];
                    array[j] = array[i];
                    array[i] = temp;
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
