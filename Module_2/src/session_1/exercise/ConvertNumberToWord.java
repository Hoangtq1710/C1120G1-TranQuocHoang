package session_1.exercise;

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
            System.out.println(Teen(teen));
        } else if (n < 100) {
            int dozen = n / 10;
            int unit = n - dozen * 10;
            String out = Dozen(dozen) + " " + Unit(unit);
            System.out.println(out);
        } else if (n < 1000) {
            int hundred = n / 100;
            int dozen = (n - hundred * 100) / 10;
            int unit = (n - hundred * 100 - dozen * 10);
            String out;
            if (n % 100 != 0) {
                if (dozen != 1) {
                    out = Unit(hundred) + " hundred and " + Dozen(dozen) + " " + Unit(unit);
                } else {
                    out = Unit(hundred) + " hundred and " + Teen(unit);
                }
            } else {
                out = Unit(hundred) + " hundred";
            }
            System.out.println(out);
        } else {
            System.out.println("Out of Ability");
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
    public static String Teen(int teen) {
        String tn = "";
        switch (teen) {
            case 0:
                tn += "ten";
                break;
            case 1:
                tn = "eleven";
                break;
            case 2:
                tn += "twelve";
                break;
            case 3:
                tn += "thirteen";
                break;
            case 4:
                tn += "fourteen";
                break;
            case 5:
                tn += "fifteen";
                break;
            case 6:
                tn += "sixteen";
                break;
            case 7:
                tn += "seventeen";
                break;
            case 8:
                tn += "eighteen";
                break;
            case 9:
                tn += "nineteen";
                break;
        }
        return tn;
    }
    }