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
            <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
        </head>

        <body>
            <%@ include file="/WEB-INF/views/common/include-first.jsp" %> 
            <%@ include file="/WEB-INF/views/common/header.jsp" %> 

                <div class="page-wrapper" id="main-wrapper" data-layout="vertical" data-navbarbg="skin6"
                    data-sidebartype="full" data-sidebar-position="fixed" data-header-position="fixed">
                    <main>
                        <div class="main-content">
                            <%@ include file="/WEB-INF/views/common/userSideBar.jsp" %>
                            <div class="right-container">
                                <div class="container-fluid">
                                    <div class="card">
                                        <div class="card-body">
                                            <h1>Recycling bill</h1>
                                            <div class="container right-align">
                                                <a class="btn waves-effect waves-light"
                                                    href="/recycling/viewAddRecyclingDataForm">Add Recycle Data</a>
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
                                                            <td class="recycling_carbon_factor">
                                                                ${recycling.getRecycling_carbon_factor()}</td>
                                                            <td class="getImageName">${recycling.getImageName()}</td>
                                                            <td>
                                                                <a href="/recycling/displayFile?username=${recycling.getUserName()}&month=${recycling.getMonth()}&image_name=${recycling.getImageName()}"
                                                                    target="_blank">Download File</a>
                                                            </td>
                                                            <td>
                                                                <a class="btn-floating waves-effect waves-light btn-small"
                                                                    href="/recycling/viewEditRecyclingDataForm?userName=${recycling.getUserName()}&weight=${recycling.getWeight()}&month=${recycling.getMonth()}">
                                                                    <i class="material-icons">create</i>
                                                                </a>
                                                                <a class="btn-floating waves-effect waves-light btn-small"
                                                                    href="/recycling/deleteRecyclingData?month=${recycling.getMonth()}">
                                                                    <i class="material-icons">delete</i>
                                                                </a>
                                                            </td>
                                                        </tr>
                                                    </c:forEach>
                                                </tbody>
                                            </table>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </main>
                </div>
        </body>

        </html>