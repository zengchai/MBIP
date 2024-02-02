<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" isELIgnored="false" %>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Electrical Page</title>
    <link rel="stylesheet" href="/static/common/css/materialize.min.css">
    <link rel="stylesheet" type="text/css" href="/static/css/electricity.css">
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
                    <h1>Electrical bill</h1>
                </div>
                <br><br>
                <div class="container right-align">
                    <a class="btn waves-effect waves-light" href="/electrical/viewAddElectricalDataForm">Add Electrical Data</a>
                </div>
                 <br><br>
                <table>
                    <thead>
                        <tr>
                            <th>User Name</th>
                            <th>Electricity Usage</th>
                            <th>Month</th>
                            <th>Amount</th>
                            <th>File Name</th>
                            <th>Download bill</th>
                            <th>Action</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="electrical" items="${userelectrical}">
                            <tr>
                                <td class="Username">${electrical.getUserName()}</td>
                                <td class="electricityusage">${electrical.getElectricityusage()}</td>
                                <td class="month">${electrical.getMonth()}</td>
                                <td class="amount">${electrical.getAmount()}</td>
                                <td class="getImageName">${electrical.getImageName()}</td>
                                <td>
                                    <a href="/electrical/displayFile?username=${electrical.getUserName()}&month=${electrical.getMonth()}&image_name=${electrical.getImageName()}" target="_blank">Download File</a>
                                </td>
                                <td>
                                    <a class="btn-floating waves-effect waves-light btn-small"
                                        href="/electrical/viewEditElectricalDataForm?userName=${electrical.getUserName()}&month=${electrical.getMonth()}">
                                        <i class="material-icons">Edit</i>
                                    </a>
                                    <a class="btn-floating waves-effect waves-light btn-small"
                                        href="/electrical/deleteElectricalData?month=${electrical.getMonth()}">
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
