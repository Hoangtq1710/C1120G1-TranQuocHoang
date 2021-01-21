package session_14.exercise.insert_sort;

public class InsertSort {
    static int[] list = {7, 5, 11, 2, 9, 4, 13, 6, 18, 74, 12, 10};
    public static void insertSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            System.out.println("\nLoop round "+i+" : ");
            print(array);
            int currentElement = array[i];
            int k;
            for (k = i -1; k >= 0 && array[k] > currentElement; k--) {
                System.out.println("\nMove this element "+array[k]);
                array[k +1] = array[k];
            }
            System.out.println("\nInsert "+array[k +1]+" at index "+ (i -1));
            array[k +1] = currentElement;
        }
    }
    public static void print(int[] array) {
        for (int value : array) {
            System.out.print(value + " ");
        }
    }

    public static void main(String[] args) {
        System.out.println("Insertion Sort Algorithm");
        insertSort(list);
        print(list);
    }
}
