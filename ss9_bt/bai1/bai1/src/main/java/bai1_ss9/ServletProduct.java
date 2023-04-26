package bai1_ss9;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ServletProduct", value = "/ServletProduct")
public class ServletProduct extends HttpServlet {
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
        PrintWriter writer = response.getWriter();
        writer.println("<html>");
        writer.println("<h1>Product Description:" +description);
        writer.println("<h1>Product Price:" +price);
        writer.println("<h1>Product Discount Percent:" +discount_percent);
        writer.println("<h1>Product Amount:" +discount_amount);
        writer.println("<h1>Product Discount Price:" +discount_price);
        writer.println("</html>");



    }
}
