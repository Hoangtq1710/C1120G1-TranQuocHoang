package session_11.practice.my_generic_stack;

public class GenericStackClient {
    private static void stackOfString() {
        MyGenericStack<String> myStringStack = new MyGenericStack<>();
        myStringStack.push("Five");
        myStringStack.push("Four");
        myStringStack.push("Three");
        myStringStack.push("Two");
        myStringStack.push("One");

        System.out.println("Size after push : "+myStringStack.size());
        System.out.println("Pop element out of Stack");

        for (int i = myStringStack.size() -1; i >= 0; i--) {
            System.out.println("Index "+i+" : "+myStringStack.pop());
        }

        System.out.println("Size after pop : "+myStringStack.size());
    }
    public static void stackIsInteger() {
        MyGenericStack<Integer> myIntegerStack = new MyGenericStack<>();
        myIntegerStack.push(5);
        myIntegerStack.push(4);
        myIntegerStack.push(3);
        myIntegerStack.push(2);
        myIntegerStack.push(1);

        System.out.println("Size after push : "+myIntegerStack.size());
        System.out.println("Pop element out of Stack");

        while (!myIntegerStack.isEmpty()) {
            System.out.println("Element "+myIntegerStack.pop());
        }

        System.out.println("Size after pop : "+myIntegerStack.size());
    }

    public static void main(String[] args) {
        System.out.println("Print Stack String");
        stackOfString();
        System.out.println("Print Stack Integer");
        stackIsInteger();
    }
}
