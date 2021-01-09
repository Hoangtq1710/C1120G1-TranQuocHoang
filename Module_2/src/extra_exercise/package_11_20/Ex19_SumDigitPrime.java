package extra_exercise.package_11_20;

import extra_exercise.package_01_10.Ex04_FactorAnalysis;

import java.util.Scanner;

public class Ex19_SumDigitPrime {
    public static int sumDigitOfPrime(int number) {
        String str = Integer.toString(number);
        int n = str.length();
        int[] array = new int[n];
        int sum = 0;
        int pow;
        int temp = number;
        for (int i = 0; i < n; i++) {
            pow = (int) Math.pow(10, (n - i -1));
            array[i] = temp / pow;
            temp -= array[i] * pow;
        }
        for(int value : array){
            sum += value;
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println("Checking Sum of Digits of Prime have 5 digits");
        Scanner scanner = new Scanner(System.in);
        int sum;
        // nếu sum chia hết cho 3 thì sẽ k có số nào thỏa mãn yêu cầu

        do {
            System.out.print("Enter the sum ( 1 - 45) : ");
            sum = scanner.nextInt();
            if (sum < 1 || sum > 45) {
                System.out.println("Sum have to be greater than 0 or smaller than 45");
            }
        } while (sum < 1 || sum > 45);

        System.out.println("Primes has sum of digits equals to Sum is : \n");
        int count = 0;
        boolean flag = true;
        for (int i = 10000; i < 100000; i++) {

            if ((sumDigitOfPrime(i) == sum) && (Ex04_FactorAnalysis.isPrime(i))) {
                System.out.print(i+" ");
                count++;
            }
            if (count == 20) {
                flag = false;
                System.out.print("\n");
                count = 0;
            }
        }
        if (count == 0 && flag) {
            System.out.println("Oops, we don't have any Prime match your requirement!");
        }
    }
}
