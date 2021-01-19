package session_11.exercise.optional_queue_linked_list_circular;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

        solution.enQueue(4);
        solution.enQueue(11);
        solution.enQueue(7);
        solution.enQueue(13);
        solution.enQueue(83);
        solution.enQueue(10);
        solution.enQueue(25);

        solution.deQueue();

        solution.displayQueue();

    }
}
