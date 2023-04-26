package bai1_ss9;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ServletProductC2", value = "/ServletProductC2")
public class ServletProductC2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String description = request.getParameter("description");
        float price =Float.parseFloat(request.getParameter("price"));
        int discount_percent = Integer.parseInt(request.getParameter("discount"));
        double discount_amount  =  price * discount_percent * 0.01;
        double discount_price = price-discount_amount ;
        request.setAttribute("description" ,description);
        request.setAttribute("price" ,price);
        request.setAttribute("discount_percent" ,discount_percent);
        request.setAttribute("discount_amount" ,discount_amount);
        request.setAttribute("discount_price" ,discount_price);

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("result.jsp");
        requestDispatcher.forward(request,response);
    }
}
