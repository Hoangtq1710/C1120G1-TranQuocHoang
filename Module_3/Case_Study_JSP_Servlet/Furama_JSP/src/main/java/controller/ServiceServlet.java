package controller;

import model.RentType;
import model.Service;
import model.ServiceType;
import service.rent_type.RentTypeService;
import service.rent_type.RentTypeServiceImpl;
import service.service.ServiceService;
import service.service.ServiceServiceImpl;
import service.service_type.ServiceTypeService;
import service.service_type.ServiceTypeServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ServiceServlet", urlPatterns = "/service")
public class ServiceServlet extends HttpServlet {
    ServiceService serviceService = new ServiceServiceImpl();
    RentTypeService rentTypeService = new RentTypeServiceImpl();
    ServiceTypeService serviceTypeService = new ServiceTypeServiceImpl();

    private void showServiceList(HttpServletRequest request, HttpServletResponse response){
        List<Service> listService = this.serviceService.findAllService();
        request.setAttribute("listService", listService);
        RequestDispatcher dispatcher = request.getRequestDispatcher("service/service.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void submitDataFromModal(HttpServletRequest request, HttpServletResponse response){
        String id = request.getParameter("serviceId");
        int area = Integer.parseInt(request.getParameter("serviceArea"));
        double cost = Double.parseDouble(request.getParameter("serviceCost"));
        int maxPp = Integer.parseInt(request.getParameter("maxPeople"));
        String standardRoom = request.getParameter("standardRoom");
        String description = request.getParameter("description");
        double poolArea = Double.parseDouble(request.getParameter("poolArea"));
        int noF = Integer.parseInt(request.getParameter("numOfFloor"));

        RentType rentType = this.rentTypeService.findById(Integer.parseInt(request.getParameter("rentType")));
        ServiceType serviceType = this.serviceTypeService.findById(Integer.parseInt(request.getParameter("serviceType")));
        String name = serviceType.getServiceTypeName() + id.substring(2,7);

        Service service = new Service(id,name,area,cost,maxPp,standardRoom,description,poolArea,noF,rentType,serviceType);

        this.serviceService.save(service);

        List<Service> listService = this.serviceService.findAllService();

        request.setAttribute("listService", listService);
        RequestDispatcher dispatcher = request.getRequestDispatcher("service/service.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void viewService(HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter("id");
        Service service = this.serviceService.findServiceById(id);

        request.setAttribute("service", service);
        RequestDispatcher dispatcher = request.getRequestDispatcher("service/view-service.jsp");
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
            case "submitData":
                submitDataFromModal(request, response);
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
                viewService(request, response);
                break;
            default:
                showServiceList(request, response);
                break;
        }
    }
}
