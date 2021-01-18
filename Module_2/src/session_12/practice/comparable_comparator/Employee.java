package session_12.practice.comparable_comparator;

public class Employee implements Comparable<Employee>{
    private String name;
    private int age;
    private String address;

    public Employee() {
    }

    public Employee(String name, int age, String address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return  "Employee "+this.name+
                ", Age "+this.age+
                ", Address : "+this.address;
    }

    @Override
    public int compareTo(Employee employee) {
        return this.getName().compareTo(employee.getName());
    }
}
