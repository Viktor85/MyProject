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
<h4><a href="/start_page">Главная</a> &nbsp;&nbsp;&nbsp; &nbsp; <a href=/user_list> Список участников в системе </a>
    &nbsp;&nbsp;&nbsp;&nbsp; Полученные сообщения  </h4>

<P ALIGN=RIGHT><a href="<c:url value="/logout"  />"> Logout</a><br>




<h2>Полученные сообщения участника   ${modelIncomingMessage.userNameById} </h2>
</form>
<table style="border: 1px solid; width: 100%; cellpadding :8px;text-align:center">
    <thead style="background:rgba(255,24,213,0.50)">
    <tr>
    <th>ID</th>
    <th>Отправитель</th>
    <th>Тема</th>
    <th>Сообщение</th>
    <th>Action</th>
        <th>IN</th>
        <th>Out</th>
    </thead>
    <c:forEach var="message" items="${modelIncomingMessage.messageList}">

    <tr>
        <td>${message.id } </td>
        <td>${message.sender.userName}</td>
        <td>${message.subject}</td>
        <td>${message.body}</td>

        <td><a href="/deleteMessage/${message.id}"> Удалить </a></td>
        <td>${message.receiver.id}</td>
        <td>${message.sender.id}</td>
    </tr>
    </c:forEach>


</body>
</html>
