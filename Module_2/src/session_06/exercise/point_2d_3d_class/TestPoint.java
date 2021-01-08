package session_06.exercise.point_2d_3d_class;

public class TestPoint {
    public static void main(String[] args) {
        Point2D point2D = new Point2D(4.5f,6.5f);
        Point3D point3D = new Point3D(8.5f);

        point3D.setXY(point2D.getX(),point2D.getY());

        System.out.println(point2D);
        System.out.println(point3D);
    }
}
