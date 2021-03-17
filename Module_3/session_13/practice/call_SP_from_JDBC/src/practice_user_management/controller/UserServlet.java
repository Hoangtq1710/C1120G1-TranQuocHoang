package practice_user_management.controller;

import practice_user_management.model.User;
import practice_user_management.service.UserService;
import practice_user_management.service.UserServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "UserServlet", urlPatterns = {"", "/users"})
public class UserServlet extends HttpServlet {
    private UserService userService = new UserServiceImpl();

    private void listUser(HttpServletRequest request, HttpServletResponse response) {
//        List<User> listUser = this.userService.selectAllUsers();
        List<User> listUser = this.userService.findAllUser();
        request.setAttribute("listUser", listUser);
        RequestDispatcher dispatcher = request.getRequestDispatcher("user/list.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher dispatcher = request.getRequestDispatcher("user/create.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void insertUser(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String country = request.getParameter("country");
        User user = new User(name, email, country);
        //            this.userService.insertUser(user);
        this.userService.insertUserSP(user);

//        List<User> listUser = this.userService.selectAllUsers();
        List<User> listUser = this.userService.findAllUser();
        request.setAttribute("listUser", listUser);
        RequestDispatcher dispatcher = request.getRequestDispatcher("user/list.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
//        User user = this.userService.selectUser(id); SESSION_12
        User user = this.userService.getUserById(id); // SESSION_13
        RequestDispatcher dispatcher;
        if (user == null) {
            dispatcher = request.getRequestDispatcher("error-404.jsp");
        } else {
            request.setAttribute("user", user);
            dispatcher = request.getRequestDispatcher("user/edit.jsp");
        }
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void updateUser(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String country = request.getParameter("country");
//        User user = this.userService.selectUser(id);
        User user  = this.userService.getUserById(id);
        User userUpdate = new User(id, name, email, country);
        RequestDispatcher dispatcher;
        if (user == null) {
            dispatcher = request.getRequestDispatcher("error-404.jsp");
        } else {
            //                this.userService.updateUser(userUpdate);
            this.userService.updateUserSP(userUpdate);

            request.setAttribute("user", userUpdate);
//            List<User> listUser = this.userService.selectAllUsers();
            List<User> listUser = this.userService.findAllUser();
            request.setAttribute("listUser", listUser);
            dispatcher = request.getRequestDispatcher("user/list.jsp");
        }
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void showDeleteForm(HttpServletRequest request, HttpServletResponse response){
        int id = Integer.parseInt(request.getParameter("id"));
//        User user = this.userService.selectUser(id);
        User user = this.userService.getUserById(id);
        RequestDispatcher dispatcher;
        if (user == null) {
            dispatcher = request.getRequestDispatcher("error-404.jsp");
        } else {
            request.setAttribute("user", user);
            dispatcher = request.getRequestDispatcher("user/delete.jsp");
        }
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void deleteUser(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
//        User user = this.userService.selectUser(id);
        User user = this.userService.getUserById(id);
        RequestDispatcher dispatcher;

        if (user == null) {
            dispatcher = request.getRequestDispatcher("error-404.jsp");
        } else {
            //                this.userService.deleteUser(id);
            this.userService.deleteUserSP(id);
            request.setAttribute("message", "User has ID : "+id+" was deleted!!");
            request.setAttribute("user", user);
            dispatcher = request.getRequestDispatcher("user/delete.jsp");
        }
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void viewUser(HttpServletRequest request, HttpServletResponse response){
        int id = Integer.parseInt(request.getParameter("id"));
//        User user = this.userService.selectUser(id);
        User user = this.userService.getUserById(id);
        RequestDispatcher dispatcher;
        if (user == null) {
            dispatcher = request.getRequestDispatcher("error-404.jsp");
        } else {
            request.setAttribute("user", user);
            dispatcher = request.getRequestDispatcher("/user/view.jsp");
        }
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void searchUser(HttpServletRequest request, HttpServletResponse response){
        String country = request.getParameter("country");
        List<User> listUser = this.userService.searchUser(country);
        RequestDispatcher dispatcher;
        if (listUser.isEmpty()) {
            dispatcher =request.getRequestDispatcher("error-404.jsp");
        } else {
            request.setAttribute("listUser", listUser);
            dispatcher = request.getRequestDispatcher("user/search.jsp");
        }
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void sortListByName(HttpServletRequest request, HttpServletResponse response){
        String sortBy = request.getParameter("sortBy");

        List<User> listUser = this.userService.sortListUser(sortBy);

        RequestDispatcher dispatcher;
        request.setAttribute("listUser", listUser);
         dispatcher = request.getRequestDispatcher("user/list.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void addUserPermission(HttpServletRequest request, HttpServletResponse response){
        User user = new User("Duc", "duc@gmail.com", "Mexico");
        int[] permission = {1,2,4};
        this.userService.addUserTransaction(user, permission);
    }

    private void testWithoutTran(HttpServletRequest request, HttpServletResponse response) {
        this.userService.insertUpdateWithoutTransaction();
    }

    private void testUseTran(HttpServletRequest request, HttpServletResponse response) {
        this.userService.insertUpdateUseTransaction();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                insertUser(request, response);
                break;
            case "edit":
                updateUser(request, response);
                break;
            case "delete":
                deleteUser(request, response);
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
        switch (action) {
            case "create":
                showNewForm(request, response);
                break;
            case "edit":
                showEditForm(request, response);
                break;
            case "delete":
                showDeleteForm(request, response);
                break;
            case "view":
                viewUser(request, response);
                break;
            case "search":
                searchUser(request, response);
                break;
            case "sort":
                sortListByName(request, response);
                break;
            case "permission":
                addUserPermission(request, response);
                break;
            case "test-without-tran":
                testWithoutTran(request, response);
                break;
            case "test-use-tran":
                testUseTran(request, response);
                break;
            default:
                listUser(request, response);
                break;
        }
    }
}
