package session_11.exercise.optional_palindrome_stack_queue;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

public class Palindrome {
    public static boolean isPalindrome(String str){
        Stack<Character> stackStr = new Stack<>();
        Queue<Character> queueStr = new ArrayDeque<>();

        for (int i = 0; i < str.length(); i++) {
            stackStr.push(str.charAt(i));
            queueStr.offer(str.charAt(i));
        }
        for (int i = 0; i < stackStr.size(); i++) {
            if (stackStr.pop() == (queueStr.poll())) {
            } else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String str = "iuarbttttbraui";
        if (isPalindrome(str)) {
            System.out.println(str+" is a Palindrome");
        } else {
            System.out.println(str+" is NOT a Palindrome");
        }
    }
}
