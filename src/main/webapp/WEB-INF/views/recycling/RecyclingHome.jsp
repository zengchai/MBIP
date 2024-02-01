<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" isELIgnored="false" %>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Recycling Page</title>
    <link rel="stylesheet" href="/static/common/css/materialize.min.css">
    <link rel="stylesheet" type="text/css" href="/static/css/recycling.css">
</head>
<body>
    <%@ include file="/WEB-INF/views/header.jsp" %> 
    <main>
        <div class="main-content">
            <%@ include file="/WEB-INF/views/userSideBar.jsp" %> 
            <div class="left-container">
                <div class="logo-container">
                    <img src="/static/asset/back.png" alt="Back Logo" class="logo">
                </div>    
            </div>
            <div class="right-container">
                <div class="title">
                    <h1>Recycling bill</h1>
                </div>
                <br><br>
                <div class="container right-align">
                    <a class="btn waves-effect waves-light" href="/recycling/viewAddRecyclingDataForm">Add Recycle Data</a>
                </div>
                 <br><br>
                <table>
                    <thead>
                        <tr>
                            <th>User Name</th>
                            <th>Weight</th>
                            <th>Month</th>
                            <th>Recycling Carbon Factor</th>
                            <th>File Name</th>
                            <th>Download bill</th>
                            <th>Action</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="recycling" items="${userrecycling}">
                            <tr>
                                <td class="Username">${recycling.getUserName()}</td>
                                <td class="weight">${recycling.getWeight()}</td>
                                <td class="month">${recycling.getMonth()}</td>
                                <td class="recycling_carbon_factor">${recycling.getRecycling_carbon_factor()}</td>
                                <td class="getImageName">${recycling.getImageName()}</td>
                                <td>
                                    <a href="/recycling/displayFile?username=${recycling.getUserName()}&month=${recycling.getMonth()}&image_name=${recycling.getImageName()}" target="_blank">Download File</a>
                                </td>
                                <td>
                                    <a class="btn-floating waves-effect waves-light btn-small"
                                        href="/recycling/viewEditRecyclingDataForm?userName=${recycling.getUserName()}&weight=${recycling.getWeight()}&month=${recycling.getMonth()}">
                                        <i class="material-icons">Edit</i>
                                    </a>
                                    <a class="btn-floating waves-effect waves-light btn-small"
                                        href="/recycling/deleteRecyclingData?month=${recycling.getMonth()}">
                                        <i class="material-icons">Delete</i>
                                    </a>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </main>
</body>
</html>
