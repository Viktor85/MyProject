<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Add or Edit Employee </title>

</head>


<body width="100%" alt=""><br>

<table style="border: 1px solid; width: 100%;text-align:center">
    <thead style="background:rgba(13,12,12,0.21)">
    <tr>
        <th><h2>Add Or Edit Employee</h2>

            <h2><%
                Object name = request.getAttribute("name");

                out.print("Department  ");
               %>
            <font color="red">
                        <%
                out.print(name);
                %>
            </h2>
            </font>



        </th>
    </tr>
</table>

<form action="/employeeController" method="Post">
    <table colspan="2" align="center">
        <tr>


            <td><input type="hidden" name="employeeId"
                       value="${employeeId}"/>
                <input type="hidden" name="employeeId"
                       value="<c:out value="${employee.employeeId}"/>"/>
            </td>

        </tr>
        <tr>

            <td>First Name:</td>

            <td><input type="text" name="firstName"
                       value="<c:out value="${employee.firstName}"/>"/>
            <td style="color: #FF0000;">${messages.firstName}</td>
            </td>

        </tr>


        <tr>
            <td>Last Name</td>
            <td><input type="text" name="lastName"
                       value="<c:out value="${employee.lastName}"/>"/>
            <td style="color: #FF0000;">${messages.lastName}</td>
            </td>

        </tr>

        <tr>
            <td>Sale Items:</td>
            <td>

                <input type="text" name="saleItems"
                       value="<c:out value="${employee.saleItems}"/>"/>
            <td style="color: #FF0000;">${messages.saleItems}</td>
            </td>

        </tr>

        <tr>
            <td>Email:</td>
            <td>
                <input type="text" name="email"
                       value="<c:out value="${employee.email}"/>">
            <td style="color: #FF0000;">${messages.email}</td>


            </td>
        </tr>


        <tr>
            <td>Registration Date(YYYY-MM-DD):</td>

            <td>
                <input type="text" name="registrDate"
                       value="<c:out value="${employee.registrDate}"/>"/>
            <td style="color: #FF0000;">${messages.registrDate} </td>
            </td>
            </td>

        </tr>


        <tr>

            <td><input type="hidden" name="departmentId" value='${departmentId}'/>
                <input type="hidden" name="departmentId"
                       value="<c:out value="${employee.departmentId}"/>"/>


            </td>
        </tr>


        <tr>
            <td colspan="2" align="center">
                <input type="hidden" name="departmentId" value='${departmentId}'>
                <input type="hidden" name="action" value="addEmpl">
                <input type="submit" value="Add Employee"/>
        </tr>


    </table>

</form>
</body>

</html>