<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>List Employee</title>
</head>

<body width="100%" alt=""><br>

<table style="border: 1px solid; width: 100%;text-align:center">
    <thead style="background:rgba(13,12,12,0.21)">
    <tr>
        <th><h2>List Employee </h2>

            <h2><%
                Object name = request.getAttribute("name");
                out.print("Department  ");
            %>
                <font color="red">
                        <%
                out.print(name);
                %>
            </h2></font>

        </th>

    </tr>
</table>
<center>

    <form action="/employeeController" method="get">
        <input type="hidden">
        <input type="hidden" name="action" value="list Department">
        <input type="submit" value="List Department"></form>


</center>
<table border=1 colspan="2" align="center">
    <thead>
    <tr>

        <th>First Name</th>
        <th>Last Name</th>
        <th>Sale Items</th>
        <th>Email</th>
        <th>Date of Registration</th>
        <th>DepartmentId</th>
        <th colspan=6 align="center">Action</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${employee}" var="employee">
        <tr>

            <td><c:out value="${employee.firstName}"/></td>
            <td><c:out value="${employee.lastName}"/></td>
            <td><c:out value="${employee.saleItems}"/></td>
            <td><c:out value="${employee.email}"/></td>
            <td><c:out value="${employee.registrDate}"/></td>
            <td><c:out value="${employee.departmentId}"/></td>


            <td>
                <form action="/employeeController" method="get">
                    <input type="hidden" name="departmentId" value="${employee.departmentId}">
                    <input type="hidden" name="employeeId" value="${employee.employeeId}">
                    <input type="hidden" name="action" value="deleteEmpl">
                    <input type="submit" value="delete"></form>
            </td>
            <td>
                <form action="/employeeController" method="get">
                    <input type="hidden" name="departmentId" value="${employee.departmentId}">
                    <input type="hidden" name="employeeId" value="${employee.employeeId}">
                    <input type="hidden" name="action" value="editEmpl">
                    <input type="submit" value="edit"></form>
            </td>


        </tr>

    </c:forEach>
    </tbody>
</table>

<center>
    <form action="/employeeController" method="get">
        <input type="hidden" name="departmentId" value='${departmentId}'>
        <input type="hidden" name="action" value="addEmpl">
        <input type="submit" value="Add Employee"></form>


</center>

</body>
</html>