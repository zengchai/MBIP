<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page import="java.util.ArrayList" %>

<%@ page import="java.io.IOException" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Report Calculation</title>
        <link rel="stylesheet" type="text/css" href="/static/css/reportcalculation.css">
        
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
                                                <h2><u>Carbon Calculation</u></h2>
                                            </div>
                                        
                                            <div class="carbon">
                                                <h4><u>Carbon Reduction Rate Formula</u></h4>
                                                <div class="formula">
                                                    <div class="Cformula">
                                                        <br>Carbon reduction Rate =
                                                    </div>
                                                    <div class="ans">
                                                        Reduction<sub>p</sub> - Reduction<sub>c</sub><br>
                                                        <hr>
                                                        Duration
                                                    </div>
                                                </div>
                                            </div>
                                        
                                            <div class="third-row">
                                                <div class="water">
                                                    <h4><u>Water Consumption Formula</u></h4>
                                                    <div class="wformula">
                                                        <p>{Water Consumption}m<sup>3</sup> x 0.419kgCo<sub>2</sub>/m<sup>3</sup></p>
                                                    </div>
                                                    <br>
                                                    <div class="wans">
                                                        Carbon factor: 1m<sup>3</sup>+0.419<br>
                                                    </div>
                                                </div>
                                
                                                <div class="electric">
                                                    <h4><u>Electric Consumption Formula</u></h4>
                                                    <div class="eformula">
                                                        <p>{Electricity Consumption}kWh x <br>0.548 kgCO<sub>2</sub>/ kWh</p>
                                                    </div>
                                                    <br>
                                                    <div class="eans">
                                                        Carbon factor: 1 KWh = 0.584
                                                    </div>
                                                </div>
                                            </div>
                                
                                            <div class="recycle">
                                                <h4><u>Recycle Activity Formula</u></h4>
                                                <div class="rformula">
                                                    <p>{Recycle Weight}kg x 2.860 kgCO<sub>2</sub>/ kg</p>
                                                </div>
                                                <br>
                                                <div class="rans">
                                                    Carbon factor: 1 Kg = 0.286
                                                </div>
                                            </div>
                                        
                                        <div class="button-container">
                                            <!-- <button class="calculate-button" onclick="location.href='calculate-page.html'">Calculate</button> -->
                                            <button class="calculate-button" onclick="location.href='/reportviewanalysis'">Calculate</button>
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