package Session_1.Exercise;

import java.util.Scanner;

public class DisplayHello {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your greetings");
        String message = scanner.nextLine();

        System.out.println("Your message is : "+message);
    }
}
