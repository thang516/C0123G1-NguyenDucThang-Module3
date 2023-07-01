package controller;

import Repository.IManagerRepository;
import model.Pet;
import model.Phat;
import service.IManagerService;
import service.ManagerService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ManageServlet", value = "/manage")
public class ManageServlet extends HttpServlet {
    private IManagerService managerService = new ManagerService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if(action==null){
            action="";
        }
        switch (action){
            case "create":
                request.getRequestDispatcher("/create.jsp").forward(request,response);
                break;


            default:
                List<Phat> phatList =  managerService.getAll();
                request.setAttribute("phatList",phatList);
                request.getRequestDispatcher("/list.jsp").forward(request,response);
                break;
        }



    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if(action==null){
            action="";
        }

        switch (action){
            case "create" :
                String user = request.getParameter("user");
                int id = Integer.parseInt(request.getParameter("id"));
                String information =request.getParameter("information");
                String dateTime = request.getParameter("dateTime");
                String money = request.getParameter("money");
            Phat phat = new Phat(user,id,information,dateTime,money);
                managerService.save(phat);
                response.sendRedirect("/manage");
                break;
            case "delete":


                break;


        }
    }
}
