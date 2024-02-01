<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page import="java.util.ArrayList" %>

<%@ page import="java.io.IOException" %>

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Report Analysis Page</title>
        <link rel="stylesheet" type="text/css" href="/static/css/reportviewanalysis.css">
        
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
    <% ArrayList<String> consumption= new ArrayList<String>();
        consumption.add("Water(L)");
        consumption.add("Electricity(kWh)");
        consumption.add("Recycle(kg)");
        consumption.add("Participation(people)");%>
    <% ArrayList<Double> consumptionvalue= new ArrayList<Double>();
        consumptionvalue.add(240.65);
        consumptionvalue.add(245.21);
        consumptionvalue.add(54.00);
        consumptionvalue.add(114.00);%>
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
                                                <h2><U>Carbon Calculation</U></h2>
                                            </div>
                                                    <div class="infotable">
                                                        <table>
                                                            <tr>
                                                                <th class="table-heading">
                                                                    Consumptions
                                                                </th>
                                                            </tr>
                                                            <tr>
                                                                <td>
                                                                    <div class="info-row">
                                                                        <div class="name"><%=consumption.get(0)%></div>
                                                                        <div class="value"><%=consumptionvalue.get(0)%></div>
                                                                    </div>
                                                                </td>
                                                            </tr>
                                                            <tr>
                                                                <td>
                                                                    <div class="info-row">
                                                                        <div class="name"><%=consumption.get(1)%></div>
                                                                        <div class="value"><%=consumptionvalue.get(1)%></div>
                                                                    </div>
                                                                </td>
                                                            </tr>
                                                            <tr>
                                                                <td>
                                                                    <div class="info-row">
                                                                        <div class="name"><%=consumption.get(2)%></div>
                                                                        <div class="value"><%=consumptionvalue.get(2)%></div>
                                                                    </div>
                                                                </td>
                                                            </tr>
                                                            <tr>
                                                                <td>
                                                                    <div class="info-row">
                                                                        <div class="name"><%=consumption.get(3)%></div>
                                                                        <div class="value"><%=consumptionvalue.get(3)%></div>
                                                                    </div>
                                                                </td>
                                                            </tr>
                                                        </table>
                                                    </div>
                                                    <div class="infotable">
                                                        <table>
                                                            <tr>
                                                                <th class="table-heading">
                                                                    Details
                                                                </th>
                                                            </tr>
                                                            <tr>
                                                                <td>
                                                                    <div class="content">
                                                                        <div class="reduction">
                                                                            <div class="subhead">Potential emission reduction</div>
                                                                            <hr>
                                                                            <div class="data"> 2,435,454<sub>tc02eq</sub></div>
                                                                        </div>
                                                                        <div class="ghgemission">
                                                                            <div class="subhead">Potential reduction on absolute GHG emission</div>
                                                                            <hr>
                                                                        <div class="data">  41% <sub>by 2030</sub></div>
                                                                        </div>
                                                                    </div>
                                                                </td>
                                                            </tr>
                                                            
                                                        </table>
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