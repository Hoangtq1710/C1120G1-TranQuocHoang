package session_03.exercise;
import java.util.Scanner;

public class FindingMaxValue {
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        int size;
        int[][] array ;
        int a = 0;
        int b = 0;
        int max;

        System.out.println("Finding Max Value");
        System.out.println ("Enter the size of matrix : ");
        do {
            size = scanner.nextInt();
            if(size < 1) {
                System.out.println("Size must be positive !");
            }
        } while ( size < 1);
        array = new int[size][size];
        for(int i = 0; i < size ;i++){
            for(int j = 0; j < size ;j++){
                System.out.print("Element["+i+"]["+j+"] : ");
                array[i][j] = scanner.nextInt();
            }
        }

        max = array[0][0];
        for(int i = 0; i < size ;i++){
            for(int j = 0; j < size ;j++){
                if(max < array[i][j]) {
                    max = array[i][j];
                }
            }
        }

        for(int i = 0;i < size ;i++){
            for(int j = 0; j < size; j++){
                if(array[i][j] == max){
                    a = i;
                    b = j;
                    break;
                }
            }
        }

        System.out.println("\nMax value of the Matrix is "+max+" at X : "+a+" Y : "+b);
    }
}
