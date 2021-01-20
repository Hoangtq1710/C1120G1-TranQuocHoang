package session_13.exercise.optional_longest_consecutive_string;

import java.util.LinkedList;
import java.util.Scanner;

public class ConsecutiveLongestString {
    public static String consecutiveString(String string) {
        LinkedList<Character> array = new LinkedList<>();
        for (int i = 0; i < string.length(); i++) {
            LinkedList<Character> list = new LinkedList<>();
            list.add(string.charAt(i));
            for (int j = i +1; j < string.length(); j++) {
                if (string.charAt(j) > list.getLast()) {
                    list.add(string.charAt(j));
                } else {
                    break;
                }
            }
            if (list.size() > array.size()) {
                array.clear();
                array.addAll(list);
            }
        }
        String result = "";
        for(Character character : array) {
            result += character;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println("Finding the Longest Consecutive String");
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string : ");
        String str = scanner.next();
        System.out.println("Longest Consecutive String is "+consecutiveString(str));
    }
}
