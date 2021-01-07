package session_03.exercise;
import java.util.Scanner;

public class SumOfDiagonalLine {
    public static void main(String[] args)
    {
        System.out.println("Sum Of Diagonal Line");
        Scanner scanner = new Scanner(System.in);
        int size;
        int[][] array;
        int sum1 = 0;
        int sum2 = 0;

        System.out.println("Enter the size of Square Matrix :");
        do{
            size = scanner.nextInt();
            if(size < 1 || size > 15){
                System.out.println("Size Invalid");
            }
        } while(size < 1 || size > 15);
        array = new int[size][size];
        for(int i =0; i < size; i++){
            for(int j =0; j < size; j++){
                System.out.print("Element["+i+"]["+j+"] : ");
                array[i][j] = scanner.nextInt();
            }
        }

        System.out.println("\nMatrix : ");
        for(int i =0; i < size; i++){
            for(int j =0; j < size; j++){
                System.out.print(array[i][j]+" ");
            }
            System.out.println("\n");
        }
        for(int i =0; i < size; i++){
            sum1 += array[i][i];
            sum2 += array[i][size -1 -i];
        }
        System.out.println("Sum of Diagonal left : "+sum1);
        System.out.println("Sum of Diagonal right : "+sum2);

    }
}
