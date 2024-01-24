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

                <c:set var="action" value="/recycling/addRecyclingData" />

                <div class="form">
                    <form action="${action}" method="post">
                        <label for="weight">Weight of recycling material (kg):</label>
                        <input type="text" id="weight" name="weight" value="${sessionScope.recycling.getWeight()}" required>
                
                        <label for="days">Days:</label>
                        <input type="text" id="days" name="days" value="${sessionScope.recycling.getDays()}" required>
                
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


                <!-- to list all recycling data -->
                <a href="/recycling/listAllRecyclingData">List all recycle data</a>
                <a href="/recycling/displayFile?username=${sessionScope.user.getUsername()}&month=${sessionScope.recycling.getMonth()}&image_name=${sessionScope.recycling.getImageName()}" target="_blank">Download File</a>

                <table>
                    <thead>
                        <tr>
                            <th>UserName</th>
                            <th>Weight</th>
                            <th>Days</th>
                            <th>Month</th>
                            <th>Recycling Carbon Factor</th>
                            <th>Image Name</th>
                            <th>Download bill</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="recycling" items="${allrecycling}">
                            <tr>
                                <td class="Username">${recycling.getUserName()}</td>
                                <td class="weight">${recycling.getWeight()}</td>
                                <td class="days">${recycling.getDays()}</td>
                                <td class="days">${recycling.getMonth()}</td>
                                <td class="recycling_carbon_factor">${recycling.getRecycling_carbon_factor()}</td>
                                <td class="getImageName">${recycling.getImageName()}</td>
                                <td>
                                    <a href="/recycling/displayFile?username=${recycling.getUserName()}&month=${recycling.getMonth()}&image_name=${recycling.getImageName()}" target="_blank">Download File</a>
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
