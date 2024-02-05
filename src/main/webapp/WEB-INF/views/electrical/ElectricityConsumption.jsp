<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" isELIgnored="false" %>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

    <%@ include file="/WEB-INF/views/common/auth.jsp" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Electrical Page</title>
    <link rel="stylesheet" type="text/css" href="/static/electrical/css/electricity.css">
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
                            <form action="${action}" method="post" onsubmit="return validateForm()">
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
                            <form action="${action}" method="post" onsubmit="return validateForm()">
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

<script>
    function validateForm() {
        var electricityUsage = document.getElementById("electricityusage").value;
        var days = document.getElementById("days").value;
        var proportionFactor = document.getElementById("proportion_factor").value;
        var amount = document.getElementById("amount").value;
        var currentCharge = document.getElementById("current_charge").value;

        if (!isValidNonNegativeNumber(electricityUsage)) {
            alert("Please enter a valid number for Usage (m³).");
            return false; // Prevent form submission
        }

        if (!isValidNonNegativeNumber(days)) {
            alert("Please enter a valid number for Days.");
            return false; // Prevent form submission
        }

        if (!isValidNonNegativeNumber(proportionFactor)) {
            alert("Please enter a valid number for Proportion Factor.");
            return false; // Prevent form submission
        }

        if (!isValidNonNegativeNumber(amount)) {
            alert("Please enter a valid number for Amount.");
            return false; // Prevent form submission
        }

        if (!isValidNonNegativeNumber(currentCharge)) {
            alert("Please enter a valid number for Current Charge.");
            return false; // Prevent form submission
        }

        return true; // Allow form submission
    }

    function isValidNonNegativeNumber(value) {
        return !isNaN(value) && parseFloat(value) >= 0;
    }
</script>
