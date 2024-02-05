<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Recycling Page</title>
    <link rel="stylesheet" type="text/css" href="/static/css/BillPage.css">  <!--no affect dk why-->

    <style>
header {
    display: flex;
    justify-content: space-between;
    align-items: center;
    height: 100px;
    background-color: #d0edc7;
    border-bottom: 1px solid black;
    padding: 0 20px;
}

main {
    display: flex;
    height: 100vh;
    margin: 0 auto; 
}

aside {
    width: 200px;
    height: 100%;
    background-color: white;
    border-right: 2px solid rgb(25, 25, 49);
    display: flex;
    flex-direction: column;
    align-items: center;
    padding: 20px;
}

.logo-container {
    overflow: hidden;
    width: 40px;
    height: 40px;
    justify-content: flex-end;
    align-items: flex-end;
    margin-top: 37px;
    margin-bottom: 100px;
    margin-left: 120px;
    text-align: right;

}

.logo {
    width: 100%;
    height: auto;
}

.main-content {
    display: flex;
    flex: 1;
    background-color: #fff;
    justify-content: space-between;
}

.left-container {
    height: 100%;
    width: 13%;
}

.right-container {
    height: 100%;
    width: 87%;
    display: flex;
    flex-direction: column;
    padding: 20px;
}

.form {
    flex: 1;
    border: 1px solid black;
    padding: 20px;
    padding-top: 40px;
    margin-bottom: 10px;
    max-height:45%;
    margin:20px;
    border-radius: 25px;
    background-color: #d0edc7 ;
}

form {
    display: grid;
    grid-gap: 10px;
}

label {
    font-size: 0.9em;
}

.bill-container {
    display: flex;
    flex-wrap: wrap;
    justify-content: space-around;
    margin-top: 20px;
    padding-right: 60px; /* adjust the button container padding */
}

.bill-card {
    text-align: center;
    text-decoration: none;
    color: inherit;
    margin: 10px;
    padding: 10px;
    border-radius: 5px;
    transition: transform 0.3s ease-in-out;
    position: relative; /* Make the container position relative */
    display: flex; /* Enable flex container for centering */
    flex-direction: column; /* Stack child elements vertically */
    align-items: center; /* Center children horizontally */
    justify-content: center; /* Center children vertically */
}

.bill-card p {
    position: absolute;
    top: 50%; /* Position at the vertical center */
    left: 50%; /* Center horizontally */
    transform: translate(-50%, -50%); /* Center both horizontally and vertically */
    margin: 0; /* Remove default margin */
    background-color: rgba(255, 255, 255, 0.7); /* Add a semi-transparent background */
    padding: 5px;
    border-radius: 5px;
}

.bill-card:hover {
    transform: scale(1.05);
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
                                            <h1>Bill</h1>
                                            <p>Please select the bill type that you want to upload</p>
                                            <div class="bill-container">
                                                <a href="/water/listWaterDataByUsername_Month/${sessionScope.user.getUsername()}"class="bill-card" id="water-activity"> <!-- the href link need change ltr-->
                                                    <!-- Icon for Water Bill -->
                                                    <img src="/static/water/asset/Water bill background.png" alt="Water Bill">
                                                    <p>Water bill</p>
                                                </a>
                                                <a href="/electrical/listElectricalDataByUsername_Month/${sessionScope.user.getUsername()}"class="bill-card" id="electrical-activity">
                                                    <!-- Icon for Electricity Bill -->
                                                    <img src="/static/electrical/asset/Electricity bill background.png" alt="Electricity Bill">
                                                    <p>Electricity bill</p>
                                                </a>
                                                <a href="/recycling/listRecyclingDataByUsername_Month/${sessionScope.user.getUsername()}" class="bill-card" id="recycling-activity">
                                                    <!-- Icon for Recycling Activity -->
                                                    <img src="/static/recycling/asset/Recycling bill background.png" alt="Recycling Activity">
                                                    <p>Recycling activity</p>
                                                </a>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </main>
                </div>
</body>
</html>
