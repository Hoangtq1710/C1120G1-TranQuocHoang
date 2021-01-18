package session_12.practice.hashset_hashmap;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        StudentCodegym student1 = new StudentCodegym("Hoàng", 1, true);
        StudentCodegym student2 = new StudentCodegym("Quang", 2, false);
        StudentCodegym student3 = new StudentCodegym("Thuần", 3, false);
        StudentCodegym student4 = new StudentCodegym("Đức", 4, true);
        StudentCodegym student5 = new StudentCodegym("Vi", 5, false);

        System.out.println("HashMap");
        HashMap<Integer,StudentCodegym> students = new HashMap<>();

        students.put(1,student1);
        students.put(2,student2);
        students.put(3,student3);
        students.put(4,student4);
        students.put(5,student5);

        for(Map.Entry<Integer,StudentCodegym> entry : students.entrySet()) {
            System.out.println(entry);
        }

        System.out.println("=========================");
        System.out.println("HashSet");
        Set<StudentCodegym> hashSetStudents = new HashSet<>();
        hashSetStudents.add(student1);
        hashSetStudents.add(student2);
        hashSetStudents.add(student5);
        hashSetStudents.add(student4);
        hashSetStudents.add(student5);

        for(StudentCodegym studentCodegym : hashSetStudents) {
            System.out.println(studentCodegym);
        }


    }
}
