package ExtraExer;

import java.util.Scanner;

public class BinaryString_9 {
    static int size;
    public static void binaryString(int number){
        int[] array;
        size = number;
        double n = Math.pow(2,size);
        array = new int[size];
        for(int value : array){
            array[value] = 0;
        }
        for (int i = 0; i < n; i++) {
            for(int value : convertToBinary(i)){
                System.out.print(value+" ");
            }
            System.out.print("\n");
        }
    }
    public static int[] convertToBinary(int n){
        int[] array;
        array = new int[size];
        for (int i = array.length -1; i >= 0; i--) {
            array[i] = n % 2;
            n = n / 2;
        }
        return array;
    }

    public static void main(String[] args) {
        System.out.println("Display Binary String");
        Scanner scanner = new Scanner(System.in);
        int number;
        System.out.println("Enter a number (n < 10) : ");
        do {
            number = scanner.nextInt();
            if (number < 0 || number > 10){
                System.out.println("Number must be between 1 and 10!");
            }
        } while (number < 0 || number > 10);
        binaryString(number);
    }
}
