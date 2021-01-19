package session_11.exercise.queue_linked_list_circular;

public class Solution {
    Queue q = new Queue();

    void enQueue(int value) {
        Node temp = new Node();
        temp.data = value;
        if (q.front == null) {
            q.front = temp;
        } else {
            q.rear.next = temp;
        }
        q.rear = temp;
        q.rear.next = q.front;
    }
    void deQueue() {
        if (q.front == null) {
            System.out.println("Queue is null");
        } else if (q.front == q.rear){
            q.front = null;
        } else {
            q.front = q.front.next;
            q.rear.next = q.front;
        }
    }
    void displayQueue() {
        Node temp = q.front;
        while (temp.next != q.front) {
            System.out.print(temp.data+" ");
            temp = temp.next;
        }
        System.out.print(temp.data);
    }

}
