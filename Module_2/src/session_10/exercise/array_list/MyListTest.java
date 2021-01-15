package session_10.exercise.array_list;

public class MyListTest {
    public static class Student {
        private int id;
        private String name;

        public Student() {
        }

        public Student(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return  "Student "+this.id+
                    ", Name "+this.name;
        }
    }

    public static void main(String[] args) {
        Student student1 = new Student(1,"Hoang");
        Student student2 = new Student(2,"Duc");
        Student student3 = new Student(3,"Khoa");
        Student student4 = new Student(4,"Quang");
        Student student5 = new Student(5,"Thuan");
        Student student6 = new Student(6,"Tung");
        Student student7 = new Student(7,"Nghia");

        MyList<Student> list = new MyList<>();

        list.add(student1);
        list.add(student2);
        list.add(student3);
        list.add(student4);
        list.add(student5);
        list.add(student6);

        list.add(3,student7);
        list.remove(5);

        list.printList();
        System.out.println("Index of "+student5+" is "+list.indexOf(student5));

        if (list.contains(student3)) {
            System.out.println("True");
        }
        System.out.println("Element 5 is "+list.get(4));
        System.out.println("Size of list is "+ list.size());
        list.clear();
        list.printList();

    }
}
