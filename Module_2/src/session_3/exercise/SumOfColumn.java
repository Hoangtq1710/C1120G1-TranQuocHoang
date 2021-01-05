package session_3.exercise;
import java.util.Scanner;

public class SumOfColumn {
    public static void main(String[] args)
    {
        System.out.println("Sum Of a Column in a Matrix");
        Scanner scanner  = new Scanner(System.in);
        int size1;
        int size2;
        int[][] array;
        int column;
        int sum =0;

        do{
            System.out.println("Enter the size of Matrix :");
            size1 = scanner.nextInt();
            if(size1 < 1){
                System.out.println("Size must be positive");
            }
        } while(size1 < 1);

        do{
            System.out.println("Enter the size of each Array :");
            size2 = scanner.nextInt();
            if(size2 < 1){
                System.out.println("Size must be positive");
            }
        } while(size2 < 1);
        array = new int[size1][size2];

        for(int i = 0; i < size1; i++){
            for(int j = 0;j < size2; j++){
                System.out.print("Element ["+i+"]["+j+"] :");
                array[i][j] = scanner.nextInt();
            }
        }
        System.out.println("Enter the column (0 - "+(size2 -1)+") :");
        do{
            column = scanner.nextInt();
            if(column < 0 || column >= size2){
                System.out.println("Column invalid!");
            }
        } while(column < 0 || column >= size1);

        for(int i =0; i < size1; i++){
            sum += array[i][column];
        }
        System.out.println("\nMatrix : ");
        for(int i = 0; i < size1;i++){
            for(int j = 0; j < size2; j++){
                System.out.print(array[i][j]+" ");
            }
            System.out.println("\n");
        }
        System.out.println("\nSum of column "+column+" is "+sum);
    }
}
