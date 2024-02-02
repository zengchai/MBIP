<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" isELIgnored="false" %>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Water Page</title>
    <link rel="stylesheet" href="/static/common/css/materialize.min.css">
    <link rel="stylesheet" type="text/css" href="/static/css/water.css">
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
                    <h1>Water bill</h1>
                </div>
                <br><br>
                <div class="container right-align">
                    <a class="btn waves-effect waves-light" href="/water/viewAddWaterDataForm">Add Water Data</a>
                </div>
                 <br><br>
                <table>
                    <thead>
                        <tr>
                            <th>User Name</th>
                            <th>Water Usage</th>
                            <th>Month</th>
                            <th>Amount</th>
                            <th>File Name</th>
                            <th>Download bill</th>
                            <th>Action</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="water" items="${userwater}">
                            <tr>
                                <td class="Username">${water.getUserName()}</td>
                                <td class="waterusage">${water.getWaterusage()}</td>
                                <td class="month">${water.getMonth()}</td>
                                <td class="amount">${water.getAmount()}</td>
                                <td class="getImageName">${water.getImageName()}</td>
                                <td>
                                    <a href="/water/displayFile?username=${water.getUserName()}&month=${water.getMonth()}&image_name=${water.getImageName()}" target="_blank">Download File</a>
                                </td>
                                <td>
                                    <a class="btn-floating waves-effect waves-light btn-small"
                                        href="/water/viewEditWaterDataForm?userName=${water.getUserName()}&month=${water.getMonth()}">
                                        <i class="material-icons">Edit</i>
                                    </a>
                                    <a class="btn-floating waves-effect waves-light btn-small"
                                        href="/water/deleteWaterData?month=${water.getMonth()}">
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
