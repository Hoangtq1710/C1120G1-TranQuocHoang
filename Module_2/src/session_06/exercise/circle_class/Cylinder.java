package session_06.exercise.circle_class;

public class Cylinder extends Circle{
    double height;

    public Cylinder() {
    }

    public Cylinder(double height) {
        this.height = height;
    }

    public Cylinder(double radius, String color, double height) {
        super(radius, color);
        this.height = height;
    }
    public double getVolume(){
        return super.getArea() * this.height;
    }

    @Override
    public String toString() {
        return "Cylinder have" +
                " height = " + this.height +
                " , volume = "+ this.getVolume()+
                " which is a subclass of "+ super.toString();
    }
}
