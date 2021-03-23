//package demo;
//
//import common.Validate;
//import model.bean.Customer;
//import model.bean.CustomerType;
//import model.service.CustomerService;
//import model.service.CustomerTypeService;
//import model.service.impl.CustomerServiceImpl;
//import model.service.impl.CustomerTypeServiceImpl;
//
//import javax.servlet.RequestDispatcher;
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//import java.sql.SQLException;
//import java.util.List;
//
//@WebServlet(name = "CustomerServlet", urlPatterns = "/customer")
//public class CustomerServlet extends HttpServlet {
//    private CustomerService customerService;
//    private CustomerTypeService customerTypeService;
//
//    public void init() {
//        customerService = new CustomerServiceImpl();
//        customerTypeService = new CustomerTypeServiceImpl();
//    }
//    protected void doPost(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        String action = request.getParameter("action");
//        if (action == null) {
//            action = "";
//        }
//
//        switch (action) {
//            case "create":
//                createCustomer(request, response);
//                break;
//            case "delete":
//                deleteCustomer(request, response);
//                break;
//        }
//
//    }
//
//    protected void doGet(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        String action = request.getParameter("action");
//        if (action == null) {
//            action = "";
//        }
//        switch (action) {
//            case "search":
//
//                break;
//            default:
//                listCustomer(request, response);
//                break;
//        }
//    }
//
//    private void listCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        List<Customer> listCus = customerService.getAll();
//        List<CustomerType> customerTypeList = customerTypeService.getAll();
//        request.setAttribute("listCus", listCus);
//        request.setAttribute("customerTypeList", customerTypeList);
//        RequestDispatcher dispatcher = request.getRequestDispatcher("customer/list.jsp");
//        dispatcher.forward(request, response);
//    }
//
//    private void deleteCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        int idCustomer = Integer.parseInt(request.getParameter("idCustomer"));
//        try {
//            customerService.deleteCus(idCustomer);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        this.listCustomer(request, response);
//    }
//
//    private void createCustomer(HttpServletRequest request, HttpServletResponse response) throws IOException {
//        String customerName = request.getParameter("customerName");
//        String message = Validate.validateCustomerName(customerName);
//        String birthday = request.getParameter("birthday");
//        boolean gender = Boolean.parseBoolean(request.getParameter("gender"));
//        CustomerType cusType = customerTypeService.getCusTypeById(Integer.parseInt(request.getParameter("cusType")));
//        Customer customer = new Customer(customerName, cusType, birthday, gender);;
//        System.out.println(message);
//        try {
//            if (message == null) {
//                customerService.addCus(customer);
//                customer = null;
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        List<CustomerType> customerTypeList = customerTypeService.getAll();
//        List<Customer> listCus = customerService.getAll();
//        System.out.println(message);
//        request.setAttribute("customer",customer);
//        request.setAttribute("message", message);
//        request.setAttribute("listCus", listCus);
//        request.setAttribute("customerTypeList", customerTypeList);
//        RequestDispatcher dispatcher = request.getRequestDispatcher("customer/list.jsp");
//        try {
//            dispatcher.forward(request, response);
//        } catch (ServletException e) {
//            e.printStackTrace();
//        }
//    }
//}
