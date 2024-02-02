<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" isELIgnored="false" %>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Water Page</title>
    <link rel="stylesheet" type="text/css" href="/static/css/water.css">
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
                    <h1>Water bill</h1>
                    <p>Please enter the water bill data values</p>
                </div>

                <c:choose>
                    <c:when test="${mode eq 'add'}">
                        <c:set var="action" value="/water/addWaterData" />
                        <div class="form">
                            <form action="${action}" method="post">
            
                            <label for="usage">Usage (m³):</label>
                            <input type="text" id="waterusage" name="waterusage" required>
                            
                            <label for="days">Days:</label>
                            <input type="text" id="days" name="days" required>
                            
                            <label for="proportion">Proportion Factor (day):</label>
                            <input type="text" id="proportion_factor" name="proportion_factor" required>
                            
                            <label for="amount">Amount (RM):</label>
                            <input type="text" id="amount" name="amount"  required>
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
                        <c:set var="action" value="/water/editWaterData" />
                        <div class="form">
                            <form action="${action}" method="post">
                              
                                <label for="usage">Usage (m³):</label>
                                <input type="text" id="waterusage" name="waterusage" value="${param.waterusage}" required>

                                <label for="days">Days:</label>
                                <input type="text" id="days" name="days" value="${param.days}" required>

                                <label for="proportion">Proportion Factor (day):</label>
                                <input type="text" id="proportion_factor" name="proportion_factor" value="${param.proportion_factor}" required>

                                <label for="amount">Amount (RM):</label>
                                <input type="text" id="amount" name="amount" value="${param.amount}" required>

                                <input type="hidden" id="month" name="month" value="${water.getMonth()}" required>
                        
                                <div class="button">
                                    <button type="submit" class="next-button">Next</button>
                                </div>
                            </form>
                        </div>
                    </c:otherwise>
                </c:choose>



                <!-- to list all water data -->
                <a href="/water/listAllWaterData">List all water data</a>
                <a href="/water/displayFile?username=${sessionScope.user.getUsername()}&month=${sessionScope.water.getMonth()}&image_name=${sessionScope.water.getImageName()}" target="_blank">Download File</a>

                <table>
                    <thead>
                        <tr>
                            <th>UserName</th>
                            <th>Water Usage</th>
                            <th>Days</th>
                            <th>Proportion Factor</th>
                            <th>Amount</th>
                            <th>Month</th>
                            <th>Image Name</th>
                            <th>Download bill</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="water" items="${allwater}">
                            <tr>
                                <td class="Username">${water.getUserName()}</td>
                                <td class="waterusage">${water.getElectricityusage()}</td>
                                <td class="days">${water.getDays()}</td>
                                <td class="proportion_factor">${water.getProportion_factor()}</td>
                                <td class="amount">${water.getAmount()}</td>
                                <td class="month">${water.getMonth()}</td>
                                <td class="getImageName">${water.getImageName()}</td>
                                <td>
                                    <a href="/water/displayFile?month=${water.getMonth()}&image_name=${water.getImageName()}" target="_blank">Download File</a>
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
