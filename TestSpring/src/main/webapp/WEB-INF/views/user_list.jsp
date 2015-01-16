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

<head>

</head>
<body width="100%" alt=""><br>

<table style="border: 1px solid; width: 100%;text-align:center">
    <thead style="background:rgba(13,12,12,0.21)">
    <tr>
        <th> Система обмена сообщениями</th>

    </tr>


</table>
<h4><a href="start_page">Главная</a> &nbsp;&nbsp;&nbsp; &nbsp; Список участников в системе </h4>

<P ALIGN=RIGHT><a href="<c:url value="/logout"  />"> Logout</a><br>
<th>


</th>




<P ALIGN=CENTER>

<form action="creating_user">&nbsp;&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
    <th>


    </th>
    <th><P ALIGN=RIGHT>
    <sec:authorize  access="hasRole('ADMIN')"></th>
    <input value="Создать нового участника" type="submit"><br> </sec:authorize>


</p>
</form>
<h2> Учётная запись пользователя   ${model.userName}</h2>
<table style="border: 1px solid; width: 100%; cellpadding :8px;text-align:center">
    <thead style="background:rgba(255,24,213,0.50)">
    <tr>
    <th>ID</th>
    <th>Имя</th>
    <th>Фамилия</th>
    <th>Никнейм</th>
    <sec:authorize access="hasRole('ADMIN')">
        <th>Пароль</th>
    </sec:authorize>
    <sec:authorize access="hasRole('ADMIN')">
        <th>Action</th>
    </sec:authorize>
    </thead>
    <c:forEach var="user" items="${model.userList}">

    <tr>
        <td>${user.id } </td>
        <td>${user.firstName}</td>
        <td>${user.lastName}</td>
        <td>${user.userName}</td>
        <sec:authorize access="hasRole('ADMIN')">
            <td>${user.password}</td>
        </sec:authorize>
        <sec:authorize access="hasRole('ADMIN')">
            <td><a href="edit_page?id=${user.id}"> Модифицировать &nbsp;&nbsp; </a>
                <a href="delete/${user.id}"> Удалить&nbsp;&nbsp; </a>
                <a href="incoming_message/${user.id}"> Полученые&nbsp;&nbsp; </a>
                <a href="sending_message/${user.id}"> Отправленые &nbsp;&nbsp;</a>
            </td>
        </sec:authorize>
    </tr>
    </c:forEach>


</body>
</html>
