<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Add or Edit Department</title>
</head>


<body width="100%" alt=""><br>

<table style="border: 1px solid; width: 100%;text-align:center">
    <thead style="background:rgba(13,12,12,0.21)">
    <tr>
        <th><h2>Add or Edit Department </h2></th>

    </tr>
</table>


<form action="/departmentController" method="Post">
    <table colspan="2" align="center">
        <tr>


            <td><input type="hidden" name="departmentId"
                       value="${departmentId}"/>
                <input type="hidden" name="departmentId"
                       value="<c:out value="${department.departmentId}"/>"/>

            </td>


            <td>Department Name:</td>
            <td><input type="text" name="departmentName"
                       value="<c:out value="${department.departmentName}"/>"/>
            <td style="color: #ff2203;">${message.error}</td>

            </td>

        </tr>


        <tr>
            <td colspan="4" align="center">

                <input type="submit" value="Add Department"/>
            </td>
        </tr>


    </table>

</form>


</body>

</html>