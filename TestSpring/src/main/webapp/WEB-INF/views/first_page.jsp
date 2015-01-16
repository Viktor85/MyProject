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
  <title>

  </title>
</head>
<body width="100%" alt=""><br>

<table style="border: 1px solid; width: 100%;text-align:center">
  <thead style="background:rgba(13,12,12,0.21)">
  <tr>
    <th> Система обмена сообщениями</th>

  </tr>
</table>
<sec:authorize access="isFullyAuthenticated()">
<P ALIGN=RIGHT><a href="<c:url value="/logout"  />"> Logout</a>
  </sec:authorize>

<h3><a href=/user_list>Список участников в системе </a></h3>




</body>
</html>