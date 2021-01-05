package session_3.exercise;

import java.util.Scanner;
public class MinOfArray {
    public static void main(String[] args)
    {
        System.out.println("Min Of Array");
        Scanner scanner = new Scanner(System.in);
        int size;
        int[] array ;
        int min;

        System.out.println("Enter the size of array :");
        do {
            size = scanner.nextInt();
            if(size < 1){
                System.out.println("Size must be positive");
            }
        } while (size  < 1);

        array = new int[size];
        for(int i = 0; i < size; i++){
            System.out.println("Element "+i+" :");
            array[i] = scanner.nextInt();
        }
        System.out.print("Array :");
        for(int value : array ){
            System.out.print(" "+value);
        }
        System.out.println("\n");
        min = array[0];
        for (int value : array) {
            if (min > value) {
                min = value;
            }
        }
        System.out.println("Min of array is : "+min);
    }
}
