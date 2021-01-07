package ExtraExer;
import java.util.Scanner;
//Tim UCLN cua 2 so a,b
public class FindingUCLN {
    public static Integer UCLN(int a, int b){
        while (a != b) {
            if (a > b) {
                a = a - b;
            } else {
                b = b - a;
            }
        }
        return a;
    }

    public static void main(String[] args) {
        System.out.println("Finding Common Factor");
        Scanner scanner = new Scanner(System.in);
        int a;
        int b;
        System.out.println("Enter a : ");
        do {
            a = scanner.nextInt();
            if (a < 1) {
                System.out.println("Please enter a positive number");
            }
        } while (a < 1);
        System.out.println("Enter b : ");
        do {
            b = scanner.nextInt();
            if (b < 1){
                System.out.println("Please enter a positive number");
            }
        } while (b < 1);
        System.out.println("Greatest Common Factor of "+a+" and "+b+" is : "+FindingUCLN.UCLN(a,b));
        System.out.println("Least Common Multiple of "+a+" and "+b+" is : "+(a*b)/FindingUCLN.UCLN(a,b));
    }
}