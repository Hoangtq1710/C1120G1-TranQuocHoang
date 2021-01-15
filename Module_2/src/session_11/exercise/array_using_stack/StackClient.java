package session_11.exercise.array_using_stack;

public class StackClient {
    public static void main(String[] args) {
        MyStack<Integer> stack = new MyStack(5);
        stack.push(2);
        stack.push(28);
        stack.push(4);
        stack.push(44);
        stack.push(7);

        stack.printStack();
    }
}
