package session_06.exercise.circle_class;

public class TestCircle {
    public static void main(String[] args) {
        Circle circle = new Circle(4.5,"green");
        Cylinder cylinder = new Cylinder(circle.getRadius(), circle.getColor(), 8.4);

        System.out.println(cylinder);
    }
}
