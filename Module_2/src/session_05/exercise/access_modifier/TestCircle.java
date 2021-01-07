package session_05.exercise.access_modifier;

public class TestCircle {
    public static void main(String[] args) {
        Circle circle = new Circle(7.5);
        System.out.println("Radius of Circle is "+circle.getRadius());
        System.out.println("Area of Circle is "+Math.floor(circle.getArea()*100)/100);
    }
}
