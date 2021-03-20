package controller;

import model.*;
import service.division.DivisionService;
import service.division.DivisionServiceImpl;
import service.edu_degree.EduDegreeService;
import service.edu_degree.EduDegreeServiceImpl;
import service.employee.EmployeeService;
import service.employee.EmployeeServiceImpl;
import service.position.PositionService;
import service.position.PositionServiceImpl;
import service.user.UserService;
import service.user.UserServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

@WebServlet(name = "EmployeeServlet", urlPatterns = "/employee")
public class EmployeeServlet extends HttpServlet {
    EmployeeService employeeService = new EmployeeServiceImpl();
    PositionService positionService = new PositionServiceImpl();
    EduDegreeService eduDegreeService = new EduDegreeServiceImpl();
    DivisionService divisionService = new DivisionServiceImpl();
    UserService userService = new UserServiceImpl();

    private void showEmployeeList(HttpServletRequest request, HttpServletResponse response){
        List<Employee> listEmployee = this.employeeService.findAllEmployee();
        request.setAttribute("listEmployee", listEmployee);
        RequestDispatcher dispatcher = request.getRequestDispatcher("employee/employee.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }
    private void submitDataFromModal(HttpServletRequest request, HttpServletResponse response){
        Employee employee = common(request, response);
        this.employeeService.save(employee);

        List<Employee> listEmployee = this.employeeService.findAllEmployee();
        request.setAttribute("listEmployee", listEmployee);
        RequestDispatcher dispatcher = request.getRequestDispatcher("employee/employee.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private Employee common(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("employeeName");
        Date employeeBirthday = null;
        SimpleDateFormat format = new SimpleDateFormat("yyyy-mm-dd");
        try {
            java.util.Date birthday = format.parse(request.getParameter("birthday"));
            employeeBirthday = new Date(birthday.getTime());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        String idCard = request.getParameter("idCard");
        double salary = Double.parseDouble(request.getParameter("salary"));
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        Position position = this.positionService.findById(Integer.parseInt(request.getParameter("position")));
        EduDegree eduDegree = this.eduDegreeService.findById(Integer.parseInt(request.getParameter("eduDegree")));
        Division division = this.divisionService.findById(Integer.parseInt(request.getParameter("division")));
        String username = request.getParameter("username");
        this.userService.createAccount(username);
        User user = new User(username, username);

        return new Employee(name,employeeBirthday,idCard,salary,phone,email,address,position,eduDegree,division,user);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action){
            case "submitData" :
                submitDataFromModal(request, response);
                break;
            default:
                break;
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action){

            default:
                showEmployeeList(request, response);
                break;
        }
    }
}
