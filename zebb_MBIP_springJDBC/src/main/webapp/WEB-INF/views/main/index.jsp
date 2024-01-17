<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="ISO-8859-1">
    <title>Home Page</title>

    <%@ include file="/WEB-INF/views/common/include-first.jsp" %>
</head>

<body>

    <%@ include file="/WEB-INF/views/common/header.jsp" %>

    <div class="container">
        <h2 class="center-align">Demo about Setting Up Spring Web App MVC with Maven</h2>


        <a class="btn waves-effect waves-light" href="/product/list">Proudcts Page</a>
    </div>

    <%@ include file="/WEB-INF/views/common/include-last.jsp" %>
</body>

</html>
