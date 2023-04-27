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
        int discountPercent = Integer.parseInt(request.getParameter("discount"));
        double discountAmount  =  price * discountPercent * 0.01;
        double discountPrice = price-discountAmount ;
        request.setAttribute("description" ,description);
        request.setAttribute("price" ,price);
        request.setAttribute("discountPercent" ,discountPercent);
        request.setAttribute("discountAmount" ,discountAmount);
        request.setAttribute("discountPrice" ,discountPrice);

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("result.jsp");
        requestDispatcher.forward(request,response);
    }
}
