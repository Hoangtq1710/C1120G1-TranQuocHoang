package session_11.practice.queue_linked_list;

public class Node {
    private int key;
    public Node next;

    public Node(int key) {
        this.key = key;
        this.next = null;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}
