<?xml version="1.0" encoding="utf-8" ?>

<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ page contentType="text/html; charset=utf-8" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<html>
<style>
    .error {
        color: #ff0000;
    }


</style>


<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>
</head>

<body width="100%" alt=""><br>

<table style="border: 1px solid; width: 100%;text-align:center">
    <thead style="background:rgba(13,12,12,0.21)">
    <tr>
        <th> Система обмена сообщениями</th>

    </tr>
</table>
<h3><a href="start_page"> Главная </a> &nbsp;&nbsp;&nbsp;&nbsp; <a href=user_list> Список участников </a> &nbsp;&nbsp;&nbsp;&nbsp;
    Создание учасника </h3>

<p>

<P ALIGN=RIGHT><a href="<c:url value="/logout"  />"> Logout</a>

<p>


    <form:form modelAttribute="addEditPage" action="saveUser" method="POST" commandName="user">
   <form:hidden path="id"/>
<h3>Заполните необходимые значения и нажмите кнопку&nbsp;&nbsp;&nbsp;&nbsp;
    <input value="Сохранить" type="submit"></h3>
<br>
<table>

    <tr>
        <td><form:label path="firstName">Имя</form:label></td>
        <td><form:input path="firstName"/></td>
        <td><form:errors path="firstName" cssClass="error"/></td>
    </tr>
    <tr>
        <td><form:label path="lastName">Фамилия</form:label></td>
        <td><form:input path="lastName"/></td>
        <td><form:errors path="lastName" cssClass="error"/></td>
    </tr>
    <tr>
        <td><form:label path="userName">Никнайм</form:label></td>
        <td><form:input path="userName"/></td>
        <td><form:errors path="userName" cssClass="error"/></td>
    </tr>
    <tr>
        <td><form:label path="password">Пароль</form:label></td>
        <td><form:password path="password"/></td>
        <td><form:errors path="password" cssClass="error"/></td>
</table>


</form:form>

</body>
</html>