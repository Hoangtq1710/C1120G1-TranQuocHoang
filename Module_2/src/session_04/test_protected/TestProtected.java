package session_4.test_protected;

import session_05.exercise.access_modifier.Circle;

public class TestProtected extends Circle {
    public static void main(String[] args) {
        TestProtected pro = new TestProtected();
        System.out.println(pro.getRadius());
        System.out.println(pro.Test());
    }
    public double Test(){
        return this.radius = 7.5;
    }
}