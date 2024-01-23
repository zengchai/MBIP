<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Recycling Page</title>
    <link rel="stylesheet" type="text/css" href="/static/css/recycling.css">
</head>
<body>
        <jsp:include page="header.jsp" />    
    <main>
        <div class="main-content">
            <jsp:include page="userSideBar.jsp" />
            <div class="left-container">
                <div class="logo-container">
                    <img src="/static/asset/back.png" alt="Back Logo" class="logo">
                </div>    
            </div>
            <div class="right-container">
                <div class="title">
                    <h1>Recycling bill</h1>
                    <p>Please enter the recycling bill data values</p>
                </div>

                <c:set var="action" value="/recycling/addRecyclingData2" />

                <div class="form">
                    <form action="${action}" method="post">
                        <label for="weight">Weight of recycling material (kg):</label>
                        <input type="text" id="weight" name="weight" value="${recycling.getWeight()}" required>
                
                        <label for="days">Days:</label>
                        <input type="text" id="days" name="days" value="${recycling.getDays()}" required>
                
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

            </div>
        </div>
    </main>
</body>
</html>
