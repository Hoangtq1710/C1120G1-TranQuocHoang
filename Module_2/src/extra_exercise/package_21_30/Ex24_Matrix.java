package extra_exercise.package_21_30;

import extra_exercise.package_01_10.Ex04_FactorAnalysis;

import java.util.Scanner;

public class Ex24_Matrix {
    public static void matrixMaxValue (int[][] matrix){
        int max = matrix[0][0];
        int iIndex = 0;
        int jIndex = 0;
        System.out.println("\nMatrix : ");
        for (int[] item : matrix) {
            for (int value : item) {
                System.out.print(value + " ");
            }
            System.out.print("\n");
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (max < matrix[i][j]) {
                    max = matrix[i][j];
                    iIndex = i;
                    jIndex = j;
                }
            }
        }
        System.out.println("Max value of Matrix is "+max+" at x = "+iIndex+"; y = "+jIndex);
    }
    public static void displayPrimeMatrix(int[][] matrix) {
        System.out.println("\nMatrix before : ");
        for (int[] item : matrix) {
            for (int value : item) {
                System.out.print(value + " ");
            }
            System.out.print("\n");
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (!Ex04_FactorAnalysis.isPrime(matrix[i][j])) {
                    matrix[i][j] = 0;
                }
            }
        }
        System.out.println("\nMatrix after : ");
        for (int[] item : matrix) {
            for (int value : item) {
                System.out.print(value + " ");
            }
            System.out.print("\n");
        }
    }
    public static void sortColumnAscending(int[][] matrix){
        int column = 0;
        int row = matrix.length;
        for (int[] item : matrix) {
            for (int j = 0; j < item.length; j++) {
                column++;
            }
            break;
        }
        int[][] sub = new int[column][row];
        System.out.println("Matrix : ");
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println("");
        }
    }
    public static void main(String[] args) {
        System.out.println("Exercise 24 : Matrix");
        Scanner scanner = new Scanner(System.in);
        int n;
        int m;
        int[][] matrix;

        do {
            System.out.print("Enter rows : ");
            n = scanner.nextInt();
            if (n < 1) {
                System.out.println("Rows must to greater than 0");
            }
        } while (n < 1);
        do {
            System.out.print("Enter column : ");
            m = scanner.nextInt();
            if (m < 1) {
                System.out.println("Columns must to greater than 0");
            }
        } while (m < 1);
        matrix = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print("Matrix["+i+"]["+j+"] : ");
                do {
                    matrix[i][j] = scanner.nextInt();
                    if (matrix[i][j] < 0) {
                        System.out.println("Element must to positive");
                    }
                } while (matrix[i][j] < 0);
            }
        }

//        matrixMaxValue(matrix);
//        displayPrimeMatrix(matrix);
        sortColumnAscending(matrix);
    }
}
