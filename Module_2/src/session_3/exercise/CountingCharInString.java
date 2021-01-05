package session_3.exercise;
import java.util.Scanner;

public class CountingCharInString {
    public static void main(String[] args)
    {
        System.out.println("Counting Char In String");
        Scanner scanner = new Scanner(System.in);
        String str;
        char c = 'v';
        int count = 0;

        System.out.println("Enter your string : ");
        str = scanner.nextLine();

        for(int i = 0;i < str.length() ;i++){
            if(str.charAt(i) == c){
                count++;
            }
        }
        System.out.println("This character "+c+" is appear "+count+" times");
    }
}
