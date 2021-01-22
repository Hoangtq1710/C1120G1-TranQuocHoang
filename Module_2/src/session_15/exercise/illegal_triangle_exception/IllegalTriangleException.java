package session_15.exercise.illegal_triangle_exception;

public class IllegalTriangleException extends Exception {

    public IllegalTriangleException(String message) {
        super(message);
    }

    @Override
    public String getMessage() {
        return "Triangle Exception : " +super.getMessage();
    }

}
