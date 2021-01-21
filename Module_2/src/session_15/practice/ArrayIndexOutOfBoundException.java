package session_15.practice;

import java.util.Random;
import java.util.Scanner;

public class ArrayIndexOutOfBoundException {
    public static int[] numberRandom(){
        Random random = new Random();
        int[] array = new int[100];
        int count = 0;
        for (int i = 0; i < 100; i++) {
            array[i] = random.nextInt(100);
            System.out.print(array[i]+" ");
            count++;

            if (count == 20) {
                System.out.println();
                count = 0;
            }
        }
        return array;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int index;
        System.out.println("Array Index Of Out Bounds Exception");
        System.out.print("Enter a index : ");
        index = scanner.nextInt();
        try {
            System.out.println("\nValue at index "+index+" is "+numberRandom()[index]);
        }catch (IndexOutOfBoundsException e){
            System.out.println("\nIndex is out of bounds");
        }
    }
}
