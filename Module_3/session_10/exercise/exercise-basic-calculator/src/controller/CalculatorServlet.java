package controller;

import model.Calculator;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "CalculatorServlet", urlPatterns = {"","/calculator"})
public class CalculatorServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        float first = Float.parseFloat(request.getParameter("first"));
        float second = Float.parseFloat(request.getParameter("second"));
        char operator = request.getParameter("operator").charAt(0);


        PrintWriter writer = response.getWriter();
        writer.println("<html>");
        writer.println("<h1>Result :</h1>\n");
        try {
            float result = Calculator.calculate(first,second,operator);
            writer.println(first+" "+operator+" "+second+" = "+result);
        } catch (Exception e) {
            writer.println("Error : "+e.getMessage());
        }
        writer.println("</html>");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("calculator/calculator.jsp");
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
