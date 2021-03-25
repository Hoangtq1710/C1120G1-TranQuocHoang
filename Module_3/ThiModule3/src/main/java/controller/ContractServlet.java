package controller;

import model.Product;
import repository.ProductRepository;
import service.ProductService;
import service.ProductServiceImpl;

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

    ProductService productService = new ProductServiceImpl();

    private void showList(HttpServletRequest request, HttpServletResponse response){
        List<Product> listProduct = this.productService.findAllProduct();

        request.setAttribute("listProduct",listProduct);
        RequestDispatcher dispatcher = request.getRequestDispatcher("contract/contract.jsp");

        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }

    }
    private void showCreateForm(HttpServletRequest request, HttpServletResponse response){

        try {
            response.sendRedirect("contract/create-contract.jsp");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void createProduct(HttpServletRequest request, HttpServletResponse response){
        String name = request.getParameter("productName");
        int price = Integer.parseInt(request.getParameter("price"));
        int percent = Integer.parseInt(request.getParameter("percent"));
        int stock = Integer.parseInt(request.getParameter("stock"));

        Product product = new Product(name, price, percent, stock);

        this.productService.save(product);

        List<Product> listProduct = this.productService.findAllProduct();

        request.setAttribute("listProduct",listProduct);
        RequestDispatcher dispatcher = request.getRequestDispatcher("contract/contract.jsp");

        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }
    private void showTopView(HttpServletRequest request, HttpServletResponse response){
        int number = Integer.parseInt(request.getParameter("number"));
        List<Product> listProduct = this.productService.topView(number);

        request.setAttribute("listProduct",listProduct);
        RequestDispatcher dispatcher = request.getRequestDispatcher("contract/contract.jsp");

        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }
    private void showDistance(HttpServletRequest request, HttpServletResponse response){
        Date start = null;
        Date end = null;
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        try {
            java.util.Date startDay = format.parse(request.getParameter("start"));
            java.util.Date endDay = format.parse(request.getParameter("end"));
            start = new Date(startDay.getTime());
            end = new Date(endDay.getTime());
        } catch (ParseException e) {
            e.printStackTrace();
        }

        List<Product> listProduct = this.productService.distance(start, end);

       request.setAttribute("start", start);
       request.setAttribute("end", end);
        request.setAttribute("listProduct",listProduct);
        RequestDispatcher dispatcher = request.getRequestDispatcher("contract/contract.jsp");

        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }


    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null){
            action = "";
        }
        switch (action) {
            case "create":
                createProduct(request, response);
                break;
            case "topview":
                showTopView(request, response);
                break;
            case "distance":
                showDistance(request, response);
                break;


            default:
                showList(request, response);
                break;
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null){
            action = "";
        }
        switch (action) {
            case "create":
                showCreateForm(request, response);
                break;

            default:
                showList(request, response);
                break;
        }
    }
}
