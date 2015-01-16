<?xml version="1.0" encoding="utf-8" ?>

<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ page contentType="text/html; charset=utf-8" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">


<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title></title>
    <style>
        .error {
            color: red;
        }
    </style>
</head>
<body>
<h3>Пожайлуста введите логин и пароль для входа в систему</h3>

<p>
    <c:if test="${error == true}">
        <b class="error">Неправильный Никнейм или Пароль.</b>
    </c:if>
</p>

<form method="post" action="<c:url value='j_spring_security_check'/>">
    <table>
        <tbody>
        <tr>
            <td>Никнейм :</td>
            <td><input type="text" name="j_username" id="j_username" size="30" maxlength="40"/></td>
        </tr>
        <tr>
            <td>Пароль :</td>
            <td><input type="password" name="j_password" id="j_password" size="30" maxlength="32"/></td>
        </tr>
        <tr>
            <td></td>
            <td><input type="submit" value="Вход"/></td>
        </tr>
        </tbody>
    </table>
</form>

</body>
</html>