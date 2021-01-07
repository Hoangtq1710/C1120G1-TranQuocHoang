package session_3.practice;

import java.util.Scanner;

public class FindingElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] student = {"Le Quang", "Vi", "Sang", "Thuan", "Linh",
                            "Hoang", "Hoang Van", "Khoa", "Duc", "Tung",
                            "Nghia", "Ngoc", "Van Quang", "Cai Van"};
        System.out.println("Enter a name");
        String name = scanner.nextLine();

        for (int i = 0; i < student.length; i++) {
            System.out.print((i+1)+"."+student[i]+" ");
        }
        System.out.println("\n");
        boolean flag = true;
        for (int i = 0; i < student.length; i++) {
            if (student[i].equals(name)) {
                System.out.println("Position of student "+student[i]+" in the list is : "+(i+1));
                flag = false;
                break;
            }
        }
        if (flag) {
            System.out.println("Oops, "+name+" is not in our list!");
        }
    }
}
