<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Upload Electrical Bill Page</title>
    <link rel="stylesheet" type="text/css" href="/static/css/electricitybill.css">
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
                    <h1>Electrical bill</h1>
                    <p>Please enter your electrical bill as proof</p>
                </div>
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
                        <input type="file" style="width: 50em;" name="file" id="file" accept=".pdf, .png, .jpg, .jpeg" value="${electrical.getImageName()}" required>
                        <input type="submit" style="width: 50em;" name="submit" value="Upload">
                        <p class="upload-info"><span class="exclamation-sign">! </span>  Filetype should be pdf. File size should not exceed 2 MB <span class="exclamation-sign">!</span></p>

        <div class="page-wrapper" id="main-wrapper" data-layout="vertical" data-navbarbg="skin6"
                    data-sidebartype="full" data-sidebar-position="fixed" data-header-position="fixed">
                    <main>
                        <div class="main-content">
                            <%@ include file="/WEB-INF/views/common/userSideBar.jsp" %>
                            <div class="right-container">
                                <div class="container-fluid">
                                    <div class="card">
                                        <div class="card-body">
                                            <div class="title">
                                                <h1>Electricity bill</h1>
                                                <p>Please enter your electricity bill as proof</p>
                                            </div>
                                            <div class="example">
                                                <img src="/static/asset/electricitybill.png" alt="Example Picture">
                                                <p>Example</p>
                                            </div>
                                            <c:set var="action" value="/electrical/uploadElectricalImage" />
                                            <div class="upload">
                                                <form action="${action}" method="post" enctype="multipart/form-data" id="uploadForm">
                                                    <input type="file" style="width: 50em;" name="file" id="file" accept=".pdf, .png, .jpg, .jpeg" required>
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
<<<<<<< HEAD:src/main/webapp/WEB-INF/views/electrical/UploadElectricity.jsp

            </div>
        </div>
=======
>>>>>>> 11bcfa12ce99ccb6d9142f915e3184a5f9ede671:src/main/webapp/WEB-INF/views/UploadElectricity.jsp
    </main>
</body>
</html>
