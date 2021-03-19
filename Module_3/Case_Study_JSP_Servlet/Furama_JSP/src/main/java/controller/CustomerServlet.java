package controller;

import model.Customer;
import model.CustomerType;
import service.customer.CustomerService;
import service.customer.CustomerServiceImpl;
import service.customer_type.CustomerTypeService;
import service.customer_type.CustomerTypeServiceImpl;

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

@WebServlet(name = "CustomerServlet", urlPatterns = "/customer")
public class CustomerServlet extends HttpServlet {

    private CustomerService customerService = new CustomerServiceImpl();
    private CustomerTypeService customerTypeService = new CustomerTypeServiceImpl();

    private void submitDataFromModal(HttpServletRequest request, HttpServletResponse response){
        Customer customer = common(request, response);

        this.customerService.save(customer);

        List<Customer> listCustomer = this.customerService.findAllCustomer();
        request.setAttribute("listCustomer", listCustomer);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/customer/customer.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private Customer common(HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter("id");
        String name = request.getParameter("customerName");
        Date customerBirthday = null;
        SimpleDateFormat format = new SimpleDateFormat("yyyy-mm-dd");
        try {
            java.util.Date birthday = format.parse(request.getParameter("customerBirthday"));
            customerBirthday = new Date(birthday.getTime());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        boolean gender = (request.getParameter("customerGender").equals("Male"));
        String idCard = request.getParameter("customerIdCard");
        String phone = request.getParameter("customerPhone");
        String email = request.getParameter("customerEmail");
        String address = request.getParameter("customerAddress");
        String cusType = request.getParameter("customerTypeName");

        int idCusType;
        switch (cusType) {
            case "Diamond" :
                idCusType = 1;
                break;
            case "Platinum" :
                idCusType = 2;
                break;
            case "Gold" :
                idCusType = 3;
                break;
            case "Silver" :
                idCusType = 4;
                break;
            case "Member" :
                idCusType = 5;
                break;
            default:
                idCusType = 1;
                break;
        }
        CustomerType customerType = this.customerTypeService.findCusTypeById(idCusType);

        return new Customer(id,name,customerBirthday,gender,idCard,phone,email,address,customerType);
    }

    private void showCustomerList(HttpServletRequest request, HttpServletResponse response){
        List<Customer> listCustomer = this.customerService.findAllCustomer();
        request.setAttribute("listCustomer", listCustomer);
        RequestDispatcher dispatcher = request.getRequestDispatcher("customer/customer.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void viewCustomer(HttpServletRequest request, HttpServletResponse response){
        String id = request.getParameter("id");
        Customer customer = this.customerService.findCustomerById(id);
        request.setAttribute("customer", customer);
        RequestDispatcher dispatcher = request.getRequestDispatcher("customer/view-customer.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter("id");
        Customer customer = this.customerService.findCustomerById(id);
        request.setAttribute("customer", customer);
        RequestDispatcher dispatcher = request.getRequestDispatcher("customer/edit-customer.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void editCustomer(HttpServletRequest request, HttpServletResponse response){
        String id = request.getParameter("customerId");

        Customer customer = common(request, response);

        this.customerService.update(id, customer);
        request.setAttribute("customer", customer);
        List<Customer> listCustomer = this.customerService.findAllCustomer();
        request.setAttribute("listCustomer", listCustomer);
        RequestDispatcher dispatcher = request.getRequestDispatcher("customer/customer.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void deleteCustomer(HttpServletRequest request, HttpServletResponse response) {

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action){
            case "submitData":
                submitDataFromModal(request, response);
                break;
            case "edit":
                editCustomer(request, response);
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
            case "view":
                viewCustomer(request, response);
                break;
            case "edit":
                showEditForm(request, response);
                break;
            case "delete":
                deleteCustomer(request, response);
                break;
            default:
                showCustomerList(request, response);
                break;
        }
    }

}
