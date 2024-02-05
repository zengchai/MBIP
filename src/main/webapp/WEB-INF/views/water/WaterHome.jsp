<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" isELIgnored="false" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

    <%@ include file="/WEB-INF/views/common/auth.jsp" %>
        <!DOCTYPE html>
        <html lang="en">

        <head>
            <meta charset="UTF-8">
            <meta name="viewport" content="width=device-width, initial-scale=1.0">
            <title>Water Page</title>
            <link rel="stylesheet" href="/static/common/css/materialize.min.css">
            <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
            <link rel="stylesheet" type="text/css" href="/static/water/css/water.css">
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
                                            <h1>Water bill</h1>
                                            <div class="container right-align">
                                                <a class="btn waves-effect waves-light"
                                                    href="/water/viewAddWaterDataForm">Add Water Data</a>
                                            </div>
                                            <br><br>
                                            <table>
                                                <thead>
                                                    <tr>
                                                        <th>User Name</th>
                                                        <th>Water Usage</th>
                                                        <th>Month</th>
                                                        <th>Water Carbon Factor</th>
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
                                                            <td class="water_carbon_factor">
                                                                ${water.getWater_carbon_factor()}</td>
                                                            <td class="getImageName">${water.getImageName()}</td>
                                                            <td>
                                                                <a href="/water/displayFile?username=${water.getUserName()}&month=${water.getMonth()}&image_name=${water.getImageName()}"
                                                                    target="_blank">Download File</a>
                                                            </td>
                                                            <td>
                                                                <a class="btn-floating waves-effect waves-light btn-small"
                                                                    href="/water/viewEditWaterDataForm?userName=${water.getUserName()}&waterusage=${water.getWaterusage()} &days=${water.getDays()}&proportion_factor=${water.getProportion_factor()}&amount=${water.getAmount()} &month=${water.getMonth()}">
                                                                    <i class="material-icons">create</i>
                                                                </a>
                                                                <a class="btn-floating waves-effect waves-light btn-small"
                                                                    href="/water/deleteWaterData?month=${water.getMonth()}">
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