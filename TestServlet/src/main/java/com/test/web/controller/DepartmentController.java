package com.test.web.controller;


import com.test.web.dao.imp.DepartmentDaoImp;
import com.test.web.dao.imp.EmployeeDaoImp;

import com.test.web.model.Department;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


public class DepartmentController extends HttpServlet {

    private static final String ADD_OR_EDIT_DEPARTMENT = "/addOrEditDepartment.jsp";
    private static final String LIST_DEPARTMENT = "/listDepartment.jsp";
    private static final String LIST_EMPLOYEE = "/listEmployee.jsp";

    private DepartmentDaoImp dao;
    private EmployeeDaoImp daoEmpl;


    public DepartmentController() {
        super();
        dao = new DepartmentDaoImp();
        daoEmpl = new EmployeeDaoImp();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String forward = "";
        String action = request.getParameter("action");

        if (action.equalsIgnoreCase("deleteDepart")) {
            int departmentId = Integer.parseInt(request.getParameter("departmentId"));
            dao.deleteDepartment(departmentId);

            forward = LIST_DEPARTMENT;

            request.setAttribute("department", dao.getAllDepartmens());

        } else if (action.equalsIgnoreCase("editDepart")) {
            forward = ADD_OR_EDIT_DEPARTMENT;

            int departmentId = Integer.parseInt(request.getParameter("departmentId"));
            Department department = dao.getDepartmentById(departmentId);

            request.setAttribute("departmentId", departmentId);
            request.setAttribute("department", department);


        } else if (action.equalsIgnoreCase("addDepart")) {
            forward = ADD_OR_EDIT_DEPARTMENT;

        } else if (action.equalsIgnoreCase("listDepartment")) {
            forward = LIST_DEPARTMENT;
            request.setAttribute("department", dao.getAllDepartmens());


        } else if (action.equalsIgnoreCase("listEmployee")) {
            forward = LIST_EMPLOYEE;
            int departmentId = Integer.parseInt(request.getParameter("departmentId"));
            request.setAttribute("employee", daoEmpl.getAllEmployeeDepartmentById(departmentId));
            request.setAttribute("name", dao.getDepartmentName(departmentId));
            request.setAttribute("departmentId", departmentId);
        }

        RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Department department = new Department();
        Map<String, String> message = new HashMap<String, String>();


        String departmentId = request.getParameter("departmentId");

        String departmentName = request.getParameter("departmentName");
        if (departmentName == null || departmentName.isEmpty()) {
            message.put("error", "Empty Field");
        } else if (dao.checkDublicateName(departmentName) == true) {
            message.put("error", "Name Already Exists");
            department.setDepartmentName(departmentName);
        } else if (departmentName.length() > 10) {
            message.put("error", "Length Max 10 characters");
            department.setDepartmentName(departmentName);
        } else {
            department.setDepartmentName(departmentName);
        }


        if (departmentId == null || departmentId.isEmpty()) {

            request.setAttribute("departmentId", "");
            request.setAttribute("message", message);
            request.setAttribute("department", department);


        } else {

            request.setAttribute("departmentId", departmentId);
            request.setAttribute("message", message);
            request.setAttribute("department", department);
            department.setDepartmentId(Integer.parseInt(departmentId));
        }


        if (message.isEmpty()) {

            if (departmentId == null || departmentId.isEmpty()) {

                dao.addDepartment(department);

            } else {

                dao.updateDepartment(department);
            }

            RequestDispatcher view = request.getRequestDispatcher(LIST_DEPARTMENT);
            request.setAttribute("department", dao.getAllDepartmens());
            view.forward(request, response);
            return;
        }

        request.getRequestDispatcher(ADD_OR_EDIT_DEPARTMENT).forward(request, response);


    }
}






