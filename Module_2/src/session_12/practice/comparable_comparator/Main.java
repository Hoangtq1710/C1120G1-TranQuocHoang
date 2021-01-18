package session_12.practice.comparable_comparator;

import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        Employee employee1 = new Employee("Hoàng", 25, "K");
        Employee employee2 = new Employee("Quang", 27, "Q");
        Employee employee3 = new Employee("Khoa", 21, "T");
        Employee employee4 = new Employee("Vi", 28, "R");
        Employee employee5 = new Employee("Thuần", 22, "U");

        ArrayList<Employee> employees = new ArrayList<>();
        employees.add(employee1);
        employees.add(employee2);
        employees.add(employee3);
        employees.add(employee4);
        employees.add(employee5);

        System.out.println("Comparable");
        Collections.sort(employees);
        for(Employee emp : employees) {
            System.out.println(emp);
        }

        System.out.println("=======================");
        System.out.println("Comparator");
        AgeComparator agecompa = new AgeComparator();
        Collections.sort(employees, agecompa);
        for(Employee emp : employees) {
            System.out.println(emp);
        }
    }
}
