package com.example.controller;

import com.example.model.User;
import com.example.service.IUserService;
import com.example.service.UserService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "UserServlet", value = "/users")
public class UserServlet extends HttpServlet {
    private IUserService userService = new UserService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            String action = request.getParameter("action");
            if(action==null){
                action="";
            }
        List<User> userList;
            switch (action){
                case "create":
                    request.getRequestDispatcher("/create.jsp").forward(request,response);
                    break;


                default:
                     userList = userService.getAll();
                    request.setAttribute("userList",userList);
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

            case "create":
                int id = Integer.parseInt(request.getParameter("id"));
                String name = request.getParameter("name");
                String email = request.getParameter("email");
                String country = request.getParameter("country");
                User user = new User(id,name,email,country);
                userService.save(user);
                response.sendRedirect("/users");
            break;
            case "find":

                String countrys = request.getParameter("countrys");
                List<User>  userList1 = userService.findUser(countrys);
                request.setAttribute("userList",userList1);
                request.getRequestDispatcher("/list.jsp").forward(request,response);
                break;
        }
    }
}
