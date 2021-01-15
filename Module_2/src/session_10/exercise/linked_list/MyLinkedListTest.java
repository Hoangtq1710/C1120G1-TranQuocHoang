package session_10.exercise.linked_list;

import session_10.practice.linked_list.Student;

public class MyLinkedListTest {
    public static void main(String[] args) {
        MyLinkedList<Student> myLinkedListTest = new MyLinkedList<>();
        Student student1 = new Student(1, "Hoang");
        Student student2 = new Student(2, "Quang");
        Student student3 = new Student(3, "Tung");
        Student student4 = new Student(4, "Thuan");
        Student student5 = new Student(5, "Duc");
        Student student6 = new Student(6, "Khoa");
        Student student7 = new Student(7, "Sang");
        Student student8 = new Student(8, "Vi");

        myLinkedListTest.add(student3);
        myLinkedListTest.add(student4);
        myLinkedListTest.add(student5);
        myLinkedListTest.add(student6);

        myLinkedListTest.addFirst(student1);
        myLinkedListTest.addFirst(student2);
        myLinkedListTest.printList();

        myLinkedListTest.remove(student2);
        myLinkedListTest.printList();

        myLinkedListTest.remove(1);
        myLinkedListTest.printList();

        if (myLinkedListTest.contains(student4)) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }

        myLinkedListTest.add(student7);
        myLinkedListTest.add(student8);
        myLinkedListTest.printList();

        System.out.println("Index of student 7 is "+myLinkedListTest.indexOf(student7));
    }
}
