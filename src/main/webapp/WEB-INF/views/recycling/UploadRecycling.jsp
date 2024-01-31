<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Upload Recycling Bill Page</title>
    <link rel="stylesheet" type="text/css" href="/static/css/recyclingbill.css">
</head>
<body>
    <%@ include file="/WEB-INF/views/header.jsp" %> 
    <main>
    <div class="main-content">
        <%@ include file="/WEB-INF/views/userSideBar.jsp" %> 
            <div class="left-container">
                <div class="logo-container">
                    <img src="/static/asset/back.png" alt="Back Logo" class="logo">
                </div>    
            </div>
            <div class="right-container">
                <div class="title">
                    <h1>Recycling bill</h1>
                    <p>Please enter your recycling bill as proof</p>
                </div>
                <div class="example">
                    <img src="/static/asset/electricitybill.png" alt="Example Picture">
                    <p>Example</p>
                </div>

                <c:choose>
                    <c:when test="${mode eq 'add'}">
                        <c:set var="action" value="/recycling/uploadRecyclingImage" />
                    </c:when>
                    <c:otherwise>
                        <c:set var="action" value="/recycling/editRecyclingImage" />
                    </c:otherwise>
                </c:choose>

                <div class="upload">
                    <form action="${action}" method="post" enctype="multipart/form-data" id="uploadForm">
                        <input type="file" style="width: 50em;" name="file" id="file" accept=".pdf, .png, .jpg, .jpeg" value="${recycling.getImageName()}" required>
                        <input type="submit" style="width: 50em;" name="submit" value="Upload">
                        <p class="upload-info"><span class="exclamation-sign">! </span>  Filetype should be pdf. File size should not exceed 2 MB <span class="exclamation-sign">!</span></p>

                    </form>
                </div>

            </div>
        </div>
    </main>
</body>
</html>
