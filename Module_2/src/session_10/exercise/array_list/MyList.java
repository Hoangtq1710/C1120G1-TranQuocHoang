package session_10.exercise.array_list;

import java.util.Arrays;

public class MyList<E> {
    private int size = 0;
    private static final int DEFAULT_CAPACITY = 5;
    private Object elements[];

    public MyList() {
        elements = new Object[DEFAULT_CAPACITY];
    }
    public MyList(int capacity) {
        if (capacity >= 0) {
            elements = new Object[capacity];
        } else {
            throw new IllegalArgumentException("Capacity : "+capacity);
        }
    }

    public void add(int index , E element){
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index : "+index);
        } else if (size == elements.length){
            this.ensureCapacity();
        } else {
            size++;
            for (int i = elements.length -1; i > index; i--) {
                elements[i] = elements[i -1];
            }
            elements[index] = element;
        }
    }
    public E remove(int index) {
        if (index < 0 || index > elements.length) {
            throw new IndexOutOfBoundsException("Index : "+index);
        } else {
            for (int i = index; i < elements.length-1; i++) {
                elements[i] = elements[i +1];
            }
            size--;
            return (E) elements;
        }
    }

    public int size() {
        return size;
    }
    public E clone(){
        Object[] object;
        return (E) (object = Arrays.copyOf(elements, size));
    }
    public boolean contains(E element){
        for (int i = 0; i < elements.length; i++) {
            if (elements[i].equals(element)) {
                return true;
            }
        }
        return false;
    }
    public int indexOf(E element) {
        for (int i = 0; i < elements.length && elements[i] != null; i++) {
            if (elements[i].equals(element)) {
                return i;
            }
        }
        return -1;
    }
    public boolean add(E element) {
        if (elements.length == size) {
            this.ensureCapacity();
        }
        elements[size] = element;
        size++;
        return true;
    }

    public void ensureCapacity(){
        int newSize = size * 2;
        elements = Arrays.copyOf(elements, newSize);
    }
    public E get(int index) {
        return (E) elements[index];
    }
    public void clear(){
        size = 0;
        for (int i = 0; i < elements.length; i++) {
            elements[i] = null;
        }
    }

    public void printList(){
        if (size == 0) {
            System.out.println("Object is empty");
        } else {
            for (int i = 0; i < elements.length && elements[i] != null; i++) {
                System.out.println(elements[i]);
            }
        }
    }
}
