package session_06.practice.shape_class;

public class Square extends Rectangle{
    public Square() {
        this.width = 1.0;
        this.length = 1.0;
    }

    public Square(double size) {
        super(size,size);
    }
    public Square(String color, boolean filled, double size){
        super(color, filled, size, size);
    }
    public double getSide() {
        return getWidth();
    }

    public void setSide(double side) {
        setWidth(side);
        setLength(side);
    }

    @Override
    public void setWidth(double width) {
        setSide(width);
    }

    @Override
    public void setLength(double length) {
        setSide(length);
    }

    @Override
    public String toString() {
        return "A Square with side = " + getSide()+
                " which is a subclass of "+ super.toString();
    }
}
