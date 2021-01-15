package session_11.exercise.bracket_checking_stack;

import java.util.Stack;

public class BracketCheckingStack {
    public static boolean checkingBracket(String str) {
        Stack<Character> stack = new Stack<>();
        if (str.charAt(0) == ')') {
            return false;
        }

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(') {
                stack.push(str.charAt(i));
            }
            if (str.charAt(i) == '(' && (str.charAt(i+1) == ')')) {
                return false;
            }
        }
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ')') {
                if (!stack.empty()) {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }
        if (stack.size() != 0) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String str = "(– b + (b^2 – 4*a(*)c)^(0.5/ 2*a))";
        if (checkingBracket(str)) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
