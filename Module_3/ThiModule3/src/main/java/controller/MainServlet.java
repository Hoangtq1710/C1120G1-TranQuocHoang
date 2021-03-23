package controller;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "MainServlet", urlPatterns = {"", "/home"})
public class MainServlet extends HttpServlet {

    private void showIndexPage(HttpServletRequest request, HttpServletResponse response){

        RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }


    private void userLogout(HttpServletRequest request, HttpServletResponse response) {
        request.setAttribute("isLogin", "no");
        HttpSession session = request.getSession();
        session.invalidate();
        showIndexPage(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action){
            case "login":
                break;
            case "logout":
                userLogout(request,response);
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
            request.setAttribute("isLogin", "no");
        }

        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action){
            default:
                showIndexPage(request,response);
                break;
        }
    }
}
