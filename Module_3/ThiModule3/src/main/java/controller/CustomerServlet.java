package controller;

import common.Validate;
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
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

@WebServlet(name = "CustomerServlet", urlPatterns = "/customer")
public class CustomerServlet extends HttpServlet {

    private CustomerService customerService = new CustomerServiceImpl();
    private CustomerTypeService customerTypeService = new CustomerTypeServiceImpl();

    private void submitDataFromModal(HttpServletRequest request, HttpServletResponse response){
        String id = request.getParameter("customerId");
        String messageId = Validate.validateCustomerId(id);

        String name = request.getParameter("customerName");
        String messageName = Validate.validateCustomerName(name);

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
        String messageIdCard = Validate.validateCustomerIdCard(idCard);

        String phone = request.getParameter("customerPhone");
        String messagePhone = Validate.validateCustomerPhone(phone);

        String email = request.getParameter("customerEmail");
        String messageEmail = Validate.validateEmail(email);

        String address = request.getParameter("customerAddress");

        int idCusType = Integer.parseInt(request.getParameter("customerTypeName"));

        CustomerType customerType = this.customerTypeService.findCusTypeById(idCusType);

        Customer customer = new Customer(id,name,customerBirthday,gender,idCard,phone,email,address,customerType);

        if (messageId == null && messageName == null && messageIdCard == null && messagePhone == null && messageEmail == null) {
            this.customerService.save(customer);
            customer = null;
        }


        request.setAttribute("messageId",messageId);
        request.setAttribute("messageName",messageName);
        request.setAttribute("messageIdCard",messageIdCard);
        request.setAttribute("messagePhone",messagePhone);
        request.setAttribute("messageEmail",messageEmail);

        showCustomerList(request, response);
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
        String id = request.getParameter("id");

        Customer customer = null;

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
        int idCusType = Integer.parseInt(request.getParameter("customerTypeName"));
        CustomerType customerType = this.customerTypeService.findCusTypeById(idCusType);

        customer = new Customer(id,name,customerBirthday,gender,idCard,phone,email,address,customerType);

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
        String id = request.getParameter("idCustomer");
        Customer customer = this.customerService.findCustomerById(id);
        if (customer != null){
            this.customerService.remove(id);
        }
        List<Customer> listCustomer = this.customerService.findAllCustomer();
        request.setAttribute("listCustomer", listCustomer);
        RequestDispatcher dispatcher = request.getRequestDispatcher("customer/customer.jsp");

        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void searchCustomer(HttpServletRequest request, HttpServletResponse response){
        String search = request.getParameter("search");
        List<Customer> listCustomer = this.customerService.search(search);

        request.setAttribute("listCustomer", listCustomer);
        RequestDispatcher dispatcher = request.getRequestDispatcher("customer/customer.jsp");

        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void sortUser(HttpServletRequest request, HttpServletResponse response){
//        String factor = request.getParameter("factor");
        String sortBy = request.getParameter("sortBy");

        List<Customer> listCustomer = this.customerService.sortCustomer(sortBy);
        request.setAttribute("listCustomer", listCustomer);
        RequestDispatcher dispatcher = request.getRequestDispatcher("customer/customer.jsp");

        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action){
            case "submitData": //create
                submitDataFromModal(request, response);
                break;
            case "edit":
                editCustomer(request, response);
                break;
            case "delete":
                deleteCustomer(request, response);
                break;
            default:
                break;
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        if (session != null) {
            String name = (String) session.getAttribute("uname");
            request.setAttribute("isLogin", "yes");
            request.setAttribute("employeeName",name);
        } else {
//            request.setAttribute("employeeName","You're not login");
            request.setAttribute("isLogin", "no");
        }

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
            case "search":
                searchCustomer(request, response);
                break;
            case "sort":
                sortUser(request, response);
            default:
                showCustomerList(request, response);
                break;
        }
    }

}
