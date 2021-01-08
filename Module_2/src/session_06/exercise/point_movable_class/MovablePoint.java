package session_06.exercise.point_movable_class;

import session_06.exercise.point_2d_3d_class.Point2D;

public class MovablePoint extends Point2D {
    public float xSpeed = 0.0f;
    public float ySpeed = 0.0f;

    public MovablePoint() {
    }

    public MovablePoint(float xSpeed, float ySpeed) {
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    public MovablePoint(float x, float y, float xSpeed, float ySpeed) {
        super(x, y);
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    public float getXSpeed() {
        return xSpeed;
    }

    public void setXSpeed(float xSpeed) {
        this.xSpeed = xSpeed;
    }

    public float getYSpeed() {
        return ySpeed;
    }

    public void setYSpeed(float ySpeed) {
        this.ySpeed = ySpeed;
    }
    public void setSpeed(float xSpeed, float ySpeed){
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }
    public float[] getSpeed(){
        float[] speed = new float[2];
        speed[0] = this.xSpeed;
        speed[1] = this.ySpeed;
        return speed;
    }

    @Override
    public String toString() {
        return "MovablePoint : (" +
                "x = " + this.x +
                ", y = " + this.y +
                " ), speed = ( " + this.xSpeed +
                ", " + this.ySpeed +" )";
    }
    public MovablePoint move(){
        x += xSpeed;
        y += ySpeed;
        return this;
    }
}