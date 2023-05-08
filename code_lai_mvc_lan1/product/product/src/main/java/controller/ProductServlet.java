package controller;

import model.Product;
import service.IProductService;
import service.ProductService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ProductServlet", value = "/product")
public class ProductServlet extends HttpServlet {
    private IProductService productService = new ProductService();
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
                    List<Product> productList = productService.getAll();
                    if(productList==null){
                        request.getRequestDispatcher("/error.jsp").forward(request,response);
                    }else {
                    request.setAttribute("productList",productList);
                    request.getRequestDispatcher("/list.jsp").forward(request,response);

                    }
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
                int id = Integer.parseInt(request.getParameter("id"));
                String name = request.getParameter("name");
                Float price = Float.valueOf(request.getParameter("price"));
                String description = request.getParameter("description");
                Product product = new Product(id,name,price,description);
                productService.save(product);
                response.sendRedirect("/product");
                break;
            case "delete" :
                System.out.println(111111);
                 id = Integer.parseInt(request.getParameter("id"));
                productService.delete(id);
                response.sendRedirect("/product");
                break;
        }




    }
}
