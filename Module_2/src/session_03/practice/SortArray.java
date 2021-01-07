package session_3.practice;

import java.util.Arrays;

public class SortArray {
    public static void main(String[] args) {
        int[] a = {1,9,3,2};
        ascendingSortArray(a);
        System.out.println("\n");
        System.out.println(Arrays.toString(decreasingSortArray(a)));
    }
    public static void ascendingSortArray(int [] array){
        for (int i = 0; i < array.length -1; i++) {
            for (int j = i+1; j < array.length; j++) {
                if (array[i] > array[j]) {
                    int x = array[i];
                    array[i] = array[j];
                    array[j] = x;
                }
            }
        }
        for (int value : array) {
            System.out.print(value + " ");
        }
    }
    public static int[] decreasingSortArray(int [] array){
        for (int i = 0; i < array.length -1; i++) {
            for (int j = i+1; j < array.length; j++) {
                if (array[i] < array[j]) {
                    int x = array[i];
                    array[i] = array[j];
                    array[j] = x;
                }
            }
        }
        return array;
    }

}