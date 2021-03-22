package controller;

import model.Contract;
import model.Customer;
import model.Employee;
import model.Service;
import service.contract.ContractService;
import service.contract.ContractServiceImpl;
import service.customer.CustomerService;
import service.customer.CustomerServiceImpl;
import service.employee.EmployeeService;
import service.employee.EmployeeServiceImpl;
import service.service.ServiceService;
import service.service.ServiceServiceImpl;

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

@WebServlet(name = "ContractServlet", urlPatterns = "/contract")
public class ContractServlet extends HttpServlet {

    ContractService contractService = new ContractServiceImpl();
    EmployeeService employeeService = new EmployeeServiceImpl();
    CustomerService customerService = new CustomerServiceImpl();
    ServiceService serviceService = new ServiceServiceImpl();

    private void showContractList(HttpServletRequest request, HttpServletResponse response){

        List<Employee> listEmployee = this.employeeService.findAllEmployee();
        List<Customer> listCustomer = this.customerService.findAllCustomer();
        List<Service> listService = this.serviceService.findAllService();
        List<Contract> listContract = this.contractService.findAllContract();

        request.setAttribute("listEmployee",listEmployee);
        request.setAttribute("listCustomer",listCustomer);
        request.setAttribute("listService",listService);
        request.setAttribute("listContract", listContract);
        RequestDispatcher dispatcher = request.getRequestDispatcher("contract/contract.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void submitDataFromModal(HttpServletRequest request, HttpServletResponse response){
        System.out.println("da vao submit");
        int employeeId = Integer.parseInt(request.getParameter("employeeId"));
        String customerId = request.getParameter("customerId");
        String serviceId = request.getParameter("serviceId");
        System.out.println("employeeId "+employeeId);
        System.out.println("customerId "+customerId);
        System.out.println("serviceId "+serviceId);

        Employee employee = this.employeeService.findEmployeeById(employeeId);
        Customer customer = this.customerService.findCustomerById(customerId);
        Service service = this.serviceService.findServiceById(serviceId);

        Date startDate = null;
        Date endDate = null;
        SimpleDateFormat format = new SimpleDateFormat("yyyy-mm-dd");
        try {
            java.util.Date start = format.parse(request.getParameter("startDate"));
            java.util.Date end = format.parse(request.getParameter("endDate"));
            startDate = new Date(start.getTime());
            endDate = new Date(end.getTime());
        } catch (ParseException e) {
            e.printStackTrace();

        }
        int deposit = Integer.parseInt(request.getParameter("deposit"));
        int totalMoney = Integer.parseInt(request.getParameter("totalMoney"));

        Contract contract = new Contract(startDate,endDate,deposit,totalMoney,employee,customer,service);

        this.contractService.save(contract);

        showContractList(request, response);

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
            default:
                showContractList(request, response);
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
                showContractList(request, response);
                break;
        }
    }
}
