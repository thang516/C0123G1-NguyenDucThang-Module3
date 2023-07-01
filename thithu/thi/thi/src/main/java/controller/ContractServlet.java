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
    private IContractService contractService = new ContractService() ;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        List<Contract> contractList ;
        if(action==null){
            action="";
        }
        switch (action){

            case  "create" :
                request.getRequestDispatcher("/create.jsp").forward(request,response);
                break;



//                int idEdit = Integer.parseInt(request.getParameter("idEdit"));
//                contractList = contractService.getAll();
//                Contract contract = new Contract();
//                for (int i = 0; i < contractList.size(); i++) {
//                    if(idEdit==contractList.get(i).getId()){
//                        contract=contractList.get(i);
//                        break;
//                    }
//                }
//                request.setAttribute("contract",contract);
//                request.getRequestDispatcher("/edit.jsp").forward(request,response);
//                break;
//

            default:
                contractList = contractService.getAll();
                request.setAttribute("contractList",contractList);
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
                String name = request.getParameter("name");
                String dateStart = request.getParameter("dateStart");
                String dateEnd = request.getParameter("dateEnd");
                int idContract = Integer.parseInt(request.getParameter("idContract"));
                TypeContract typeContract = new TypeContract();
                List<TypeContract> contractList = contractService.getAllTypeContract();
                for (int i = 0; i <contractList.size() ; i++) {
                    if(idContract==contractList.get(i).getIdContract()){
                        typeContract=contractList.get(i);
                        break;
                    }
                }
                Contract contract = new Contract(name,typeContract,dateStart,dateEnd);
               boolean check =   contractService.save(contract);
                String mess = "thêm mới thành công" ;

                 if(!check){
                     mess="thêm mới không thành cônng";
                 }
                 request.setAttribute("mess",mess);
             List<Contract>   contractList1 = contractService.getAll();
                request.setAttribute("contractList",contractList1);
                request.getRequestDispatcher("/list.jsp").forward(request,response);
                    break;
            case "delete":
                int id = Integer.parseInt(request.getParameter("id"));
                contractService.delete(id);
//                request.getRequestDispatcher("/list.jsp").forward(request,response);
                response.sendRedirect("/contract");

                break;



//                create(request, response);
////                response.sendRedirect("/contract");
////                List<Contract> contractList1 = contractService.getAll();
////                request.setAttribute("contractList",contractList1);
////                request.getRequestDispatcher("/list.jsp").forward(request,response);
//                break;
//                case "delete" :
//                    int id = Integer.parseInt(request.getParameter("id"));
//                    contractService.delete(id);
////                    request.getRequestDispatcher("/list.jsp").forward(request,response);
//                    response.sendRedirect("/contract");
//                    break;
//            case "find":
//                String nameFind = request.getParameter("nameFind");
//                String nameContract = request.getParameter("nameContract");
//                List<Contract>  contractList2 =  contractService.find(nameFind,nameContract);
//                request.setAttribute("nameFind",nameFind);
//                request.setAttribute("nameContract",nameContract);
//               request.setAttribute("contractList",contractList2);
//                request.getRequestDispatcher("/list.jsp").forward(request,response);
//                break;
//            case "edit":
//                id = Integer.parseInt(request.getParameter("idEdit"));
//                String name = request.getParameter("name");
//                int idContract = Integer.parseInt(request.getParameter("idContract"));
//                TypeContract typeContract = new TypeContract();
//                String dateStart = request.getParameter("dateStart");
//                String dateEnd = request.getParameter("dateEnd");
//
//                Contract contract = new Contract(id,name,typeContract,dateStart,dateEnd);
//                  contractService.edit(contract);
//          List<Contract>      contractList1 = contractService.getAll();
//                request.setAttribute("contractList",contractList1);
//                request.getRequestDispatcher("/list.jsp").forward(request,response);
//                break;
//
//
//        }
    }

//    public void create(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        String name = request.getParameter("name");
//        int idContract = Integer.parseInt(request.getParameter("idContract"));
//        TypeContract typeContract = new TypeContract();
//        String dateStart = request.getParameter("dateStart");
//        String dateEnd = request.getParameter("dateEnd");
//        List<TypeContract> contractList = contractService.getAllTypeContract();
//        for (int i = 0; i <contractList.size() ; i++) {
//            if(contractList.get(i).getIdContract()== idContract){
//                typeContract = contractList.get(i);
//                break;
//            }
//        }
//        Contract contract = new Contract(name,typeContract,dateStart,dateEnd);
//        boolean check =    contractService.save(contract);
//        String mess = "thêm mới thành công ";
//        if(!check){
//            mess="Thêm mới ko thành công ";
//        }
//        request.setAttribute("mess",mess);
//        List<Contract> contractList1 = contractService.getAll();
//        request.setAttribute("contractList",contractList1);
//        request.getRequestDispatcher("/list.jsp").forward(request, response);
    }
}
