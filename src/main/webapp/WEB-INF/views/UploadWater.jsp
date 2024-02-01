<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Upload Water Bill Page</title>
    <link rel="stylesheet" type="text/css" href="/static/css/waterbill.css">
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
                                <div class="title">
                                    <h1>Water bill</h1>
                                    <p>Please enter your water bill as proof</p>
                                </div>
                                <div class="example">
                                    <img src="/static/asset/waterbill.png" alt="Example Picture">
                                    <p>Example</p>
                                </div>
                                
                                <c:set var="action" value="/water/uploadWaterImage" />
                
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

</body>
</html>
