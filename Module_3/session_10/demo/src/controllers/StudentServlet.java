package controllers;

import model.Student;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "StudentServlet", urlPatterns = {"", "/student"})
public class StudentServlet extends HttpServlet {

    private static List<Student> studentList;

    @Override
    public void init() throws ServletException {
        studentList = new ArrayList<>();
        studentList.add(new Student(1, "Khoa", 1, 90, "icon1.png"));
        studentList.add(new Student(2, "Quang", 0, 80, "icon3.png"));
        studentList.add(new Student(3, "Ngoc", 1, 100, "icon5.png"));
        studentList.add(new Student(4, "Thuan", 0, 95, "icon2.png"));
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("studentList", studentList);

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/student/list.jsp");
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
