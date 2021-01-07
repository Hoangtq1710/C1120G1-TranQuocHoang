package session_04.exercise;

public class Fan {
    private int speed = 1;
    private boolean on = false;
    private int radius = 5;
    private String color = "blue";
    private final String slow = "SLOW";
    private final String medium = "MEDIUM";
    private final String fast = "FAST";

    public Fan() {
    }

    public Fan(int speed, boolean on, int radius, String color) {
        this.speed = speed;
        this.on = on;
        this.radius = radius;
        this.color = color;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public boolean isOn() {
        return on;
    }

    public void setOn(boolean on) {
        this.on = on;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
    public String displaySpeed(){
        String displaySpeed = "";
        switch (this.getSpeed()){
            case 1:
                displaySpeed = slow;
                break;
            case 2:
                displaySpeed = medium;
                break;
            case 3:
                displaySpeed = fast;
                break;
            default:
                displaySpeed = "failed";
                break;
        }
        return displaySpeed;
    }

    @Override
    public String toString() {
        if (this.isOn()){
            return "Fan{" +
                    "fan is on" +
                    ", speed = " + this.displaySpeed() +
                    ", radius = " + this.radius +
                    ", color = '" + this.color + '\'' +
                    '}';
        } else {
            return "Fan{" +
                    "fan is off" +
                    ", radius = " + this.radius +
                    ", color = '" + this.color + '\'' +
                    '}';
        }
    }

    public static void main(String[] args) {

        Fan fan1 = new Fan(3, true, 10, "yellow");
        Fan fan2 = new Fan(2, false, 5, "blue");

        System.out.println(fan1);
        System.out.println(fan2);
    }
}
