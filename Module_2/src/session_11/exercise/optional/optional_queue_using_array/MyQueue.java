package session_11.exercise.optional.optional_queue_using_array;

public class MyQueue {
    private int capacity;
    private int[] queueArr;
    private int head = 0;
    private int tail = -1;
    private int currentSize = 0;

    public MyQueue(int queueSize) {
        this.capacity = queueSize;
        queueArr = new int[queueSize];
    }
    public boolean isQueueFull() {
        return (this.currentSize == capacity);
    }
    public boolean isQueueEmpty(){
        return this.currentSize == 0;
    }
    public void enqueue(int item) {
        if (isQueueFull()) {
            System.out.println("Queue is full!");
        } else {
            tail++;
            if (tail == capacity -1) {
                tail = 0;
            }
            queueArr[tail] = item;
            currentSize++;
            System.out.println("Element "+item+" is pushed to Queue !");
        }
    }
    public void dequeue() {
        if (isQueueEmpty()) {
            System.out.println("Queue is empty!");
        } else {
            head++;
            if (head == capacity -1) {
                System.out.println("Pop operation is done! Removed this element "+queueArr[head -1]);
                head = 0;
            } else {
                System.out.println("Pop operation is done! Removed this element "+queueArr[head -1]);
            }
            currentSize--;
        }
    }
}
