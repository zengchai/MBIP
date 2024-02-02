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
                    <h1>Electrical bill</h1>
                    <p>Please enter the electrical bill data values</p>
                </div>

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



                <!-- to list all electrical data -->
                <a href="/electrical/listAllElectricalData">List all electrical data</a>
                <a href="/electrical/displayFile?username=${sessionScope.user.getUsername()}&month=${sessionScope.electrical.getMonth()}&image_name=${sessionScope.electrical.getImageName()}" target="_blank">Download File</a>

                <table>
                    <thead>
                        <tr>
                            <th>UserName</th>
                            <th>Electricity Usage</th>
                            <th>Days</th>
                            <th>Proportion Factor</th>
                            <th>Amount</th>
                            <th>Month</th>
                            <th>Image Name</th>
                            <th>Download bill</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="electrical" items="${allelectrical}">
                            <tr>
                                <td class="Username">${electrical.getUserName()}</td>
                                <td class="electricityusage">${electrical.getElectricityusage()}</td>
                                <td class="days">${electrical.getDays()}</td>
                                <td class="proportion_factor">${electrical.getProportion_factor()}</td>
                                <td class="amount">${electrical.getAmount()}</td>
                                <td class="current_charge">${electrical.getCurrent_charge()}</td>
                                <td class="month">${electrical.getMonth()}</td>
                                <td class="getImageName">${electrical.getImageName()}</td>
                                <td>
                                    <a href="/electrical/displayFile?month=${electrical.getMonth()}&image_name=${electrical.getImageName()}" target="_blank">Download File</a>
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
