package Session_1.Exercise;

import java.util.Scanner;

public class ConvertNumberToWord {
    public static void main(String[] args) {
        System.out.println("Convert Number To Word");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a number : ");
        int n = scanner.nextInt();

        if ((n >= 0) && (n < 10)) {
            System.out.println(Unit(n));
        } else if (n < 20) {
            int teen = n % 10;
            switch (teen) {
                case 0:
                    System.out.println("ten");
                    break;
                case 1:
                    System.out.println("eleven");
                    break;
                case 2:
                    System.out.println("twelve");
                    break;
                case 3:
                    System.out.println("thirteen");
                    break;
                case 4:
                    System.out.println("fourteen");
                    break;
                case 5:
                    System.out.println("fifteen");
                    break;
                case 6:
                    System.out.println("sixteen");
                    break;
                case 7:
                    System.out.println("seventeen");
                    break;
                case 8:
                    System.out.println("eighteen");
                    break;
                case 9:
                    System.out.println("nineteen");
                    break;
            }
        } else if (n < 100){
            int dozen = n/10;
            int unit = n - dozen*10;
            String out = Dozen(dozen)+" "+Unit(unit);
            System.out.println(out);
        } else {
            int hundred = n/100;
            int dozen = (n - hundred *100) /10;
            int unit = (n - hundred*100 - dozen*10);
            String out;
            if (n % 100 != 0) {
                out = Unit(hundred)+" hundred and "+Dozen(dozen)+" "+Unit(unit);
            } else {
                out = Unit(hundred)+" hundred";
            }
            System.out.println(out);
        }
    }
    public static String Unit(int unit){
        String u = "";
        switch (unit) {
            case 0:
                u = "zero";
                break;
            case 1:
                u = "one";
                break;
            case 2:
                u = "two";
                break;
            case 3:
                u = "three";
                break;
            case 4:
                u = "four";
                break;
            case 5:
                u = "five";
                break;
            case 6:
                u = "six";
                break;
            case 7:
                u = "seven";
                break;
            case 8:
                u = "eight";
                break;
            case 9:
                u = "nine";
                break;
        }
        return u;
    }
    public static String Dozen(int dozen){
        String d = "";
        switch (dozen) {
            case 2:
                d += "twenty";
                break;
            case 3:
                d += "thirty";
                break;
            case 4:
                d += "forty";
                break;
            case 5:
                d += "fifty";
                break;
            case 6:
                d += "sixty";
                break;
            case 7:
                d += "seventy";
                break;
            case 8:
                d += "eighty";
                break;
            case 9:
                d += "ninety";
                break;
        }
        return d;
    }
}
