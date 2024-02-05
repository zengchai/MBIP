<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ include file="/WEB-INF/views/common/auth.jsp" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Recycling Page</title>
<link rel="stylesheet" href="/static/common/css/materialize.min.css">
<link rel="stylesheet" type="text/css" href="/static/css/timeline.css">
<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">

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
                                        <table>
                                            <tr>
                                                <th>Edit Event Information</th>
                                            </tr>
                                            <tr>
                                                <td>
                                                    <form id="editForm" action="/updateEvent" method="POST">
                                                        <div class="form-title">
                                                            <label for="editTitle" style="margin-bottom: 10px;">Edit Event Title :</label>
                                                            <input type="text" id="editTitle" value="${param.title}" name="title" style="width: 100%;" required>
                                                        </div>
                                                        <div class="form-desc">
                                                            <label for="editdescription" style="margin-bottom: 10px;">Description
                                                                of that Event:</label>
                                                            <textarea id="description" value="${param.description}" name="description"
                                                                rows="4" style="width: 100%;" required></textarea>
                                                        </div>                                                                                                                                                                                                  <div class="form-date">
                                                            <label for="editdate" style="margin-bottom: 10px;">Date:</label>
                                                            <input type="date" id="date" value="${param.month}" name="month"
                                                                style="width: 100%;" required>
                                                        </div>
                                                            <button type="submit">Update Event</button>
                                                    </form>
                                                </td>
                                            </tr>
                                        </table>
                                </div>
                            </div>
                        </div>
                    </div>
                </main>
            </div>

</body>
</html>

