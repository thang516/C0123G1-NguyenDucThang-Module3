package controller;

import model.TypeServices;
import service.TypeSService;
import service.TypeServiceService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "TypeServiceServlet", value = "/type-service")
public class TypeServiceServlet extends HttpServlet {

    private TypeServiceService typeServiceService = new TypeSService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        int maDichVu ;
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                request.getRequestDispatcher("/create.jsp").forward(request, response);
                break;
            case "delete":
                 maDichVu = Integer.parseInt(request.getParameter("maDichVu"));
                typeServiceService.delete(maDichVu);
                response.sendRedirect("/type-service");
                break;
            case "edit":
                maDichVu = Integer.parseInt(request.getParameter("maDichVuEdit"));
                request.setAttribute("maDichVuEdit",maDichVu);
                request.getRequestDispatcher("/edit.jsp").forward(request,response);
                break;

            default:
                List<TypeServices> typeServiceList = typeServiceService.getAll();
                request.setAttribute("typeServiceList", typeServiceList);
                request.getRequestDispatcher("/list.jsp").forward(request, response);

        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        int maDichVu;
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                create(request, response);
                break;
            case "edit" :

                maDichVu = Integer.parseInt(request.getParameter("maDichVuEdit"));
                int maLoaiDichVu = Integer.parseInt(request.getParameter("maLoaiDichVu"));
                String tenLoaiDichVu = request.getParameter("tenLoaiDichVu");
                TypeServices typeServices = new TypeServices(maDichVu, maLoaiDichVu, tenLoaiDichVu);
                typeServiceService.edit(typeServices);
                response.sendRedirect("/type-service");
                break;
                
        }
    }

    public void create(HttpServletRequest request, HttpServletResponse response) throws IOException {

        int   maDichVu = Integer.parseInt(request.getParameter("maDichVu"));
        int maLoaiDichVu = Integer.parseInt(request.getParameter("maLoaiDichVu"));
        String tenLoaiDichVu = request.getParameter("tenLoaiDichVu");
        TypeServices typeServices = new TypeServices(maDichVu, maLoaiDichVu, tenLoaiDichVu);
        typeServiceService.save(typeServices);
        response.sendRedirect("/type-service");
    }
}
