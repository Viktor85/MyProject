<?xml version="1.0" encoding="utf-8" ?>

<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ page contentType="text/html; charset=utf-8" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">


<html>
<style>
    .error {
        color: #ff0000;
    }

    .errorblock {
        color: #000;
        background-color: #ffEEEE;
        border: 3px solid #ff0000;
        padding: 8px;
        margin: 16px;
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


<h3><a href="start_page"> Главная </a> &nbsp;&nbsp;&nbsp;&nbsp; Отправить сообщение </h3>






<P ALIGN=RIGHT><a href="<c:url value="/logout"  />"> Logout</a>

<p>


        <form:form method="post" action="addSendMessage.html" commandName="mess">

<table>


    <tr>
        <h3><input value="Отправить Собщение" type="submit" var="true"></h3>



        <td><form:label path="nickname">Получатель</form:label></td>
        <td><form:input path="nickname"/></td>
        <td><form:errors path="nickname" cssClass="error"/></td>
    </tr>

    <tr>
        <td><form:label path="subject">Тема </form:label></td>
        <td><form:input path="subject"/></td>
        <td><form:errors path="subject" cssClass="error"/></td>
    <tr>

    <tr>


    <tr>
    <tr>
        <td> Сообщение :</td>
        <td><form:textarea path="body" rows="5" cols="30"/></td>
        <td><form:errors path="body" cssClass="error"/></td>
    </tr>
</table>

</form:form>


</body>
</html>
