<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" isELIgnored="false" %>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="/static/css/competitionUser.css">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.2/css/all.min.css">
        <title>Pertandingan Admin Page</title>

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

        <div class="page-wrapper" id="main-wrapper" data-layout="vertical" data-navbarbg="skin6"
                    data-sidebartype="full" data-sidebar-position="fixed" data-header-position="fixed">
                    <main>
                        <div class="main-content">
                            <%@ include file="/WEB-INF/views/common/adminSideBar.jsp" %>
                            <div class="right-container">
                                <div class="container-fluid">
                                    <div class="card">
                                        <div class="card-body">
                                            <div class="title">
                                                <h3 style="margin-left:0px;"><b>Pertandingan Kalender Rendah Karbon Iskandar Puteri</b></h3>
                                            </div>
                                            <div class="subhead>">
                                                <h4><p>Select top winners for Pertandingan Kalendar Rendah Karbon Iskandar Puteri</p></h4>
                                            </div>
                                           
                                            <form id="selection-form" action="/winner/updateWinners" method="POST">
                                                <div class="calendar-filter" style="display: flex; align-items: center; margin-top: 1rem;">
                                                    <i class="fas fa-calendar fa-2x" style="margin-right: 0.5rem;"></i>
                                                    <select id="month-filter" name="selectedMonth" onchange="filterTable()">
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
                                                <br><br>
                                            
                                                <div class="winner-details-container">
                                                    <table class="winner-details-table">
                                                    <thead>
                                                        <tr>
                                                            <th>Residents</th>
                                                            <th>Month</th>
                                                            <th>Water consumption(L)</th>
                                                            <th>Electricity consumption(kWh)</th>
                                                            <th>Amount recycling(KG)</th>
                                                            <th>Carbon Reduction Rate(kgCo2)</th>
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
                                                                    <a href="#" target="_blank">Water</a>
                                                                    <a href="#" target="_blank">Electricity</a>
                                                                    <a href="/recycling/displayFile?username=${winner.userName}&month=${winner.month}&image_name=${winner.recycle_image}" target="_blank">
                                                                        Recycling
                                                                    </a>
                                                                </td>
                                                                <td>
                                                                    <input type="checkbox" name="selectedUserAndMonth" value="${winner.userName}_${winner.month}" onclick="limitCheckbox()">
                                                                    <label>Select</label>
                                                                    <!-- Hidden field to store the selected user and month -->
                                                                    <input type="hidden" name="selectedUser" value="${winner.userName}">
                                                                    <input type="hidden" name="selectedMonth" value="${winner.month}">
                                                                </td>
                                                            </tr>
                                                        </c:forEach>
                                                    </tbody>
                                                </table>
                                            </div>
                                            <div style="text-align: center;">
                                                <button type="submit" onclick="validateForm()">Submit</button>
                                            </div>
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
                        var checkboxes = document.querySelectorAll('input[name="selectedUserAndMonth"]');
                        var checkedCount = 0;

                        checkboxes.forEach(function (checkbox) {
                            if (checkbox.checked) {
                                checkedCount++;
                            }
                        });

                        if (checkedCount > 3) {
                            alert("You can select a maximum of 3 winners.");
                            // Uncheck the last checked checkbox
                            checkboxes.forEach(function (checkbox) {
                                if (checkbox.checked && checkedCount > 3) {
                                    checkbox.checked = false;
                                    checkedCount--;
                                }
                            });
                        }
                    }
                    
                    // Function to validate the form before submission
                    function validateForm() {
                        var checkboxes = document.querySelectorAll('input[name="selectedUserAndMonth"]');
                        var checkedCount = 0;

                        checkboxes.forEach(function (checkbox) {
                            if (checkbox.checked) {
                                checkedCount++;
                            }
                        });

                        if (checkedCount === 0) {
                            alert("Please select at least one winner.");
                            event.preventDefault();
                        }

                        // Continue with form submission
                        document.getElementById('winnerForm').submit();
                    }

                    // Function to filter the table based on the selected month
                    function filterTable() {
                        var selectedMonth = document.getElementById('month-filter').value;
                        var rows = document.querySelectorAll('.data-row');

                        rows.forEach(function (row) {
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

                    // Format the values with two decimal places
                    var decimalElements = document.querySelectorAll('.waterusage, .electricityusage, .recyclingamount, .carbon_reduction_rate');
                    decimalElements.forEach(function (element) {
                        var originalValue = parseFloat(element.textContent);
                        if (!isNaN(originalValue)) {
                            element.textContent = originalValue.toFixed(2);
                        }
                    });

                </script>

    </body>
</html>