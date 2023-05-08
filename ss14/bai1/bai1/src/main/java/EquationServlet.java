import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "EquationServlet", value = "/equal")
public class EquationServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action=request.getParameter("action");
        if (action==null){
            action="";
        }
        switch (action){
            case "":
                giaiPhuongTrinh(request,response);
                break;


        }
    }
    private void giaiPhuongTrinh(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int a= Integer.parseInt(request.getParameter("a"));
        int b= Integer.parseInt(request.getParameter("b"));
        int c= Integer.parseInt(request.getParameter("c"));
        String message ="";
        if (a == 0) {
            if (b == 0) {
                message="Phương Trình Vô Nghiệm!";
            } else {
                message= "Phương Trình Có 1 Nghiệm: x= " + (-c / b);
            }
            return;
        }
        // tính delta
        float delta = (float) (Math.pow(b,2) - 4*a*c);
        float x1;
        float x2;
        // tính nghiệm
        if (delta > 0) {
            x1 = (float) ((-b + Math.sqrt(delta)) / (2*a));
            x2 = (float) ((-b - Math.sqrt(delta)) / (2*a));
            message="Phương trình có 2 nghiệm là: "
                    + "x1 = " + x1 + " và x2 = " + x2;
        } else if (delta == 0) {
            x1 = (-b / (2 * a));
            message="Phương Trình Có Nghiệm Kép: "
                    + "x1 = x2 = " + x1;
        } else {
            message="Phương Trình Vô Nghiệm!";
        }
        request.setAttribute("message",message);
        request.getRequestDispatcher("/index.jsp").forward(request,response);
    }
}
