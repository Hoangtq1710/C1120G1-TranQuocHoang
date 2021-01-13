package session_10.practice.my_list;

import java.util.Arrays;

public class MyList<E> {
    int size = 0;
    static final int DEFAULT_CAPACITY = 10;
    private Object elements[];

    public MyList() {
        elements = new Object[DEFAULT_CAPACITY];
    }
    public void add(E e){
        if (size == elements.length) {
            ensureCapa();
        }
        elements[size++] = e;
    }
    public void ensureCapa(){
        int newSize = elements.length *2;
        elements = Arrays.copyOf(elements, newSize);
    }
    public E get(int i){
        if (i < 0 || i > elements.length) {
            throw new IndexOutOfBoundsException("Index : "+i+", Size : "+size);
        }
        return (E) elements[i];
    }
}
