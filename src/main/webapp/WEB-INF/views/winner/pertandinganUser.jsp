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
        <title>Competition User</title>

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
                            <%@ include file="/WEB-INF/views/common/userSideBar.jsp" %>
                            <div class="right-container">
                                <div class="container-fluid">
                                    <div class="card">
                                        <div class="card-body">
                                            <div class="title">
                                                <h3 style="margin-left:0px;"><b>Pertandingan Kalendar Rendah Karbon Iskandar Puteri</b></h3>
                                            </div>
                            
                                            <div class="overview-container">
                                                <h4>Overview</h4>
                                                <ul>
                                                    <li>Pertandingan ini bertujuan bagi memberikan galakan dan juga motivasi kepada penduduk Majlis Bandaraya Iskandar Puteri, MBIP untuk membudayakan gaya hidup rendah karbon. Melalui pertandingan pengurangan penggunaan air (m3), elektrik (kWh) dan juga jumlah kitar semula (kg), ianya dapat membantu dunia, khususnya MBIP dalam usaha mengurangkan penghasilan karbon.</li>
                                                    <li>Tempoh daftar maklumat di bit.ly/mbiprendahkarbon bermula :Sekarang sehingga 31 Ogos 2022</li>
                                                </ul>
                                            </div>

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

                                            <div class="winner-container">
                                                <div class="second-winner">
                                                    <img src="/static/asset/competitionUserIMG/2nd.png" alt="2nd winner" style="margin-bottom: 10px;">
                                                    <img src="/static/asset/headerIMG/userIcon.png" alt="1st winner">
                                                    <p id="second-winner-username" class="month" name="month"></p>
                                                </div>
                                                <div class="first-winner">
                                                    <img src="/static/asset/competitionUserIMG/1st.png" alt="1st winner" style="margin-bottom: 10px;">
                                                    <img src="/static/asset/headerIMG/userIcon.png" alt="1st winner">
                                                    <p id="first-winner-username" class="month" name="month"></p>
                                                </div>
                                                <div class="third-winner">
                                                    <img src="/static/asset/competitionUserIMG/3rd.png" alt="3rd winner" style="margin-bottom: 10px;">
                                                    <img src="/static/asset/headerIMG/userIcon.png" alt="1st winner">
                                                    <p id="third-winner-username" class="month" name="month"></p>
                                                </div>
                                            </div>
                            
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
                                                        </tr>
                                                    </thead>
                                                    <!-- Add dynamic table rows and data here -->
                                                    <tbody>
                                                        <c:forEach var="finalWinners" items="${finalWinners}">
                                                            <tr class="data-row">
                                                                <td class="username" name="username">${finalWinners.userName}</td>
                                                                <td class="month" name="month">${finalWinners.getWinner()}</td>
                                                                <td class="waterusage">${finalWinners.waterusage} L</td>
                                                                <td class="electricityusage">${finalWinners.electricityusage} kWh</td>
                                                                <td class="recyclingamount">${finalWinners.weight} KG</td>
                                                                <td class="carbon_reduction_rate">${finalWinners.carbon_reduction_rate} kgCo2</td>
                                                            </tr>
                                                        </c:forEach>
                                                    </tbody>
                                                </table>
                                            </div>
                            
                                            
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </main>
                </div>
                <script>

                    // Function to filter the table based on the selected month
                    function filterTable() {
                        var selectedMonth = document.getElementById('month-filter').value;
                        var rows = document.querySelectorAll('.data-row');
                        var usernames = [];

                        rows.forEach(function(row) {
                            var rowMonth = row.querySelector('.month').textContent;

                            // If the row's month matches the selected month, display the row and add the username to the array
                            if (rowMonth === selectedMonth) {
                                row.style.display = '';
                                var username = row.querySelector('.username').textContent;
                                usernames.push(username);
                            } else {
                                row.style.display = 'none';
                            }
                        });

                        // Update the usernames under each image
                        document.getElementById("first-winner-username").innerText = usernames[0] || ''; // Display empty string if undefined
                        document.getElementById("second-winner-username").innerText = usernames[1] || '';
                        document.getElementById("third-winner-username").innerText = usernames[2] || '';
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
                        decimalElements.forEach(function(element) {
                            var originalValue = parseFloat(element.textContent);
                            if (!isNaN(originalValue)) {
                                element.textContent = originalValue.toFixed(2);
                            }
                        });
                    
                </script>
    </body>
</html>