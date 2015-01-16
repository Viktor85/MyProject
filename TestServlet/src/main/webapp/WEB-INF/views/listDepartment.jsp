<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>List Department</title>
</head>

<body width="100%" alt=""><br>

<table style="border: 1px solid; width: 100%;text-align:center">
    <thead style="background:rgba(13,12,12,0.21)">
    <tr>
        <th><h2>List Department</h2></th>

    </tr>
</table>


<table border=1 colspan="2" align="center">
    <thead>
    <tr>

        <th>Name Department</th>
        <th colspan=6 align="center">Action</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${department}" var="department">
        <tr>

            <td><c:out value="${department.departmentName}"/></td>

            <td>
                <form action="/departmentController" method="get">
                    <input type="hidden" name="departmentId" value="${department.departmentId}">
                    <input type="hidden" name="action" value="deleteDepart">
                    <input type="submit" value="delete"></form>
            </td>
            <td>
                <form action="/departmentController" method="get">
                    <input type="hidden" name="departmentId" value="${department.departmentId}">
                    <input type="hidden" name="action" value="editDepart">
                    <input type="submit" value="edit"></form>
            </td>
            <td>
                <form action="/departmentController" method="get">
                    <input type="hidden" name="departmentId" value="${department.departmentId}">
                    <input type="hidden" name="action" value="listEmployee">
                    <input type="submit" value="listEmployee"></form>
            </td>

        </tr>
    </c:forEach>
    </tbody>
</table>
<center>
    <form action="/departmentController" method="get">
        <input type="hidden">
        <input type="hidden" name="action" value="addDepart">
        <input type="submit" value="Add Department"></form>

</center>


</body>
</html>