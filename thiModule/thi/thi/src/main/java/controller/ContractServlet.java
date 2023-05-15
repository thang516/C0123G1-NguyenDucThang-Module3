package controller;

import model.Contract;
import model.TypeContract;
import service.ContractService;
import service.IContractService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ContractServlet", value = "/contract")
public class ContractServlet extends HttpServlet {
    private IContractService contractService = new ContractService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            String action =request.getParameter("action");
            if(action==null){
                action="";
            }
            switch (action){
                case "create":
                    request.getRequestDispatcher("/create.jsp").forward(request,response);
                    break;
                default:
                    List<Contract> contractList = contractService.getAll();
                    request.setAttribute("contractList",contractList);
                    request.getRequestDispatcher("/list.jsp").forward(request,response);
                    break;

            }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action =request.getParameter("action");
        String name;
        if(action==null){
            action="";
        }
        switch (action){
            case "create":
                int idContract = Integer.parseInt(request.getParameter("idContract"));
                 name = request.getParameter("name");
                String dateStart = request.getParameter("dateStart");
                String dateEnd = request.getParameter("dateEnd");
                List<TypeContract> contractList = contractService.getAllTypeContract();
                TypeContract typeContract = new TypeContract();
                for (int i = 0; i <contractList.size() ; i++) {
                    if(idContract==contractList.get(i).getIdContract()){
                        typeContract=contractList.get(i);
                        break;
                    }
                }
                Contract contract = new Contract(name,typeContract,dateStart,dateEnd);
                contractService.save(contract);
                response.sendRedirect("/contract");
                break;
            case "delete":
                int id = Integer.parseInt(request.getParameter("id"));
                contractService.delete(id);

                List<Contract> contractList1 = contractService.getAll();
                request.setAttribute("contractList",contractList1);
                request.getRequestDispatcher("/list.jsp").forward(request,response);
                break;
            case "find":
                String nameFind = request.getParameter("nameFind");
                contractService.find(nameFind);
                request.setAttribute("nameFind",nameFind);
                request.getRequestDispatcher("/list.jsp").forward(request,response);

                break;

        }


    }
}
