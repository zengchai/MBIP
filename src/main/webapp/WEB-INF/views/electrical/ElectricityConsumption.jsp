<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" isELIgnored="false" %>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Electrical Page</title>
    <link rel="stylesheet" type="text/css" href="/static/css/electricity.css">
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
                                            <p>Please enter the electrical bill data values</p>
                                            <c:choose>
                    <c:when test="${mode eq 'add'}">
                        <c:set var="action" value="/electrical/addElectricalData" />
                        <div class="form">
                            <form action="${action}" method="post">
                                <label for="usage">Usage (m³):</label>
                                <input type="text" id="electricityusage" name="electricityusage" required>
                                
                                <label for="days">Days:</label>
                                <input type="text" id="days" name="days" required>
                                
                                <label for="proportion">Proportion Factor (day):</label>
                                <input type="text" id="proportion_factor" name="proportion_factor"  required>
                                
                                <label for="amount">Amount (RM):</label>
                                <input type="text" id="amount" name="amount" required>
                                
                                <label for="charge">Current Charge (RM):</label>
                                <input type="text" id="current_charge" name="current_charge"  required>
                        
                                <label for="month">Month:</label>
                                <select id="month" name="month" required>
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
                    </c:when>
                    <c:otherwise>
                        <c:set var="action" value="/electrical/editElectricalData" />
                        <div class="form">
                            <form action="${action}" method="post">
                                <label for="usage">Usage (m³):</label>
                                <input type="text" id="electricityusage" name="electricityusage" value="${param.electricityusage}" required>

                                <label for="days">Days:</label>
                                <input type="text" id="days" name="days" value="${param.days}" required>

                                <label for="proportion">Proportion Factor (day):</label>
                                <input type="text" id="proportion_factor" name="proportion_factor" value="${param.proportion_factor}" required>

                                <label for="amount">Amount (RM):</label>
                                <input type="text" id="amount" name="amount" value="${param.amount}" required>

                                <label for="charge">Current Charge (RM):</label>
                                <input type="text" id="current_charge" name="current_charge" value="${param.current_charge}" required>

                                <input type="hidden" id="month" name="month" value="${electrical.getMonth()}" required>
                        
                                <div class="button">
                                    <button type="submit" class="next-button">Next</button>
                                </div>
                            </form>
                        </div>
                    </c:otherwise>
                </c:choose>


</body>
</html>
