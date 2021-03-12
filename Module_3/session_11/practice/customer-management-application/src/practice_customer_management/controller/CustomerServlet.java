package practice_customer_management.controller;

import practice_customer_management.model.Customer;
import practice_customer_management.service.CustomerService;
import practice_customer_management.service.CustomerServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "CustomerServlet", urlPatterns = {"", "/customer"})
public class CustomerServlet extends HttpServlet {

    private CustomerService customerService = new CustomerServiceImpl();

    private void listCustomer(HttpServletRequest request, HttpServletResponse response) {
        List<Customer> customers = this.customerService.findAll();
        request.setAttribute("customer",customers);
        //buoc 7
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action =  request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create" :
                break;
            case "edit" :
                break;
            case "delete":
                break;
            default:
                break;
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action =  request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create" :
                break;
            case "edit" :
                break;
            case "delete":
                break;
            case "view":
                break;
            default:
                listCustomer(request,response);
                break;
        }
    }
}
