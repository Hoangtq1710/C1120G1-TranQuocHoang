package session_11.exercise.array_using_stack;

import java.util.Arrays;

public class MyStack<E> {
    private int[] array;
    private int size = 0;
    private int index;
    private final int DEFAULT_CAPACITY = 10;

    public MyStack() {
        array = new int[DEFAULT_CAPACITY];
    }

    public MyStack(int size) {
        this.size = size;
    }
    public void ensureCapa(){
        if (array.length == size) {
            array = Arrays.copyOf(array,(size *2));
        }
    }
    public void push(int element){
        if (isFull()) {
            throw new StackOverflowError("Stack is full");
        }
        array[index] = element;
        index++;
    }
    public int pop(){
        if (isEmpty()) {
            throw new NullPointerException("Stack is NULL");
        }
        size--;
        return array[size -1];
    }
    public int size(){
        return this.size;
    }
    public boolean isEmpty(){
        return this.size() == 0;
    }
    public boolean isFull(){
        if (!isEmpty()){
            return (size == array.length);
        }
        return false;
    }
    public void printStack(){
        for (int value : array) {
            System.out.print(value + " ");
        }
    }
}
