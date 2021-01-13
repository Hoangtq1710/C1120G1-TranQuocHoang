package session_10.practice.linked_list;

public class MyLinkedListTest {
    public static void main(String[] args) {
        System.out.println("Linked List Testing");
        MyLinkedList myLinkedList = new MyLinkedList(10);

        myLinkedList.addFirst(1);
        myLinkedList.addFirst(2);
        myLinkedList.addFirst(3);
        myLinkedList.addFirst(4);
        myLinkedList.addFirst(5);

        myLinkedList.remove(2);
        myLinkedList.remove(1);

        myLinkedList.printList();
        System.out.println("Size : "+myLinkedList.getNumNodes());
    }
}
