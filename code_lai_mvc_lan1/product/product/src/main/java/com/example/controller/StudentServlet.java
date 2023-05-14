package com.example.controller;

import com.example.model.Clazz;
import com.example.model.Student;
import com.example.service.IStudentService;
import com.example.service.StudentService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "StudentServlet", value = "/student")
public class StudentServlet extends HttpServlet {
    private IStudentService studentService = new StudentService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        List<Student> studentList;
        if(action==null){
            action="";
        }
        switch (action){

            case "create":
                request.getRequestDispatcher("/create.jsp").forward(request,response);
                break;
            case "edit" :
                int id = Integer.parseInt(request.getParameter("idEdit"));
                 studentList = studentService.getAll();
                Student student = new Student();
                for (int i = 0; i <studentList.size() ; i++) {
                    if(studentList.get(i).getId()==id){
                        student=studentList.get(i);
                        break;
                    }
                }
                request.setAttribute("student",student);
                request.getRequestDispatcher("/update.jsp").forward(request,response);
                break;
            default:
                      studentList = studentService.getAll();
                if (studentList==null){
                    request.getRequestDispatcher("/error.jsp").forward(request,response);
                }else {
                    request.setAttribute("studentList",studentList);
                    request.getRequestDispatcher("/list.jsp").forward(request,response);
                    break;
        }

        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id;
        String action = request.getParameter("action");
        if(action==null){
            action="";
        }
        switch (action){
            case "create":
                create(request, response);
                break;
            case "delete" :
                 id = Integer.parseInt(request.getParameter("id"));
                studentService.delete(id);
                response.sendRedirect("/student");
                break;
            case "edit":
                id = Integer.parseInt(request.getParameter("idEdit"));
                    String name = request.getParameter("name");
                int classId= Integer.parseInt(request.getParameter("classId"));
                    Float point = Float.valueOf(request.getParameter("point"));
                String className= request.getParameter("className");
                Clazz clazz = new Clazz(classId,className);
                Student student = new Student(id,name,clazz,point);
                studentService.edit(student);
                response.sendRedirect("/student");
                break;

        }
    }

    public void create(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int classId;
        List<Clazz> clazzList = studentService.getAllClazz();
        String name = request.getParameter("name");
        classId = Integer.parseInt(request.getParameter("classId"));
        Float point = Float.valueOf(request.getParameter("point"));
        Clazz clazz =new Clazz();
        for (int i = 0; i <clazzList.size() ; i++) {
            if(classId==clazzList.get(i).getId()){
                clazz=clazzList.get(i);
                break;
            }
        }
        Student student = new Student(name, clazz,point);
        boolean check =   studentService.save(student);
        String mess = "Thêm mới  thành công";
        if(!check){
            mess = "thêm mới không thành công";

        }
        request.setAttribute("mess" , mess);
        request.getRequestDispatcher("/create.jsp").forward(request, response);
    }
}
