package controller;

import model.Customer;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "CustomerServlet", urlPatterns = {"","/customer"})
public class CustomerServlet extends HttpServlet {

    private static List<Customer> customerList;

    @Override
    public void init() throws ServletException {
        customerList = new ArrayList<>();
        customerList.add(new Customer(1,"Dong", "1985-03-07","Da Nang","icon4.png"));
        customerList.add(new Customer(2,"Khoa", "1999-12-02","Hue","icon1.png"));
        customerList.add(new Customer(3,"Quang", "1997-06-11","Da Nang","icon5.png"));
        customerList.add(new Customer(4,"Sang", "1999-03-07","Da Nang","icon6.png"));
        customerList.add(new Customer(5,"Hoang", "1995-10-17","Da Nang","icon3.png"));
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("customerList", customerList);

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/customer/customer_list.jsp");
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
