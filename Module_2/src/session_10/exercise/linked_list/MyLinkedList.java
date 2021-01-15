package session_10.exercise.linked_list;

public class MyLinkedList<E> {
    private Node head;
    private int numNodes = 0;
    private final int DEFAULT_CAPACITY = 10;

    public MyLinkedList() {
        this.numNodes = DEFAULT_CAPACITY;
    }

    public MyLinkedList(Object data) {

    }

    public int getNumNodes() {
        return numNodes;
    }

    public void setNumNodes(int numNodes) {
        this.numNodes = numNodes;
    }

    public class Node {
        public Node next;
        public Object data;

        public Node() {
        }

        public Node(Object data) {
            this.data = data;
        }

        public Object getData() {
            return data;
        }

        public void setData(Object data) {
            this.data = data;
        }
    }

    public void add(int index, E element) {
        Node temp = head;
        Node holder;
        if (index < 0 || index > numNodes) {
            throw new IndexOutOfBoundsException("Index : "+index);
        } else if (index == 0) {
            addFirst(element);
        } else {
            for (int i = 0; i < index -1; i++) {
                temp = temp.next;
            }
            holder = temp.next;
            temp.next = new Node(element);
            temp.next.next = holder;
        }
        numNodes++;
    }
    public void addFirst(E element) {
        Node temp = head;
        head = new Node(element);
        head.next = temp;
        numNodes++;
    }
    public void add(E element) {
        if (numNodes == 0) {
            addFirst(element);
        } else {
            Node temp = head;
            for (int i = 0; i < numNodes -1; i++) {
                temp = temp.next;
            }
            temp.next = new Node(element);
            numNodes++;
        }
    }
    public E remove(int index) {
        if (index < 0 || index > numNodes) {
            throw new IndexOutOfBoundsException("Index "+index);
        } else {
            Node temp = head;
            Object data;
            if (index == 0) {
                data = head.data;
                head = head.next;
            } else {
                for (int i = 0; i < index -1 && temp.next != null; i++) {
                    temp = temp.next;
                }
                data = temp.next.data;
                temp.next = temp.next.next;
            }
            numNodes--;
            return (E) data;
        }
    }
    public boolean remove(E element) {
        if (head.data.equals(element)) {
            remove(0);
        } else {
            Node temp = head;
            for (int i = 0; i < numNodes -1 && temp.next != null; i++) {
                if (temp.next.data.equals(element)) {
                    temp.next = temp.next.next;
                    numNodes--;
                    return true;
                }
            }
        }
        return false;
    }
    public int size() {
        return numNodes;
    }
    public E clone(){
        if (numNodes == 0) {
            throw new NullPointerException("This list is null");
        }
        MyLinkedList<E> myLinkedList = new MyLinkedList<>();
        Node temp = head;
        myLinkedList.add((E)temp.data);
        while (temp.next != null) {
            myLinkedList.add((E) temp.data);
            temp = temp.next;
        }
        return (E) myLinkedList;
    }
    public boolean contains(E element) {
        Node temp = head;
        for (int i = 0; i < numNodes && temp.next != null; i++) {
            if (temp.data.equals(element)) {
                return true;
            }
            temp = temp.next;
        }
        return false;
    }
    public int indexOf(E element) {
        Node temp = head;
        for (int i = 0; i < numNodes && temp.next != null; i++) {
            if (temp.data.equals(element)) {
                return i;
            }
            temp = temp.next;
        }
        return -1;
    }
    public void printList(){
        Node temp = head;
        for (int i = 0; i < numNodes; i++) {
            System.out.println(temp.data);
            temp = temp.next;
        }
        System.out.println();
    }
}
