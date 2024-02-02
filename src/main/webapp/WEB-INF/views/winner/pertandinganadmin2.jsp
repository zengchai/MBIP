<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.ArrayList" %>

<%@ page import="java.io.IOException" %>

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Pertandingan Admin Page</title>
        <link rel="stylesheet" type="text/css" href="/static/css/pertandinganadmin2.css">
        <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
        
        <style>
            .main-content {
                display: flex;
                flex: 1;
                background-color: #fff;
                justify-content: space-between;
                overflow: hidden; /* Prevent content overflow */
            }

            .right-container {
                height: 100%;
                width: 87%;
                /*border: 1px solid black;*/
                display: flex;
                flex-direction: column;
                padding: 20px;
            }

        </style>
    </head>
    <body>

            <%@ include file="/WEB-INF/views/common/include-first.jsp" %> 
            <%@ include file="/WEB-INF/views/common/header.jsp" %> 
        
            <div class="page-wrapper" id="main-wrapper" data-layout="vertical" data-navbarbg="skin6" data-sidebartype="full"
                data-sidebar-position="fixed" data-header-position="fixed">
                <main>
                    <div class="main-content">
                        <%@ include file="/WEB-INF/views/common/adminSideBar.jsp" %>
                            <div class="right-container">
                                <div class="container-fluid">
                                    <div class="card">
                                        <div class="card-body">
                                            <div class="title">
            
                                                <h2><U>Pertandingan Kalender Rendah Karbon Iskandar Puteri</U></h2>
                                            </div>
                                            <div class="subhead>">
                                                <h4>
                                                    <p>Select top winners for Pertandingan Kalendar Rendah Karbon Iskandar Puteri
                                                    </p>
                                                </h4>
                                            </div>
                                            <div class="container">
            
                                                <form id="selection-form" action="/winner/updateWinner" method="POST">
                                                    <!-- Change the action attribute to the appropriate endpoint -->
                                                    <div class="calendar-filter"
                                                        style="display: flex; align-items: center; margin-top: 1rem;">
                                                        <img style="margin-right: 0.5rem;" src="/static/asset/calendar.png"
                                                            alt="calendar-img">
                                                        <select id="month-filter" onchange="filterTable()">
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
                                                    </div>
            
                                                    <table id="winnersTable">
                                                        <thead>
                                                            <tr>
                                                                <th>Residents</th>
                                                                <th>Month</th>
                                                                <th>Water consumption</th>
                                                                <th>Electricity consumption</th>
                                                                <th>Amount recycling</th>
                                                                <th>Carbon Reduction Rate</th>
                                                                <th>Download bill</th>
                                                                <th>Action</th>
                                                            </tr>
                                                        </thead>
                                                        <tbody>
                                                            <c:forEach var="winner" items="${winners}">
                                                                <tr class="data-row">
                                                                    <td class="username" name="username">${winner.userName}</td>
                                                                    <td class="month" name="month">${winner.month}</td>
                                                                    <td class="waterusage">${winner.waterusage}</td>
                                                                    <td class="electricityusage">${winner.electricityusage}</td>
                                                                    <td class="recyclingamount">${winner.weight}</td>
                                                                    <td class="carbon_reduction_rate">${winner.carbon_reduction_rate}</td>
                                                                    <td>
                                                                        <a href="#"
                                                                            target="_blank">Water
                                                                        </a>
                                                                        <a href="#"
                                                                            target="_blank">Electricity
                                                                        </a>
                                                                        <a href="/recycling/displayFile?username=${winner.userName}&month=${winner.month}&image_name=${winner.recycle_image}" target="_blank">
                                                                            Recycling
                                                                        </a>
                                                                    </td>
                                                                    <td>
                                                                        <div class="checkbox">
                                                                            <input type="checkbox" name="username" name="month" value="${winner.userName}" onclick="limitCheckbox()">
                                                                            <input type="hidden" name="username" value="${winner.userName}" >
                                                                            <input type="hidden" name="month" value="${winner.month}" >
                                                                            <label>Select</label>
                                                                        </div>
                                                                    </td>
                                                                </tr>
                                                            </c:forEach>
                                                        </tbody>
                                                    </table>
            
                                                    <button type="submit">Submit</button>
                                                </form>
            
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                </main>
            </div>
    
            
            <script>
                // Function to limit the checkbox selections to a maximum of 3
                function limitCheckbox() {
                    var checkboxes = document.querySelectorAll('input[name="selectedWinner"]');
                    var checkedCount = 0;

                    checkboxes.forEach(function(checkbox) {
                        if (checkbox.checked) {
                            checkedCount++;
                        }
                    });

                    if (checkedCount > 3) {
                        alert("You can select a maximum of 3 winners.");
                        // Uncheck the last checked checkbox
                        checkboxes.forEach(function(checkbox) {
                            if (checkbox.checked && checkedCount > 3) {
                                checkbox.checked = false;
                                checkedCount--;
                            }
                        });
                    }
                }

                // Function to filter the table based on the selected month
                function filterTable() {
                    var selectedMonth = document.getElementById('month-filter').value;
                    var rows = document.querySelectorAll('.data-row');
            
                    rows.forEach(function(row) {
                        var rowMonth = row.querySelector('.month').textContent;
            
                        // If the row's month matches the selected month, display the row; otherwise, hide it
                        row.style.display = (rowMonth === selectedMonth) ? '' : 'none';
                    });
                }
            
                // Set the initial value of the dropdown to the current month
                function setInitialMonth() {
                    var currentDate = new Date();
                    var currentMonth = currentDate.toLocaleString('default', { month: 'long' }); // Get the full name of the current month
                    var monthDropdown = document.getElementById('month-filter');
                    monthDropdown.value = currentMonth;
            
                    // Call the filterTable function initially to show rows for the current month
                    filterTable();
                }
            
                // Call the setInitialMonth function to set the initial value
                setInitialMonth();
            </script>
        </body>
</html>