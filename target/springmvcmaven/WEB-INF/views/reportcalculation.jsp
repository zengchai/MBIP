<%@ page import="java.util.ArrayList" %>

<%@ page import="java.io.IOException" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Report Calculation</title>
        <link rel="stylesheet" type="text/css" href="/css/reportcalculation.css">
        <style>
        </style>
</head>
<body>
    <jsp:include page="header.jsp" />
    <div class="main-container">
        <jsp:include page="userSideBar.jsp" />
        <div class="container">
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
            <button class="calculate-button" onclick="location.href='calculate-page.html'">Calculate</button>
        </div>
        </div>
    </div>
</body>
</html>