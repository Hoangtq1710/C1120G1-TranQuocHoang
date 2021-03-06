package hackkerrank_method;

import java.util.ArrayList;
import java.util.List;

public class CountCharInString {
    static void countChar(String str) {
        char[] arr = str.toCharArray();
        List<Character> list = new ArrayList<>();
        for(char c : arr) {
            if (c == ' '){
                continue;
            }
            if (!list.contains(c)) {
                list.add(c);
            }
        }
        for(Character c : list) {
            int count = 0;
            for(char charArr : arr) {
                if (c.equals(charArr)) {
                    count++;
                }
            }
            System.out.println(c+" - "+count);
        }
    }

    public static void main(String[] args) {
        String str = "Logigear Vietnam";
        countChar(str);
    }
}
