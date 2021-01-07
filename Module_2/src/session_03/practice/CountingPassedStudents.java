package session_03.practice;
import java.util.Scanner;

public class CountingPassedStudents {
    public static void main(String[] args)
    {
        System.out.println("Counting Passed Exam Student");
        Scanner scanner = new Scanner(System.in);
        int size;
        double[] array;
        int count = 0;

        do{
            System.out.print("Enter the number of students : ");
            size = scanner.nextInt();
            if(size < 1 || size > 30){
                System.out.println("Invalid Number!");
            }
        } while (size < 1 || size > 30);
        array = new double[size];

        for(int i =0; i < size; i++){
            do{
                System.out.print("Score of student "+i+" : ");
                array[i] = scanner.nextDouble();
                if(array[i] < 0 || array[i] > 10){
                    System.out.println("Invalid Score!");
                }
            } while (array[i] < 0 || array[i] > 10);
        }
        System.out.print("\nList of score :");
        for(double value : array){
            System.out.print(" "+ value );
            if(value >= 5){
                count++;
            }
        }
        System.out.println("\n");

        System.out.println("We have "+count+" students passed the exam!");
    }
}
