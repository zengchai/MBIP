<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" isELIgnored="false" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

    <%@ include file="/WEB-INF/views/common/auth.jsp" %>
        <!DOCTYPE html>
        <html lang="en">

        <head>
            <meta charset="UTF-8">
            <meta name="viewport" content="width=device-width, initial-scale=1.0">
            <title>Electrical Page</title>
            <link rel="stylesheet" href="/static/common/css/materialize.min.css">
            <link rel="stylesheet" type="text/css" href="/static/electrical/css/electricity.css">
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
                                            <h1>Electrical bill</h1>
                                            <div class="container right-align">
                                                <a class="btn waves-effect waves-light"
                                                    href="/electrical/viewAddElectricalDataForm">Add Electrical Data</a>
                                            </div>
                                            <br><br>
                                            <table>
                                                <thead>
                                                    <tr>
                                                        <th>User Name</th>
                                                        <th>Electrical usage</th>
                                                        <th>Month</th>
                                                        <th>Electricity Carbon Factor</th>
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
                                                            <td class="electrical_carbon_factor">
                                                                ${electrical.getElectrical_carbon_factor()}</td>
                                                            <td class="getImageName">${electrical.getImageName()}</td>
                                                            <td>
                                                                <a href="/electrical/displayFile?username=${electrical.getUserName()}&month=${electrical.getMonth()}&image_name=${electrical.getImageName()}"
                                                                    target="_blank">Download File</a>
                                                            </td>
                                                            <td>
                                                                <a class="btn-floating waves-effect waves-light btn-small"
                                                                    href="/electrical/viewEditElectricalDataForm?userName=${electrical.getUserName()}&electricityusage=${electrical.getElectricityusage()} &days=${electrical.getDays()}&proportion_factor=${electrical.getProportion_factor()}&amount=${electrical.getAmount()}&current_charge=${electrical.getCurrent_charge()}&month=${electrical.getMonth()}">
                                                                    <i class="material-icons">create</i>
                                                                </a>
                                                                <a class="btn-floating waves-effect waves-light btn-small"
                                                                    href="/electrical/deleteElectricalData?month=${electrical.getMonth()}">
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