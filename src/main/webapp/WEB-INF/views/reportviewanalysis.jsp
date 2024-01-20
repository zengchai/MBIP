<%@ page import="java.util.ArrayList" %>

<%@ page import="java.io.IOException" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Report Analysis Page</title>
        <link rel="stylesheet" type="text/css" href="/static/css/reportviewanalysis.css">
        <style> </style>
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
        <jsp:include page="header.jsp" />
        <div class="main-container">
            <jsp:include page="userSideBar.jsp" />
            <div class="container">
            
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
        </body>
</html>