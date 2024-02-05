<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" isELIgnored="false" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

    <%@ include file="/WEB-INF/views/common/auth.jsp" %>
        <%@ page import="java.util.ArrayList" %>

            <%@ page import="java.io.IOException" %>
                <%@ page import="java.util.Date" %>
                    <%@ page import="java.text.SimpleDateFormat" %>

                        <!DOCTYPE html>
                        <html lang="en">

                        <head>
                            <meta charset="UTF-8">
                            <meta name="viewport" content="width=device-width, initial-scale=1.0">
                            <link rel="stylesheet" href="/static/common/css/materialize.min.css">
                            <link rel="stylesheet" type="text/css" href="/static/css/timeline.css">
                            <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
                            <title>Timeline</title>

                        </head>

                        <body>

                            <%@ include file="/WEB-INF/views/common/include-first.jsp" %>
                                <%@ include file="/WEB-INF/views/common/header.jsp" %>

                                    <div class="page-wrapper" id="main-wrapper" data-layout="vertical"
                                        data-navbarbg="skin6" data-sidebartype="full" data-sidebar-position="fixed"
                                        data-header-position="fixed">
                                        <main>
                                            <div class="main-content">
                                                <%@ include file="/WEB-INF/views/common/userSideBar.jsp" %>
                                                    <div class="right-container">
                                                        <div class="container-fluid">
                                                            <div class="card">
                                                                <div class="card-body">
                                                                    <div class="title">

                                                                        <h2><U>Timeline</U></h2>
                                                                    </div>

                                                                    <div class="infotable">
                                                                        <c:forEach var="event" items="${timeline}">
                                                                            <table>
                                                                                <tr>
                                                                                    <th class="table-heading">
                                                                                        <div class="event-name">
                                                                                            <c:out
                                                                                                value="${event.getTitle()}">
                                                                                            </c:out>
                                                                                        </div>

                                                                                    </th>
                                                                                </tr>
                                                                                <tr>
                                                                                    <td>
                                                                                        <c:out
                                                                                            value="${event.getDescription()}">
                                                                                        </c:out>
                                                                                        <br><br><br>
                                                                                        <h6 style="text-align: right">
                                                                                            ${event.getMonth()}</h6>
                                                                                    </td>
                                                                                </tr>
                                                                            </table>
                                                                            <br><br>
                                                                        </c:forEach>
                                                                    </div>

                                                                    <div id="myModal" class="modal">
                                                                        <table>
                                                                            <tr>
                                                                                <th>Event Information</th>
                                                                            </tr>
                                                                            <tr>
                                                                                <td>

                                                                                    <form action="/addNewEvent"
                                                                                        method="POST">
                                                                                        <div class="form-title">
                                                                                            <label for="title"
                                                                                                style="margin-bottom: 10px;">Enter
                                                                                                New Event
                                                                                                Information:</label>
                                                                                            <input type="text"
                                                                                                id="title"
                                                                                                value="${sessionScope.timeline.getTitle()}"
                                                                                                name="title"
                                                                                                style="width: 100%;"
                                                                                                required>
                                                                                        </div>

                                                                                        <div class="form-desc">
                                                                                            <label for="description"
                                                                                                style="margin-bottom: 10px;">Description
                                                                                                of that Event:</label>
                                                                                            <textarea id="description"
                                                                                                value="${sessionScope.timeline.getDescription()}"
                                                                                                name="description"
                                                                                                rows="4"
                                                                                                style="width: 100%;"
                                                                                                required></textarea>
                                                                                        </div>
                                                                                        <div class="form-date">
                                                                                            <label for="date"
                                                                                                style="margin-bottom: 10px;">Date:</label>
                                                                                            <input type="date" id="date"
                                                                                                value="${sessionScope.timeline.getMonth()}"
                                                                                                name="month"
                                                                                                style="width: 100%;"
                                                                                                required>
                                                                                        </div>

                                                                                        <button type="submit">Create
                                                                                            Event</button>
                                                                                    </form>
                                                                                </td>
                                                                            </tr>
                                                                        </table>
                                                                        <br><br>

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