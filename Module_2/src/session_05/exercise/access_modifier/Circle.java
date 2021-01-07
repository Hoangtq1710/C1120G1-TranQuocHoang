package session_05.exercise.access_modifier;

public class Circle {
    protected double radius = 1.0;
    protected String color = "red";

    public Circle() {
    }

    public Circle(double radius) {
        this.radius = radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getRadius(){
        return this.radius;
    }
    public double getArea(){
        return (Math.PI * this.radius * this.radius);
    }
}
