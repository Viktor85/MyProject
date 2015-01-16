package com.test.web.controller;

import com.test.web.dao.imp.DepartmentDaoImp;
import com.test.web.dao.imp.EmployeeDaoImp;

import com.test.web.model.Employee;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


import java.util.HashMap;
import java.util.Map;


public class EmployeeController extends HttpServlet {


    private static final String ADD_OR_EDIT_EMPLOYEE = "/addOrEditEmployee.jsp";
    private static final String LIST_DEPARTMENT = "/listDepartment.jsp";
    private static final String LIST_EMPLOYEE = "/listEmployee.jsp";
    private DepartmentDaoImp dao;
    private EmployeeDaoImp daoEmpl;


    public EmployeeController() {

        super();
        dao = new DepartmentDaoImp();
        daoEmpl = new EmployeeDaoImp();

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String forward = "";
        String action = request.getParameter("action");


        if (action.equalsIgnoreCase("addEmpl")) {
            forward = ADD_OR_EDIT_EMPLOYEE;

            int departmentId = Integer.parseInt(request.getParameter("departmentId"));

            request.setAttribute("departmentId", departmentId);
            request.setAttribute("name", dao.getDepartmentName(departmentId));


        } else if (action.equalsIgnoreCase("editEmpl")) {
            forward = ADD_OR_EDIT_EMPLOYEE;

            int employeeId = Integer.parseInt(request.getParameter("employeeId"));
            int departmentId = Integer.parseInt(request.getParameter("departmentId"));

            Employee employee = daoEmpl.getEmployeeById(employeeId);

            request.setAttribute("employeeId", employeeId);
            request.setAttribute("departmentId", departmentId);
            request.setAttribute("name", dao.getDepartmentName(departmentId));
            request.setAttribute("employee", employee);


        } else if (action.equalsIgnoreCase("deleteEmpl")) {

            int employeeId = Integer.parseInt(request.getParameter("employeeId"));
            int departmentId = Integer.parseInt(request.getParameter("departmentId"));
            daoEmpl.deleteEmployee(employeeId);

            forward = LIST_EMPLOYEE;

            request.setAttribute("id", departmentId);
            request.setAttribute("name", dao.getDepartmentName(departmentId));
            request.setAttribute("employee", daoEmpl.getAllEmployeeDepartmentById(departmentId));

        } else if (action.equalsIgnoreCase("listDepartment")) {
            forward = LIST_DEPARTMENT;

        }


        RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, response);

    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Employee employee = new Employee();
        Map<String, String> messages = new HashMap<String, String>();

        String patternEmail = "[a-zA-Z0-9]+[a-zA-Z0-9._]*[a-zA-Z0-9]*+@[a-zA-Z0-9]*[.]([a-z][a-z]|[a-z][a-z][a-z])";
        String datePattern = "((19|20)\\d\\d)-(0?[1-9]|1[012])-(0?[1-9]|[12][0-9]|3[01])";

        String employeeId = request.getParameter("employeeId");


        String firstName = request.getParameter("firstName");
        if (firstName == null || firstName.isEmpty()) {
            messages.put("firstName", "Empty Field");
        } else if (firstName.length() > 10) {
            messages.put("firstName", "Length Max 10 characters");
            employee.setFirstName(firstName);
        } else
            employee.setFirstName(firstName);


        String lastName = request.getParameter("lastName");
        if (lastName == null || lastName.isEmpty()) {
            messages.put("lastName", "Empty Field");
        } else if (lastName.length() > 10) {
            messages.put("lastName", "Length Max 10 characters");
            employee.setLastName(lastName);
        } else
            employee.setLastName(lastName);


        String saleItems = request.getParameter("saleItems");
        if (saleItems == null || saleItems.isEmpty()) {
            messages.put("saleItems", "Empty Field");
        } else if (saleItems.length() > 10) {
            messages.put("saleItems", "Length Max 10 characters");
            employee.setSaleItems(saleItems);
        } else if (!saleItems.matches("\\d+")) {
            messages.put("saleItems", "Numbers Only");
            employee.setSaleItems(saleItems);
        } else
            employee.setSaleItems(saleItems);


        String email = request.getParameter("email");
        if (email == null || email.isEmpty()) {
            messages.put("email", "Empty Field");
        } else if (email.length() > 30) {
            messages.put("email", "Length Max 30 characters");
            employee.setEmail(email);
        } else if (!email.matches(patternEmail)) {
            messages.put("email", "Email Not Correct");
            employee.setEmail(email);
        } else if (daoEmpl.checkDublicateEmail(email) == true) {
            messages.put("email", "Email already exists");
            employee.setEmail(email);
        } else
            employee.setEmail(email);


        String registrDate = request.getParameter("registrDate");
        if (registrDate == null || registrDate.isEmpty()) {
            messages.put("registrDate", "Empty Field");
        } else if (!registrDate.matches(datePattern)) {
            messages.put("registrDate", "RegistrDate Not Correct");
            employee.setRegistrDate(registrDate);
        } else
            employee.setRegistrDate(registrDate);


        String departmentIdStr = request.getParameter("departmentId");
        int departmentId = Integer.parseInt(departmentIdStr);


        if (employeeId == null || employeeId.isEmpty()) {
            request.setAttribute("employeeId", "");
            request.setAttribute("messages", messages);
            request.setAttribute("employee", employee);
            request.setAttribute("name", dao.getDepartmentName(departmentId));
            request.setAttribute("departmentId", departmentId);
            employee.setDepartmentId(departmentId);

        } else {
            request.setAttribute("employeeId", employeeId);
            request.setAttribute("messages", messages);
            request.setAttribute("employee", employee);
            request.setAttribute("name", dao.getDepartmentName(departmentId));
            request.setAttribute("departmentId", departmentId);
            employee.setEmployeeId(Integer.parseInt(employeeId));
            employee.setDepartmentId(departmentId);
        }


        if (messages.isEmpty()) {

            if (employeeId == null || employeeId.isEmpty()) {

                daoEmpl.addEmployee(employee);

            } else {

                daoEmpl.updateEmployee(employee);

            }
            request.setAttribute("name", dao.getDepartmentName(departmentId));
            request.setAttribute("departmentId", departmentId);
            request.setAttribute("employee", daoEmpl.getAllEmployeeDepartmentById(departmentId));
            request.getRequestDispatcher(LIST_EMPLOYEE).forward(request, response);
            return;
        }


        request.setAttribute("name", dao.getDepartmentName(departmentId));
        request.setAttribute("departmentId", departmentId);
        request.getRequestDispatcher(ADD_OR_EDIT_EMPLOYEE).forward(request, response);

    }

}


