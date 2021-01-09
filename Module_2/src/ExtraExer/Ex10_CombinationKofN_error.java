package ExtraExer;

import java.util.Scanner;

public class Ex10_CombinationKofN_error {
    public static void combineKofN(int n, int k){
        int[] arrayN = new int[n];
        int[] arrayK = new int[k];
        int times = (factorial(n) / (factorial(k) * (factorial(n - k))));
        for (int i = 0; i < arrayN.length -1; i++) {
            if (i == 0) {
                arrayN[i] = 1;
            }
            arrayN[i+1] = arrayN[i]+1;
        }
//        for (int i = 0; i < times; i++) {
//            for (int j = 0; j < arrayK.length; j++) {
//                arrayK[j] = arrayN[j];
//                for (int u = 0; u < k; u++) {
//                    System.out.print(arrayK[u]+" ");
//                }
//            }
//            System.out.print("\n");
//        }
    }
    public static int factorial(int number){
        int a = 1;
        for (int i = 1; i <= number; i++) {
            a *= i;
        }
        return a;
    }

    public static void main(String[] args) {
        System.out.println("Display Combination K of N");
        Scanner scanner = new Scanner(System.in);
        int k;
        int n;
        System.out.print("Enter n > 1 : ");
        do {
            n = scanner.nextInt();
            if (n < 2){
                System.out.println("n must be greater than 1!");
            }
        } while (n < 2);
        do {
            System.out.print("Enter k : ");
            k = scanner.nextInt();
            if (k > n){
                System.out.println("k must be smaller than "+n);
            } else if (k < 0){
                System.out.println("k must be positive");
            }
        } while (k < 1 || k > n);
        combineKofN(n,k);
    }
}
