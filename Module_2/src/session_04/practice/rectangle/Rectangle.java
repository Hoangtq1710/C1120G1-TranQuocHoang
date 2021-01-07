package session_04.practice.rectangle;

public class Rectangle {
    private double width;
    private double height;

    public Rectangle(double width, double height) {
        this.height = height;
        this.width = width;
    }
    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }
    public double getArea(){
        return this.width * this.height;
    }
    public double getPerimeter(){
        return (this.width + this.height)*2;
    }
    public String display(){
        return "Rectangle{ width = "+this.width+"; height = "+this.height+"}";
    }
}