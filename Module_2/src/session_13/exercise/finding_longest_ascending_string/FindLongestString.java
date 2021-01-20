package session_13.exercise.finding_longest_ascending_string;

import java.util.LinkedList;
import java.util.Scanner;

public class FindLongestString {
    public static String findLongestString(String string){
        char[] str = string.toCharArray();
        LinkedList<Character> array = new LinkedList<>();
        for (int i = 0; i < str.length; i++) {
            LinkedList<Character> list = new LinkedList<>();
            list.add(str[i]);
            for (int j = i +1; j < str.length; j++) {
                if (str[j] > list.getLast()) {
                    list.add(str[j]);
                }
            }
            if (list.size() > array.size()) {
                array.clear();
                array.addAll(list);
            }
            list.clear();
        }
        String result = "";
        for (Character character : array) {
            result += character;
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string : ");
        String str = scanner.next();

        System.out.println("Longest Ascending String is "+findLongestString(str));
    }
}
