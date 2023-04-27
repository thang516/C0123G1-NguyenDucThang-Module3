import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ServletCalculator", value = "/ServletCalculator")
public class ServletCalculator extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String exception ="";
        double result = 0;
        try {
            double a = Double.parseDouble(request.getParameter("firstOperand"));
            double b = Double.parseDouble(request.getParameter("secondOperand"));
            String operator = request.getParameter("operator");


            switch (operator) {
                case "addition":
                    result = Calculator.addition(a, b);
                    break;
                case "subtraction":
                    result = Calculator.subtraction(a, b);
                    break;
                case "multiplication":
                    result = Calculator.multiplication(a, b);
                    break;
                case "division":
                    if(b!=0){
                        result = Calculator.division(a, b);
                        break;
                    }else {
                        throw new ArithmeticException("EROR");
                    }


            }

        } catch (ArithmeticException e) {
            exception = e.getMessage();

        }
        request.setAttribute("exception",exception);
        request.setAttribute("result", result);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/index.jsp");
        requestDispatcher.forward(request, response);

    }
}
