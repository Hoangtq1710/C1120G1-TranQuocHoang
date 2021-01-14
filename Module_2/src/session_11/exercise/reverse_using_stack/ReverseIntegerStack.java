package session_11.exercise.reverse_using_stack;

import java.util.Stack;

public class ReverseIntegerStack {
    public static void main(String[] args) {
        int[] array;
        array = new int[]{4,6,5,2,7};
        Stack<Integer> stackInteger = new Stack<>();
        for (int i = 0; i < array.length; i++) {
            stackInteger.push(array[i]);
        }
        for (int i = 0; i < array.length; i++) {
            array[i] = stackInteger.pop();
        }
        for(int value : array) {
            System.out.println(value+" ");
        }
    }

}
