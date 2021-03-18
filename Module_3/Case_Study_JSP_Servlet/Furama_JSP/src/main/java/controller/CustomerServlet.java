package controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "CustomerServlet", urlPatterns = "customer")
public class CustomerServlet extends HttpServlet {

    private void customerList(HttpServletRequest request, HttpServletResponse response){
        try {
            response.sendRedirect("../webapp/customer/customer.jsp");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        switch (action){
            case "create":
                break;
            default:
                customerList(request, response);
                break;
        }
    }
}
