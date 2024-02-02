<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Electricity Consumption Page</title>
    <link rel="stylesheet" type="text/css" href="/static/css/electricity.css">
</head>
<body>
    <%@ include file="/WEB-INF/views/common/include-first.jsp" %> 
    <%@ include file="/WEB-INF/views/common/header.jsp" %>   
    <main>

        <div class="page-wrapper" id="main-wrapper" data-layout="vertical" data-navbarbg="skin6"
        data-sidebartype="full" data-sidebar-position="fixed" data-header-position="fixed">
        <main>
            <div class="main-content">
                <%@ include file="/WEB-INF/views/common/userSideBar.jsp" %>
                <div class="right-container">
                    <div class="container-fluid">
                        <div class="card">
                            <div class="card-body">
                                <div class="title">
                                    <h1>Electricity bill</h1>
                                    <p>Please enter the electricity bill data values</p>
                                </div>
                                <c:set var="action" value="/electrical/addElectricalData2" />
                                <div class="form">
                                    <form action="${action}" method="post">
                                        <label for="usage">Usage (m³):</label>
                                        <input type="text" id="electricityusage" name="electricityusage" value="${sessionScope.electrical.getElectricityusage()}" required>
                                        
                                        <label for="days">Days:</label>
                                        <input type="text" id="days" name="days" value="${sessionScope.electrical.getDays()}" required>
                                        
                                        <label for="proportion">Proportion Factor (day):</label>
                                        <input type="text" id="proportion_factor" name="proportion_factor" value="${sessionScope.electrical.getProportion_factor}" required>
                                        
                                        <label for="amount">Amount (RM):</label>
                                        <input type="text" id="amount" name="amount" value="${sessionScope.electrical.getAmount}" required>
                                        
                                        <label for="charge">Current Charge (RM):</label>
                                        <input type="text" id="current_charge" name="current_charge" value="${sessionScope.electrical.getCurrent_charge}" required>
                
                                        <label for="month">Month:</label>
                                        <select id="month" name="month" value="${sessionScope.electrical.getMonth()}"required>
                                            <option value="January">January</option>
                                            <option value="February">February</option>
                                            <option value="March">March</option>
                                            <option value="April">April</option>
                                            <option value="May">May</option>
                                            <option value="June">June</option>
                                            <option value="July">July</option>
                                            <option value="August">August</option>
                                            <option value="September">September</option>
                                            <option value="October">October</option>
                                            <option value="November">November</option>
                                            <option value="December">December</option>
                                        </select>
                                
                                        <div class="button">
                                            <button type="submit" class="next-button">Next</button>
                                        </div>
                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </main>
    </div>


    </main>
</body>
</html>
