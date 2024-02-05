<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" isELIgnored="false" %>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

    <%@ include file="/WEB-INF/views/common/auth.jsp" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Recycling Page</title>
    <link rel="stylesheet" type="text/css" href="/static/recycling/css/recycling.css">
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
                                            <p>Please enter the recycling bill data values</p>
                                            <c:choose>
                    <c:when test="${mode eq 'add'}">
                        <c:set var="action" value="/recycling/addRecyclingData" />
                        <div class="form">
                            <form action="${action}" method="post" onsubmit="return validateForm()">
                                <label for="weight">Weight of recycling material (kg):</label>
                                <input type="text" id="weight" name="weight" required >
                        
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
                        <c:set var="action" value="/recycling/editRecyclingData" />
                        <div class="form">
                            <form action="${action}" method="post" onsubmit="return validateForm()">
                                <label for="weight">Weight of recycling material (kg):</label>
                                <input type="text" id="weight" name="weight" value="${param.weight}" required>
                                <input type="hidden" id="month" name="month" value="${recycling.getMonth()}" required>
                        
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
        var weightInput = document.getElementById("weight").value;

        if (isNaN(weightInput) || parseFloat(weightInput) < 0) {
            alert("Please enter a valid number for the Recycling Material Weight.");
            return false; // Prevent form submission
        }

        return true; // Allow form submission
    }
</script>
