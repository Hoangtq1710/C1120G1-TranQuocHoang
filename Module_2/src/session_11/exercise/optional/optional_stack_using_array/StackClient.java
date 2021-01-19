package session_11.exercise.optional.optional_stack_using_array;

public class StackClient {
    public static void main(String[] args) {
        MyStack<Integer> stack = new MyStack<>(5);
        stack.push(2);
        stack.push(28);
        stack.push(4);
        stack.push(44);
        stack.push(7);
        stack.push(12);
        stack.push(13);

        stack.printStack();
    }
}
