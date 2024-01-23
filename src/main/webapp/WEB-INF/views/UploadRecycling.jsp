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
    <jsp:include page="header.jsp" />    
<main>
    <div class="main-content">
        <jsp:include page="userSideBar.jsp" />
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

                <c:set var="action" value="/recycling/uploadRecyclingImage" />

                <div class="upload">
                    <form action="${action}" method="post" enctype="multipart/form-data" id="uploadForm">
                        <input type="file" style="width: 50em;" name="file" id="file" accept=".pdf, .png, .jpg, .jpeg" required>
                        <input type="submit" style="width: 50em;" name="submit" value="Upload">
                        <p class="upload-info"><span class="exclamation-sign">! </span>  Filetype should be pdf. File size should not exceed 2 MB <span class="exclamation-sign">!</span></p>

                    </form>
                </div>

            </div>
        </div>
    </main>
</body>
</html>
