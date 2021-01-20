package session_14.practice.selection_sort;

public class SelectionSort {
    static int[] list = {7,5,11,2,9,4,13,6,18,74,12,10};
    public static void selectionSort(int[] array) {
        int indexOfMin;
        for (int i = 0; i < array.length -1; i++) {
            indexOfMin = i;
            for (int j = i +1; j < array.length; j++) {
                if (array[j] < array[indexOfMin]) {
                    indexOfMin = j;
                }
            }
            if (indexOfMin != i) {
                int temp = array[indexOfMin];
                array[indexOfMin] = array[i];
                array[i] = temp;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("Selection Sort Algorithm");
        selectionSort(list);
        for (int value : list) {
            System.out.print(value + " ");
        }
    }
}
