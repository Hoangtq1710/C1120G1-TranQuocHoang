package ExtraExer;

import java.util.Scanner;
//phân tích số nguyên thành tích các số nguyên tố
public class FactorAnalysis {
    public static String factorAnalysis(int number){
        String result = number+" = ";
        int i = 2;
        while (number > 1){
            if (isPrime(i)){
                if (number % i == 0){
                    result += i;
                    number = number / i;
                    if (number != 1){
                        result += " x ";
                    }
                } else {
                    i++;
                }
            } else {
                i++;
            }
        }
        return result;
    }
    public static boolean isPrime(int n) {
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0 ) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println("Factor Analysis");
        Scanner scanner = new Scanner(System.in);
        int number;
        System.out.print("Enter the number : ");
        do {
            number = scanner.nextInt();
            if (number < 1) {
                System.out.println("Number must be positive");
            }
        } while (number < 1);
        System.out.println(FactorAnalysis.factorAnalysis(number));
    }
}
