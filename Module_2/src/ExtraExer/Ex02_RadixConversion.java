package ExtraExer;

import java.util.Scanner;
//đổi 1 số thuộc hệ cơ số 10 thành 1 số thuộc hệ cơ số n (2-36)
public class Ex02_RadixConversion {
    public static long radix(int n, int radix){
        int[] array;
        int count = 0;
        int number = n;
        while (number > 1) {
            number = number / radix;
            count++;
        }
        array = new int[count +1];
        for (int i = array.length -1; i >= 0; i--) {
            array[i] = n % radix;
            n = n / radix;
        }
        return arrayToInt(array);
    }
    public static int arrayToInt(int[] array) {
        int result = 0;
        int pow = array.length;
        for (int value : array) {
            result += value * Math.pow(10, pow - 1);
            pow -= 1;
        }
        return result;
    }

    public static void main(String[] args) {
        int n;
        int radix;
        long result;
        System.out.println("Radix Conversion");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter n : ");
        n = scanner.nextInt();
        do {
            System.out.println("Enter radix(1 < radix <= 36) : ");
            radix = scanner.nextInt();
        } while ((radix < 2) || (radix > 36));
        result = Ex02_RadixConversion.radix(n, radix);
        System.out.println(n+"(10) = "+result+"("+radix+")" );
    }
}
