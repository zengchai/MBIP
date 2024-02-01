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
        <% ArrayList<String> resident= new ArrayList<String>();
            resident.add("Tia");
            resident.add("Suhaib");
            resident.add("Yong");%>
        <% ArrayList<String> location= new ArrayList<String>();
            location.add("Taman Jelita");
            location.add("Taman U");
            location.add("Taman Wang");%>
        <% ArrayList<Double> water= new ArrayList<Double>();
            water.add(121.0);
            water.add(225.5);
            water.add(203.5);%>
        <% ArrayList<Double> electric= new ArrayList<Double>();
            electric.add(121.0);
            electric.add(432.0);
            electric.add(213.2);%>
        <% ArrayList<Double> recycle= new ArrayList<Double>();
            recycle.add(5401.0);
            recycle.add(21.0);
            recycle.add(68.0);%>
        <% ArrayList<Double> carbonReductionRate= new ArrayList<Double>();
            carbonReductionRate.add(79.0);
            carbonReductionRate.add(19.0);
            carbonReductionRate.add(23.0);%>

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

                                                <h2><U>Pertandingan Kalender Rendah Karbon Iskandar Puteri</U></h2>
                                            </div>
                                                <div class="subhead>">
                                                    <h4><p>Select top winners  for Pertandingan Kalendar Rendah Karbon Iskandar Puteri</p></h4>
                                                </div>
                                                <div class="container">
                                                
                                                    <div class="search-bar" style="display: flex; align-items: center; margin-top: 1rem;">
                                                        <img style="margin-right: 0.5rem;" src="/static/asset/filter.png" alt="filterimg">
                                                        <input style="border-radius: 0.4rem;" type="text" placeholder="Search...">
                                                    </div>
                                                    
                                                <div class="infotable">
                              
                                                
                                                    <table>
                                                        <tr>
                                                          <th>Residents</th>
                                                          <th>Location</th>
                                                          <th>Water consumption</th>
                                                          <th>Electricity consumption</th>
                                                          <th>Amount recycling</th>
                                                          <th>Carbon Reduction Rate</th>
                                                          <th>Select winners</th>
                                                        </tr>
                                                        <tr>
                                                            <td><%= resident.get(0) %></td>
                                                            <td><%= location.get(0) %></td>
                                                            <td><%= water.get(0) %></td>
                                                            <td><%= electric.get(0) %></td>
                                                            <td><%= recycle.get(0) %></td>
                                                            <td><%= carbonReductionRate.get(0) %></td>
                                                            <td><input type="checkbox" name="selectCheckbox" value="<%= resident.get(0) %>"></td>
                                                        </tr>
                                                        <tr>
                                                            <td><%= resident.get(1) %></td>
                                                            <td><%= location.get(1) %></td>
                                                            <td><%= water.get(1) %></td>
                                                            <td><%= electric.get(1) %></td>
                                                            <td><%= recycle.get(1) %></td>
                                                            <td><%= carbonReductionRate.get(1) %></td>
                                                            <td><input type="checkbox" name="selectCheckbox" value="<%= resident.get(1) %>"></td>
                                                        </tr>
                                                        <tr>
                                                            <td><%= resident.get(2) %></td>
                                                            <td><%= location.get(2) %></td>
                                                            <td><%= water.get(2) %></td>
                                                            <td><%= electric.get(2) %></td>
                                                            <td><%= recycle.get(2) %></td>
                                                            <td><%= carbonReductionRate.get(2) %></td>
                                                            <td><input type="checkbox" name="selectCheckbox" value="<%= resident.get(2) %>"></td>
                                                        </tr>
                                                      </table>
                                                    </div>
                                                </div>
                                                <div><button onclick="showPopup()" style="align-items:center ;">confirm</button>
                                                </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </main>
                </div>
    
            <script>
                function showPopup() {
                    var selectedResidents = document.querySelectorAll('input[name="selectCheckbox"]:checked');
                    if (selectedResidents.length > 0) {
                        var winners = Array.from(selectedResidents).map(function (checkbox) {
                            return checkbox.value;
                        });
                        alert("Selected winners: " + winners.join(", "));
                        // Add logic to show the popup or perform other actions
                    } else {
                        alert("Please select at least one winner.");
                    }
                }
            </script>
        </body>
</html>