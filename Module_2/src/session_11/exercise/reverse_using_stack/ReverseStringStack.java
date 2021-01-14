package session_11.exercise.reverse_using_stack;

import java.util.Stack;

public class ReverseStringStack {
    public static void main(String[] args) {
        Stack<String> stackString = new Stack<>();
//        String[] str = {"Element","is","a","String"};
//        for (int i = 0; i < str.length; i++) {
//            stackString.push(str[i]);
//        }
//        for (int i = 0; i < str.length; i++) {
//            str[i] = stackString.pop();
//        }
//        for(String value : str) {
//            System.out.println(value+" ");
//        }

        String chain = "Today is a good day";
        String[] str = chain.split(" ");
        for (int i = 0; i < str.length; i++) {
            stackString.push(str[i]);
        }
        for (int i = 0; i < str.length; i++) {
            str[i] = stackString.pop();
        }
        for(String value : str) {
            System.out.println(value+" ");
        }
    }
}
