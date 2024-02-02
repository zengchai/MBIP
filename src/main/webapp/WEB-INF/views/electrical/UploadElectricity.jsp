<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" isELIgnored="false" %>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Upload Electrical Bill Page</title>
    <link rel="stylesheet" type="text/css" href="/static/css/electricity.css">
    <style>
        .example {
            display: flex;
            flex-direction: column;
            align-items: flex-start; /* Align text to the left */
            justify-content: center;
            margin-top: 20px;
        }

        .example p {
            margin-top: -5px;
            opacity: 0.7;
            font-size: 0.8em;
            text-align: left;
            margin-left: 275px; /* Adjust margin as needed */
        }

        .example img {
            max-width: 50%;
            height: auto;
            align-self: center; /* Center the image within the container */
        }
        
        .upload {
            display: flex;
            flex-direction: column;
            align-items: center;
            justify-content: center;
        }

        .upload-info {
            text-align: center;
            margin-top: 10px;
            opacity: 0.7; 
            font-size: 0.8em; 
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
                                            <h1>Electrical bill</h1>
                                            <p>Please enter your electrical bill as proof</p>
                                            <div class="example">
                                                <img src="/static/asset/electricitybill.png" alt="Example Picture">
                                                <p>Example</p>
                                            </div>
                            
                                            <c:choose>
                                                <c:when test="${mode eq 'add'}">
                                                    <c:set var="action" value="/electrical/uploadElectricalImage" />
                                                </c:when>
                                                <c:otherwise>
                                                    <c:set var="action" value="/electrical/editElectricalImage" />
                                                </c:otherwise>
                                            </c:choose>
                            
                                            <div class="upload">
                                                <form action="${action}" method="post" enctype="multipart/form-data" id="uploadForm">
                                                    <input type="file" style="width: 50em;" name="file" id="file" accept=".pdf, .png, .jpg, .jpeg" value="${electrical.getImageName()}"required>
                                                    <input type="submit" style="width: 50em;" name="submit" value="Upload">
                                                    <p class="upload-info"><span class="exclamation-sign">! </span>  Filetype should be pdf. File size should not exceed 2 MB <span class="exclamation-sign">!</span></p>
                            
                                                </form>
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
